package com.lkk.web.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.ICityDao;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.City;
import com.lkk.web.model.User;
import com.lkk.web.utils.MD5;
import com.lkk.web.vo.UserInfo;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Ajax
 * 
 * @author yup
 * 
 */
@Component("ajax")
@Scope("prototype")
public class AjaxAction extends BasicAction implements ModelDriven {

	private String result;
	private ICityDao cityDao;
	private String provinceId;
	private IUserDao userDao;
	private UserInfo userinfo = new UserInfo();
	
	/**
	 * 分页
	 */
	private int startNum;
	private long count;
	private int showSize = GlobalConstants.PAGE_SIZE_INDEX;

	
	public Object getModel() {
		return userinfo;
	}

	/**
	 * 后台 根据省份获得市
	 * 
	 * @return
	 * @throws Exception
	 */
	public String city() throws Exception {
		List<City> list = cityDao.findByProvince(provinceId);
		String str = "";
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			City city = (City) iter.next();
			str += "<option value='" + city.getCityId() + "'>" + city.getCity()
					+ "</option>";
		}
		if (list.isEmpty()) {
			str += "<option value=''>请选择</option>";
		}
		//str += "</select>";
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 * 前台 登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		String str = "fail";
		String msg = "";
		String uname = userinfo.getUsername();
		String pwd = userinfo.getPassword();

		if ("".equals(uname.trim())) {
			msg = "用户名不能为空，请重新输入";
		} else if ("".equals(pwd.trim())) {
			msg = "密码不能为空，请重新输入";
		} else {
			if (userDao.isExist(uname, MD5.toMD5(pwd))) {
				User user = userDao.loadByCodePwd(uname, MD5.toMD5(pwd));
				String state = user.getState();
				if ("0".equals(state)) {
					msg = "无效用户!";
					return "message";
				} else {
					request.getSession().setAttribute(
							GlobalConstants.SESSION_USER_INDEX, user);
					str = "suc";
				}
			} else {
				msg = "用户名或密码错误!";
			}

		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("msg", msg);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ICityDao getCityDao() {
		return cityDao;
	}

	@Resource
	public void setCityDao(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}


	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}


}
