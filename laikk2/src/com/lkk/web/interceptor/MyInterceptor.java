package com.lkk.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lkk.web.context.GlobalConstants;
import com.lkk.web.utils.CookieUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// System.out.println("Action执行前插入 代码");
		HttpServletRequest request = ServletActionContext.getRequest();
		// set title
		request.getSession().setAttribute("session_title", "来看看-来看看网站");
		// set meta view
		request.getSession().setAttribute("meta_view",
				GlobalConstants.META_VIEW);
		// get base path
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		request.getSession().setAttribute(GlobalConstants.SESSION_BASEPATH,
				basePath);

		
		//set city code
		
		Object city = request.getSession().getAttribute(GlobalConstants.SESSION_CITY_CODE);
		if(city==null){
			Cookie cityId = CookieUtil.getCookie(request, GlobalConstants.INDEX_COOKIE_CITY_ID);
			if(cityId==null){
				request.getSession().setAttribute(GlobalConstants.SESSION_CITY_CODE, GlobalConstants.INDEX_DEFAULT_CITY_ID);
			}else{
				request.getSession().setAttribute(GlobalConstants.SESSION_CITY_CODE,cityId.getValue());
			}
		}
		
		// set link step
		request.getSession().setAttribute("nav_compart", "<img src=\""+basePath+"index/images/breadcrumb.png\">");

		// 执行目标方法 (调用下一个拦截器, 或执行Action)
		final String res = invocation.invoke();

		// System.out.println("Action执行后插入 代码");
		return res;
	}

}
