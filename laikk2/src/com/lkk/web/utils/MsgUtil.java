package com.lkk.web.utils;

import javax.servlet.http.HttpServletRequest;

import com.lkk.web.context.GlobalConstants;

/**
 * @author Warren
 */
public class MsgUtil {
	/**
	 * basic msg
	 * @param request
	 * @param title
	 * @param content
	 * @param backUrl
	 */
	public static void setMsg(HttpServletRequest request,String title,String content,String backUrl){
		request.setAttribute(GlobalConstants.SESSION_MSG_TITLE,title);
		request.setAttribute(GlobalConstants.SESSION_MSG_CONTENT,content);
		request.setAttribute(GlobalConstants.SESSION_MSG_URL, backUrl);
	}
	/**
	 * msg for success
	 * @param request
	 * @param content
	 * @param backUrl
	 */
	public static void setSuccessMsg(HttpServletRequest request,String content,String backUrl){
		setMsg(request, "操作成功", content, backUrl);
	}
	/**
	 * msg for failed
	 * @param request
	 * @param content
	 * @param backUrl
	 */
	public static void setFialMsg(HttpServletRequest request,String content,String backUrl){
		setMsg(request, "操作失败", content, backUrl);
	}
	/**
	 * msg for relogin
	 * @param request
	 * @param backUrl
	 */
	public static void setReLoginMsg(HttpServletRequest request,String backUrl){
		setMsg(request, "操作失败", "请先登录，才可正常浏览此页面。", backUrl);
	}
}
