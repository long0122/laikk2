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
import com.lkk.web.dao.interfaces.IAdvertisementDao;
import com.lkk.web.dao.interfaces.IAreaDao;
import com.lkk.web.dao.interfaces.ICityDao;
import com.lkk.web.dao.interfaces.ICustomCategoryDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.Advertisement;
import com.lkk.web.model.Area;
import com.lkk.web.model.City;
import com.lkk.web.model.CustomCategory;
import com.lkk.web.model.Unit;
import com.lkk.web.model.User;
import com.lkk.web.utils.MD5;
import com.lkk.web.vo.AdvertisementInfo;
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
	private IUnitDao unitDao;
	private String provinceId;
	private IUserDao userDao;
	private UserInfo userinfo = new UserInfo();
	private IAreaDao areaDao;
	private String cityId;
	private String customStorageName;
	private String customStorageId;
	private String unitId;
	private String adState;
	private ICustomCategoryDao customCategoryDao;
	private String customCategoryId;
	private IAdvertisementDao advertisementDao;
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
	 * 根据省份获得市
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
		// str += "</select>";
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 * 根据市获得区
	 * 
	 * @return
	 * @throws Exception
	 */
	public String area() throws Exception {
		List<Area> list = areaDao.findByCity(cityId);
		String str = "";
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Area a = (Area) iter.next();
			str += "<option value='" + a.getAreaId() + "'>" + a.getArea()
					+ "</option>";
		}
		if (list.isEmpty()) {
			str += "<option value=''>请选择</option>";
		}
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
					// get unit
					Unit unit = unitDao.findByUserId(user.getId());
					request.getSession().setAttribute(
							GlobalConstants.SESSION_UNIT_INDEX, unit);

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

	/**
	 * 添加自定义分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String customStorageAdd() throws Exception {
		String str = "fail";
		String msg = "";

		if (customStorageName == null) {
			msg = "分类名称不能为空，请重新输入";
		} else if ("".equals(customStorageName.trim())) {
			msg = "分类名称不能为空，请重新输入";
		} else {
			Object unit_ = request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
			if (unit_ == null) {
				msg = "登陆后才可添加，请重新登录。";
			} else {
				Unit unit = (Unit) unit_;
				CustomCategory custom = new CustomCategory();
				custom.setName(customStorageName);
				custom.setUnit(unit);
				customCategoryDao.add(custom);
				str = "suc";
				msg = "添加成功！";
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("msg", msg);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 * 编辑自定义分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String customStorageEdit() throws Exception {
		String str = "fail";
		String msg = "";

		if (customStorageName == null) {
			msg = "分类名称不能为空，请重新输入";
		} else if ("".equals(customStorageName.trim())) {
			msg = "分类名称不能为空，请重新输入";
		} else if ("".equals(customCategoryId) || customCategoryId == null) {
			msg = "获取ID失败，请重试。";
		} else {
			Object unit_ = request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
			if (unit_ == null) {
				msg = "登陆后才可添加，请重新登录。";
			} else {

				CustomCategory cc = customCategoryDao.findById(Integer
						.parseInt(customCategoryId));
				cc.setName(customStorageName);
				customCategoryDao.update(cc);
				str = "suc";
				msg = "更新成功！";
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("msg", msg);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 * 刪除自定义分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String customStorageDel() throws Exception {
		String str = "fail";
		String msg = "";
		Object unit_ = request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		if (unit_ == null) {
			msg = "登陆后才可添加，请重新登录。";
		} else if ("".equals(customCategoryId) || customCategoryId == null) {
			msg = "获取ID失败，请重试。";
		} else {
			customCategoryDao.deleteById(Integer.parseInt(customCategoryId));
			str = "suc";
			msg = "删除成功！";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("msg", msg);
		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;

	}

	/**
	 * 前台根据类别获得商品列表
	 * @return
	 * @throws Exception
	 */
	public String getAllAdListByCustomCategory() throws Exception {
		String basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH).toString();
		AdvertisementInfo adInfo = new AdvertisementInfo();
		adInfo.setCustomStorage(customCategoryId);
		List<Advertisement> adList = advertisementDao.findAll(adInfo , startNum, showSize);
		
		String str = "";
		if (adList != null && adList.size() > 0) {
			for (Advertisement ad : adList) {
				String pic = ad.getPicture();
				if (pic == null || "".equals(pic)) {
					ad.setPicture(basePath + GlobalConstants.noPic);
				} else if (!pic.contains("http")) {
					ad.setPicture(basePath + pic);
				}
				
				str += "<li>";
				str += "<a href='#'><span><img src=\""+ ad.getPicture()+"\" onerror=\"errpic(this)\" /> <em>"+ad.getTitle()+"</em></span>";
				str += "<div class=\"product_list\">";
				str += "<span><a href='"+basePath+"main/ad!gotoEdit?adType=2&id="+ ad.getId()+"'>编辑</a> " +
						"<a href=\"javascript:window.location.href='"+basePath+"main/ad!del?id="+ ad.getId()+"'\"  onclick=\"return confirm('您确定删除吗?')\">删除</a></span>";
				str += "</div>";
				str += "<div class=\"cl\"></div>";
				str += "</a>";
				str += "</li>";
				
			}
		} else {
			str += "<li>";
			str += "<strong>暂无相关信息</strong>";
			str += "</li>";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);

		// 分页
		if (startNum == -1) {
			startNum = 0;
		}

		if (count == -1) {
			count = advertisementDao.countAll(adInfo);
		}
		if (count >= showSize) {
			startNum = startNum + showSize;
		} else {
			startNum = (int) count;
		}
		map.put("startNum", String.valueOf(startNum));
		map.put("count", String.valueOf(count));

		JSONObject jo = JSONObject.fromObject(map);
		this.result = jo.toString();
		return SUCCESS;
	}
	
	/**
	 * 根据状态获取商品
	 * @return
	 * @throws Exception
	 */
	public String getAllAdListByState() throws Exception {
		String basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH).toString();
		AdvertisementInfo adInfo = new AdvertisementInfo();
		adInfo.setUnit(unitId);
		adInfo.setState(adState);
		List<Advertisement> adList = advertisementDao.findAll(adInfo , startNum, showSize);
		
		String str = "";
		if (adList != null && adList.size() > 0) {
			for (Advertisement ad : adList) {
				String pic = ad.getPicture();
				if (pic == null || "".equals(pic)) {
					ad.setPicture(basePath + GlobalConstants.noPic);
				} else if (!pic.contains("http")) {
					ad.setPicture(basePath + pic);
				}
				
				str += "<li>";
				str += "<a href='#'><span><img src=\""+ ad.getPicture()+"\" onerror=\"errpic(this)\" /> <em>"+ad.getTitle()+"</em></span>";
				str += "<div class=\"product_list\">";
				str += "<span><a href='"+basePath+"main/ad!gotoEdit?adType=1&id="+ ad.getId()+"'>编辑</a> " +
						"<a href=\"javascript:window.location.href='"+basePath+"main/ad!del?id="+ ad.getId()+"'\"  onclick=\"return confirm('您确定删除吗?')\">删除</a></span>";
				str += "</div>";
				str += "<div class=\"cl\"></div>";
				str += "</a>";
				str += "</li>";
				
			}
		} else {
			str += "<li>";
			str += "<strong>暂无相关信息</strong>";
			str += "</li>";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("str", str);

		// 分页
		if (startNum == -1) {
			startNum = 0;
		}

		if (count == -1) {
			count = advertisementDao.countAll(adInfo);
		}
		if (count >= showSize) {
			startNum = startNum + showSize;
		} else {
			startNum = (int) count;
		}
		map.put("startNum", String.valueOf(startNum));
		map.put("count", String.valueOf(count));

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

	public IUnitDao getUnitDao() {
		return unitDao;
	}

	@Resource
	public void setUnitDao(IUnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public IAreaDao getAreaDao() {
		return areaDao;
	}

	@Resource
	public void setAreaDao(IAreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCustomStorageName() {
		return customStorageName;
	}

	public void setCustomStorageName(String customStorageName) {
		this.customStorageName = customStorageName;
	}

	public ICustomCategoryDao getCustomCategoryDao() {
		return customCategoryDao;
	}

	@Resource
	public void setCustomCategoryDao(ICustomCategoryDao customCategoryDao) {
		this.customCategoryDao = customCategoryDao;
	}

	public String getCustomCategoryId() {
		return customCategoryId;
	}

	public void setCustomCategoryId(String customCategoryId) {
		this.customCategoryId = customCategoryId;
	}

	public IAdvertisementDao getAdvertisementDao() {
		return advertisementDao;
	}
	@Resource
	public void setAdvertisementDao(IAdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	public String getCustomStorageId() {
		return customStorageId;
	}

	public void setCustomStorageId(String customStorageId) {
		this.customStorageId = customStorageId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getAdState() {
		return adState;
	}

	public void setAdState(String adState) {
		this.adState = adState;
	}

}
