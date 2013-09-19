package com.lkk.web.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.ICategoryDao;
import com.lkk.web.dao.interfaces.ICityDao;
import com.lkk.web.dao.interfaces.ILevelDao;
import com.lkk.web.dao.interfaces.IRoleDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.Category;
import com.lkk.web.model.City;
import com.lkk.web.model.Level;
import com.lkk.web.model.Role;
import com.lkk.web.model.Unit;
import com.lkk.web.model.User;
import com.lkk.web.utils.FileTools;
import com.lkk.web.utils.MD5;
import com.lkk.web.utils.Tools;
import com.lkk.web.vo.UnitInfo;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Warren
 */
@Component("unitIndex")
@Scope("prototype")
public class UnitIndexAction extends BasicAction implements ModelDriven {
	private IUnitDao unitDao;
	private IUserDao userDao;
	private ICategoryDao categoryDao;
	private ICityDao cityDao;
	private IRoleDao roleDao;
	private ILevelDao levelDao;
	private UnitInfo unitInfo = new UnitInfo();


	
	@Override
	public String execute() throws Exception {

		return null;
	}

	public Object getModel() {
		return unitInfo;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		System.out.println("-------add--------");
		System.out.println(unitInfo.getUsername());
		
		String username = unitInfo.getUsername();
		String password = unitInfo.getPassword();
		String password2 = unitInfo.getPassword2();
		String catrgory = unitInfo.getCategory();

		String city = unitInfo.getCity();

		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index!gotoReg";
		if (username == null || "".equals(username)) {
			request.setAttribute(GlobalConstants.SESSION_MSG_TITLE, "操作失败");
			request.setAttribute(GlobalConstants.SESSION_MSG_CONTENT,
					"用户名不能为空。");
			request.setAttribute(GlobalConstants.SESSION_MSG_URL, backUrl);
			return "indexMsg";
		}
		// check user
		boolean isExists = userDao.checkUserExistsWithName(username.trim());
		if (isExists) {
			request.setAttribute(GlobalConstants.SESSION_MSG_TITLE, "操作失败");
			request.setAttribute(GlobalConstants.SESSION_MSG_CONTENT,
					"用户名已被占用，请重新填写。");
			request.setAttribute(GlobalConstants.SESSION_MSG_URL, backUrl);
			return "indexMsg";
		}

		// add user
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5.toMD5(password));
		Role role = roleDao.findByCode(GlobalConstants.ROLE_CODE_06);
		if (role != null)
			user.setRole(role);
		if (city != null) {
			City c = cityDao.findByCode(city);
			if (c != null)
				user.setCity(c);
		}

		if (catrgory != null) {
			Category category_ = categoryDao.findById(Integer
					.parseInt(catrgory));
			if (category_ != null)
				user.setCategory(category_);
		}
		user.setState("1");
		//userDao.add(user);

		// add unit
		Unit u = new Unit();
		User user_ = userDao.loadByUname(username);
		if (user_ != null)
			u.setManager(user_);

		String name = unitInfo.getName();
		File logo = unitInfo.getLogo();
		File public2dBarcode = unitInfo.getPublic2dBarcode();
		File unit2dBarcode = unitInfo.getUnit2dBarcode();
		File busLicense = unitInfo.getBusLicense();
		String idCard = unitInfo.getIdCard();

		if (!(name == null || "".equals(name))) {
			u.setName(name);
		}
		String baseUrl = "uploadFile/unitInfo/"+username+"/";
		if (logo != null && !"".equals(logo)) {
			String logoPath = FileTools.getFilePath(request, baseUrl, logo, unitInfo.getLogoFileName());
			u.setLogo(logoPath);
			System.out.print("-------logo--------"+logoPath);
		} else {
			u.setLogo("");
		}
		if (public2dBarcode != null && !"".equals(public2dBarcode)) {
			String public2dBarcodePath = FileTools.getFilePath(request, baseUrl, public2dBarcode, unitInfo.getPublic2dBarcodeFileName());
			u.setPublic2dBarcode(public2dBarcodePath);
			System.out.print("-------public2dBarcodePath--------"+public2dBarcodePath);
		}else{
			u.setPublic2dBarcode("");
		}
		
