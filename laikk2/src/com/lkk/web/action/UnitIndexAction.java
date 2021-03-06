package com.lkk.web.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.IAdvertisementDao;
import com.lkk.web.dao.interfaces.IAreaDao;
import com.lkk.web.dao.interfaces.IAttentionDao;
import com.lkk.web.dao.interfaces.ICategoryDao;
import com.lkk.web.dao.interfaces.ICustomCategoryDao;
import com.lkk.web.dao.interfaces.ILevelDao;
import com.lkk.web.dao.interfaces.IRoleDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.Advertisement;
import com.lkk.web.model.Area;
import com.lkk.web.model.Attention;
import com.lkk.web.model.Category;
import com.lkk.web.model.CustomCategory;
import com.lkk.web.model.Level;
import com.lkk.web.model.Role;
import com.lkk.web.model.Unit;
import com.lkk.web.model.User;
import com.lkk.web.utils.FileTools;
import com.lkk.web.utils.MD5;
import com.lkk.web.utils.MsgUtil;
import com.lkk.web.vo.AdvertisementInfo;
import com.lkk.web.vo.CategorysInfo;
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
	private IAreaDao areaDao;
	private IRoleDao roleDao;
	private ILevelDao levelDao;
	private UnitInfo unitInfo = new UnitInfo();
	private Unit unit = new Unit();
	private List<CategorysInfo> categoryList = new ArrayList<CategorysInfo>();
	private ICustomCategoryDao customCategoryDao;
	private List<CustomCategory> customCategoryList = new ArrayList<CustomCategory>();
	private IAdvertisementDao advertisementDao;
	private List<Advertisement> advertisementList;
	private List<Unit> attUnits;
	private List<Attention> attentions;
	private IAttentionDao attentionDao;
	private static final String FILE_URL  = "uploadFile/unitInfo/";
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
		String catrgory = unitInfo.getCategory();
		String level = unitInfo.getLevel();
		String area = unitInfo.getArea();

		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index!gotoReg";
		if (username == null || "".equals(username)) {
			MsgUtil.setFialMsg(request, "用户名不能为空。", backUrl);
			return "indexMsg";
		}
		// check user
		boolean isExists = userDao.checkUserExistsWithName(username.trim());
		if (isExists) {
			MsgUtil.setFialMsg(request, "用户名已被占用，请重新填写。", backUrl);
			return "indexMsg";
		}

		// add user
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5.toMD5(password));
		Role role = roleDao.findByCode(GlobalConstants.ROLE_CODE_06);
		if (role != null)
			user.setRole(role);
		Area a = null;
		if (area != null) {
			a = areaDao.findByCode(area);
			if (a != null)
				user.setArea(a);
		}

		if (catrgory != null) {
			Category category_ = categoryDao.findById(Integer
					.parseInt(catrgory));
			if (category_ != null)
				user.setCategory(category_);
		}
		user.setState("1");
		userDao.add(user);

		// add unit
		Unit u = new Unit();
		User user_ = userDao.loadByUname(username);
		if (user_ != null)
			u.setManager(user_);

		String name = unitInfo.getName();
		String idCard = unitInfo.getIdCard();
		// set name
		if (name != null && !"".equals(name)) {
			u.setName(name);
		}
		// set idCard
		if (!(idCard == null || "".equals(idCard))) {
			u.setIdCard(idCard);
		}


		// upload file
