package com.lkk.web.action;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.User;
import com.lkk.web.utils.MD5;
import com.lkk.web.vo.LoginInfo;
import com.opensymphony.xwork2.ModelDriven;

@Component("login")
@Scope("prototype")
public class LoginAction extends BasicAction implements ModelDriven {
	private LoginInfo loginInfo = new LoginInfo();
	private IUserDao userDao;

	/**
	 * 后台登陆
	 */
	@Override
	public String execute() throws Exception {
		String name = loginInfo.getName();
		String password = loginInfo.getPassword();
		password = MD5.toMD5(password);
		String checkCode = loginInfo.getCheckCode();
		String code = (String) request.getSession().getAttribute("checkCode");
		// 验证验证码
		if (true) {
		//if (checkCode != null && checkCode.equals(code)) {
			if (userDao.isExist(name, password)) {
				User user = userDao.loadByCodePwd(name, password);
				String state = user.getState();
				if ("0".equals(state)) {
					message = "无效用户!";
					return "message";
				}
				request.getSession().setAttribute(GlobalConstants.SESSION_USER_ADMIN, user);
			} else {
				message = "用户名或密码错误!";
				return "message";
			}
		} else {
			// 验证码输入错误
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out
					.println("<script language='javascript'>alert('验证码输入错误...');window.history.back();</script>");
			out.close();
			return null;
		}

		return "main";
	}

	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
  	   //清空Session
  	  	request.getSession().invalidate();
		return "logout";
	}

	
	
	/**
	 * 前台 注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logoutIndex() throws Exception {
		 //清空Session
  	  	request.getSession().invalidate();
		return "index";
	}
	
	public Object getModel() {
		return loginInfo;
	}

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