		if (unit2dBarcode != null && !"".equals(unit2dBarcode)) {
			String unit2dBarcodePath = FileTools.getFilePath(request, baseUrl, unit2dBarcode, unitInfo.getUnit2dBarcodeFileName());
			u.setUnit2dBarcode(unit2dBarcodePath);
			System.out.print("-------unit2dBarcodePath--------"+unit2dBarcodePath);
		}else{
			u.setUnit2dBarcode("");
		}
		
		if (busLicense != null && !"".equals(busLicense)) {
			String busLicensePath = FileTools.getFilePath(request, baseUrl, busLicense, unitInfo.getBusLicenseFileName());
			u.setBusLicense(busLicensePath);
			System.out.print("-------busLicensePath--------"+busLicensePath);
		}else{
			u.setBusLicense("");
		}
		
		if (!(idCard == null || "".equals(idCard))) {
			u.setIdCard(idCard);
		}
		// set create time
		u.setCreateTime(new Timestamp(new Date().getTime()));

		// get level
		Level l = levelDao.findByCode(GlobalConstants.LEVLE_CODE_01);
		if (l != null)
			u.setLevel(l);

		//unitDao.add(u);
		// User user = (User) request.getSession().getAttribute(
		// GlobalConstants.SESSION_USER_ADMIN);
		// Unit unit = new Unit();
		// unit.setName(unitInfo.getName().trim());
		// unit.setAuthor(user);
		// unit.setCity(user.getCity());
		// unit.setState("0");
		// Category category = categoryDao.findById(Integer.parseInt(unitInfo
		// .getCategory()));
		// unit.setCategory(category);
		// unit.setAddress(unitInfo.getAddress().trim());
		// String phone = unitInfo.getPhone();
		// if (phone != null && !"".equals(phone)) {
		// unit.setPhone(phone);
		// } else {
		// unit.setPhone("");
		// }
		// unit.setContact(unitInfo.getContact());
		// String DateString = Tools.getCurrentTimeSort();
		// Date date = Tools.getStringToDate(DateString);
		// unit.setCreateTime(new Timestamp(date.getTime()));
		// File file = unitInfo.getFile();
		// if (file != null && !"".equals(file)) {
		// String baseUrl = "uploadFile/";
		// baseUrl += Tools.getCurrentDateSortNoTime() + "/";
		// String picUrl = request.getSession().getServletContext()
		// .getRealPath("/").replace("\\", "/")
		// + baseUrl;
		// String fileName = new Date().getTime()
		// + Tools.getExtention(unitInfo.getFileFileName());
		// File dstFile = FileTools.createFile(picUrl, fileName);
		// FileTools.copy(file, dstFile);
		// unit.setPicture(baseUrl + fileName);
		// } else {
		// unit.setPicture("");
		// }
		// unitDao.add(unit);
		// backUrl = "system/unit!toAdd";
		// return "success";

		request.setAttribute(GlobalConstants.SESSION_MSG_TITLE, "操作成功");
		request.setAttribute(GlobalConstants.SESSION_MSG_CONTENT, "注册成功！");
		backUrl = basePath.toString();
		request.setAttribute(GlobalConstants.SESSION_MSG_URL, backUrl);
		return "indexMsg";
	}

	
	
	
	public ICityDao getCityDao() {
		return cityDao;
	}

	@Resource
	public void setCityDao(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Resource
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public IUnitDao getUnitDao() {
		return unitDao;
	}

	@Resource
	public void setUnitDao(IUnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	@Resource
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public UnitInfo getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(UnitInfo unitInfo) {
		this.unitInfo = unitInfo;
	}

	public ILevelDao getLevelDao() {
		return levelDao;
	}

	@Resource
	public void setLevelDao(ILevelDao levelDao) {
		this.levelDao = levelDao;
	}



}