//		File logo = unitInfo.getLogo();
//		File public2dBarcode = unitInfo.getPublic2dBarcode();
//		File unit2dBarcode = unitInfo.getUnit2dBarcode();
		File busLicense = unitInfo.getBusLicense();
		String baseUrl = FILE_URL + username + "/";
		if (busLicense != null && !"".equals(busLicense)) {
			String busLicensePath = FileTools.getFilePath(request, baseUrl,
					busLicense, unitInfo.getBusLicenseFileName());
			u.setBusLicense(busLicensePath);
			System.out.print("-------busLicensePath--------" + busLicensePath);
		} else {
			u.setBusLicense("");
		}

		/*
		 * if (logo != null && !"".equals(logo)) { String logoPath =
		 * FileTools.getFilePath(request, baseUrl, logo,
		 * unitInfo.getLogoFileName()); u.setLogo(logoPath);
		 * System.out.print("-------logo--------"+logoPath); } else {
		 * u.setLogo(""); } if (public2dBarcode != null &&
		 * !"".equals(public2dBarcode)) { String public2dBarcodePath =
		 * FileTools.getFilePath(request, baseUrl, public2dBarcode,
		 * unitInfo.getPublic2dBarcodeFileName());
		 * u.setPublic2dBarcode(public2dBarcodePath);
		 * System.out.print("-------public2dBarcodePath--------"
		 * +public2dBarcodePath); }else{ u.setPublic2dBarcode(""); }
		 * 
		 * if (unit2dBarcode != null && !"".equals(unit2dBarcode)) { String
		 * unit2dBarcodePath = FileTools.getFilePath(request, baseUrl,
		 * unit2dBarcode, unitInfo.getUnit2dBarcodeFileName());
		 * u.setUnit2dBarcode(unit2dBarcodePath);
		 * System.out.print("-------unit2dBarcodePath--------"
		 * +unit2dBarcodePath); }else{ u.setUnit2dBarcode(""); }
		 */

		// get level
		if (level != null && !"".equals(level)) {
			Level l = levelDao.findByCode(level);
			if (l != null)
				u.setLevel(l);
		}
		// set state
		u.setState("1");
		// set create time
		u.setCreateTime(new Timestamp(new Date().getTime()));
		unitDao.add(u);

		backUrl = basePath.toString();
		MsgUtil.setSuccessMsg(request, "注册成功！", backUrl);
		return "indexMsg";
	}

	/**
	 * 企业管理首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String unitIndex() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		} else {
			User u = (User) user;
			if (!GlobalConstants.ROLE_CODE_06.equals(u.getRole().getCode())) {
				MsgUtil.setFialMsg(request, "用户类型不正确。", backUrl);
				return "indexMsg";
			}

			// get unit
			// Object unit_ = (Object)request.getSession().getAttribute(
			// GlobalConstants.SESSION_UNIT_INDEX);
			// if(unit_!=null){
			// unit = (Unit)unit_;
			// }else{
			// unit = unitDao.findByUserId(u.getId());
			// }

		}

		return "unitIndex";
	}

	/**
	 * 跳转到logo上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gotoLogoUpload() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		return "logoUpload";
	}
	/**
	 * logo上传
	 * @return
	 * @throws Exception
	 */
	public String logoUpload() throws Exception {
		Unit unit = (Unit) request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		backUrl = basePath + "main/unit!unitIndex";
		// upload file
		File logo = unitInfo.getLogo();
		String baseUrl = FILE_URL
				+ unit.getManager().getUsername() + "/";
		if (logo != null && !"".equals(logo)) {
			String logoPath = FileTools.getFilePath(request, baseUrl,
					logo, unitInfo.getLogoFileName());
			unit.setLogo(logoPath);
			System.out.print("-------logoPath--------"
					+ logoPath);
		}

		unitDao.update(unit);
		MsgUtil.setSuccessMsg(request, "企业Logo上传成功！", backUrl);
		return "indexMsg";
	}
	/**
	 * 跳转到 二维码上传页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gotoBarcodeUpload() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		return "barcodeUpload";
	}

	/**
	 * 企业二维码上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String unit2dBarcodeUpload() throws Exception {
		Unit unit = (Unit) request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		backUrl = basePath + "main/unit!unitIndex";
		// upload file
		File unit2dBarcode = unitInfo.getUnit2dBarcode();
		String baseUrl = FILE_URL
				+ unit.getManager().getUsername() + "/";
		if (unit2dBarcode != null && !"".equals(unit2dBarcode)) {
			String unit2dBarcodePath = FileTools.getFilePath(request, baseUrl,
					unit2dBarcode, unitInfo.getUnit2dBarcodeFileName());
			unit.setUnit2dBarcode(unit2dBarcodePath);
			System.out.print("-------unit2dBarcodePath--------"
					+ unit2dBarcodePath);
		}

		unitDao.update(unit);
		MsgUtil.setSuccessMsg(request, "企业二维码上传成功！", backUrl);
		return "indexMsg";
	}

	/**
	 * 公众平台二维码上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String public2dBarcodeUpload() throws Exception {
		Unit unit = (Unit) request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		backUrl = basePath + "main/unit!unitIndex";
		// upload file
		File public2dBarcode = unitInfo.getPublic2dBarcode();
		String baseUrl = FILE_URL
				+ unit.getManager().getUsername() + "/";
		if (public2dBarcode != null && !"".equals(public2dBarcode)) {
			String public2dBarcodePath = FileTools.getFilePath(request,
					baseUrl, public2dBarcode, unitInfo
							.getPublic2dBarcodeFileName());
			unit.setPublic2dBarcode(public2dBarcodePath);
			System.out.print("-------public2dBarcodePath--------"
					+ public2dBarcodePath);
		}

		unitDao.update(unit);
		MsgUtil.setSuccessMsg(request,"公众平台二维码上传成功！", backUrl);
		return "indexMsg";
	}

	/**
	 * 跳转到企业简介
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gotoIntroDesplay() throws Exception {
		return "introDesplay";
	}

	/**
	 * 跳转到企业简介编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gotoIntroEdit() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		setCategory();
		return "introEdit";
	}

	private void setCategory() {

		try {
			List<Category> topCategorys = categoryDao.findTopCategories(true);
			if (topCategorys != null) {
				for (Category top : topCategorys) {
					CategorysInfo info = new CategorysInfo();
					info.setCategory(top);
					List<Category> childrenCategorys = categoryDao
							.findByParentId(top.getId(), true);
					if (childrenCategorys != null) {
						info.setChildrenList(childrenCategorys);
					}
					categoryList.add(info);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 企业简介编辑
	 * 
	 * @return
	 * @throws Exception
	 */
	public String introEdit() throws Exception {

		Unit unit = (Unit) request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		
		String name = unitInfo.getName();
		String category = unitInfo.getCategory();
		String intro = unitInfo.getIntro();
		String tel = unitInfo.getTelephone();
		String phone = unitInfo.getPhone();
		String qq = unitInfo.getQq();
		String fax = unitInfo.getFax();
		String addr = unitInfo.getAddr();
		String email = unitInfo.getEmail();

		// set name
		unit.setName(name);
		// set category
		if (!unit.getManager().getCategory().getId().toString()
				.equals(category)
				&& category != null) {
			Category c = categoryDao.findById(Integer.parseInt(category));
			if (c != null) {
				User u = unit.getManager();
				u.setCategory(c);
				userDao.update(u);
			}

		}
		// set intro
		unit.setIntro(intro);
		unit.setTelephone(tel);
		unit.setPhone(phone);
		unit.setQq(qq);
		unit.setFax(fax);
		unit.setAddr(addr);
		unit.setEmail(email);

		// set unitImg
		backUrl = basePath + "main/unit!unitIndex";
		// upload file
		File unitImg = unitInfo.getUnitImg();
		String baseUrl = FILE_URL
				+ unit.getManager().getUsername() + "/";
		if (unitImg != null && !"".equals(unitImg)) {
			String unitImgPath = FileTools.getFilePath(request, baseUrl,
					unitImg, unitInfo.getUnitFileName());
			unit.setUnitImg(unitImgPath);
			System.out.print("-------unitImgPath--------" + unitImgPath);
		}

		unitDao.update(unit);

		MsgUtil.setSuccessMsg(request, "企业简介更新成功！", backUrl);
		return "indexMsg";
	}

	/**
	 * 跳转到 仓库管理
	 * @return
	 * @throws Exception
	 */
	public String gotoStorageEdit() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}
		Unit unit =(Unit)request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		//get custom storage
		customCategoryList = customCategoryDao.findByUnitId(unit.getId());
		
		AdvertisementInfo adInfo = new AdvertisementInfo();
		adInfo.setUnit(unit.getId().toString());
		adInfo.setState(GlobalConstants.STATE_0);
		advertisementList = advertisementDao.findAll(adInfo ,0, 10);
		return "storageEdit";
	}
	
	/**
	 * 跳转到添加关注
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gotoAttentionAdd() throws Exception {
		// check
		Object user = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		String backUrl = basePath + "main/index";
		User u = null;
		if (user == null) {
			MsgUtil.setFialMsg(request, "请先登录，才可正常浏览此页面。", backUrl);
			return "indexMsg";
		}else{
			u =(User)user;
		}
		
		attUnits = unitDao.findByArea(u.getArea().getAreaId());
		
		Unit unit =(Unit)request.getSession().getAttribute(
				GlobalConstants.SESSION_UNIT_INDEX);
		attentions = attentionDao.findAttByUnitId(unit.getId());
		
		return "attentionAdd";
	}
	
	/**
	 * 
	 * 添加关注企业
	 * @return
	 * @throws Exception
	 */
	public String attentionAdd() throws Exception {
		System.out.println("----------add--------------");
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		Unit unit = null;
		String backUrl = basePath + "main/index";
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}else{
			unit = (Unit)request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
		}
		if(unitInfo.getId()==null){
			backUrl = basePath + "main/unit!gotoStorageEdit";
			MsgUtil.setFialMsg(request, "获取ID失败。", backUrl);
			return "indexMsg";
		}
		
		Unit attUnit = unitDao.findById(Integer.parseInt(unitInfo.getId()));
		System.out.println("----"+attUnit);
		System.out.println("----"+unit);
		Attention att = new Attention();
		att.setUnit(unit);
		att.setAttUnit(attUnit);
		attentionDao.add(att);
		
		
		backUrl = basePath + "main/unit!gotoAttentionAdd";
		MsgUtil.setSuccessMsg(request, "关注企业添加成功！", backUrl);
		return "indexMsg";
	}
	
	
	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	public IAreaDao getAreaDao() {
		return areaDao;
	}
	@Resource
	public void setAreaDao(IAreaDao areaDao) {
		this.areaDao = areaDao;
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<CategorysInfo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategorysInfo> categoryList) {
		this.categoryList = categoryList;
	}

	public ICustomCategoryDao getCustomCategoryDao() {
		return customCategoryDao;
	}
	@Resource
	public void setCustomCategoryDao(ICustomCategoryDao customCategoryDao) {
		this.customCategoryDao = customCategoryDao;
	}

	public List<CustomCategory> getCustomCategoryList() {
		return customCategoryList;
	}

	public void setCustomCategoryList(List<CustomCategory> customCategoryList) {
		this.customCategoryList = customCategoryList;
	}

	public IAdvertisementDao getAdvertisementDao() {
		return advertisementDao;
	}
	@Resource
	public void setAdvertisementDao(IAdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}

	public void setAdvertisementList(List<Advertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}

	public List<Unit> getAttUnits() {
		return attUnits;
	}

	public void setAttUnits(List<Unit> attUnits) {
		this.attUnits = attUnits;
	}

	public IAttentionDao getAttentionDao() {
		return attentionDao;
	}
	@Resource
	public void setAttentionDao(IAttentionDao attentionDao) {
		this.attentionDao = attentionDao;
	}

	public List<Attention> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}


}
