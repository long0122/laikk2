package com.lkk.web.vo;

/**
 * 登陆信息
 * @author Warren
 *
 */
public class LoginInfo {
	
	private String name;
	
	private String password;
	
	private String checkCode;
	
	public LoginInfo(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

}
