package com.lkk.web.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicPageAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.IAdvertisementDao;
import com.lkk.web.dao.interfaces.ICustomCategoryDao;
import com.lkk.web.model.Advertisement;
import com.lkk.web.model.CustomCategory;
import com.lkk.web.model.Unit;
import com.lkk.web.model.User;
import com.lkk.web.utils.FileTools;
import com.lkk.web.utils.MsgUtil;
import com.lkk.web.vo.AdvertisementInfo;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 前台
 * Advertisement Action
 * 
 * @author Warren
 * 
 */
@Component("adIndex")
@Scope("prototype")
public class AdvertisementIndexAction extends BasicPageAction implements ModelDriven {

	private IAdvertisementDao advertisementDao;
	private AdvertisementInfo adInfo = new AdvertisementInfo();
	private Advertisement ad = null;
	private ICustomCategoryDao customCategoryDao;
	private List<CustomCategory> customCategoryList= new ArrayList<CustomCategory>();
	private List<Advertisement> advertisementList = new ArrayList<Advertisement>();
	private  static final String  FILR_URL = "uploadFile/advertisement/";
	
	/**
	 * 跳转到添加页面
	 * @return
	 * @throws Exception
	 */
	public String gotoAdd() throws Exception {
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		String backUrl = basePath + "main/index";
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}
	
		return "adAdd";
	}

	/**
	 * 添加商品
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		User user = null;
		Unit unit = null;
		String backUrl = basePath + "main/ad!gotoAdd";
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}else{
			user = (User)user_;
			unit = (Unit)request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
		}
		
		Advertisement advertisement = new Advertisement();
		advertisement.setTitle(adInfo.getTitle());
		advertisement.setContent(adInfo.getContent());
		advertisement.setPrice(adInfo.getPrice());
		advertisement.setPricePro(adInfo.getPricePro());
		// upload file
		File pic = adInfo.getPicture();
		String baseUrl = FILR_URL + user.getUsername() + "/";
		if (pic != null && !"".equals(pic)) {
			String picPath = FileTools.getFilePath(request, baseUrl,
					pic, adInfo.getPictureFileName());
			advertisement.setPicture(picPath);
			System.out.print("-------picPath--------"
					+ picPath);
		}
		
		//set state
		advertisement.setState(adInfo.getState());
		
		//set time
		advertisement.setCreateTime(new Timestamp(new Date().getTime()));
		
		advertisement.setUnit(unit);
		advertisement.setArea(user.getArea());
		advertisement.setCategory(user.getCategory());
		advertisement.setNumlook(0);
		advertisementDao.add(advertisement);
		
		backUrl = basePath + "main/unit!gotoStorageEdit";
		MsgUtil.setSuccessMsg(request, "商品添加成功！", backUrl);
		return "indexMsg";
	}
	
	/**
	 * 跳转到自定义商品录入界面
	 * @return
	 * @throws Exception
	 */
	public String gotoCustomAdd() throws Exception {
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		String backUrl = basePath + "main/index";
		Unit unit = null;
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}else{
			unit =(Unit)request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
		}
	
		customCategoryList = customCategoryDao.findByUnitId(unit.getId());
		return "adCustomAdd";
	}
	
	
	/**
	 * 自定义产品添加
	 * @return
	 * @throws Exception
	 */
	public String customAdd() throws Exception {
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		User user = null;
		Unit unit = null;
		String backUrl = basePath + "main/ad!gotoCustomAdd";
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}else{
			user = (User)user_;
			unit = (Unit)request.getSession().getAttribute(
					GlobalConstants.SESSION_UNIT_INDEX);
		}
		
		Advertisement advertisement = new Advertisement();
		advertisement.setTitle(adInfo.getTitle());
		advertisement.setContent(adInfo.getContent());
		advertisement.setPrice(adInfo.getPrice());
		advertisement.setPricePro(adInfo.getPricePro());
		// upload file
		File pic = adInfo.getPicture();
		String baseUrl = FILR_URL + user.getUsername() + "/";
		if (pic != null && !"".equals(pic)) {
			String picPath = FileTools.getFilePath(request, baseUrl,
					pic, adInfo.getPictureFileName());
			advertisement.setPicture(picPath);
			System.out.print("-------picPath--------"
					+ picPath);
		}
		
		//set customStorag
		CustomCategory cc = customCategoryDao.findById(Integer.parseInt(adInfo.getCustomStorage()));
		advertisement.setCustomCategory(cc);
		//set state
		advertisement.setState(GlobalConstants.STATE_3);
		
		//set time
		advertisement.setCreateTime(new Timestamp(new Date().getTime()));
		
		advertisement.setUnit(unit);
		advertisement.setArea(user.getArea());
//		advertisement.setCategory(user.getCategory());
		advertisement.setNumlook(0);
		advertisementDao.add(advertisement);
		
		backUrl = basePath + "main/unit!gotoStorageEdit";
		MsgUtil.setSuccessMsg(request, "商品添加成功！", backUrl);
		return "indexMsg";
	}
	
	/**
	 * 根据自定义类别显示商品
	 * @return
	 * @throws Exception
	 */
	public String customEditList() throws Exception {
		Object basePath = request.getSession().getAttribute(
				GlobalConstants.SESSION_BASEPATH);
		Object user_ =request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INDEX);
		String backUrl = basePath + "main/index";
		Unit unit = null;
		if(user_==null){
			MsgUtil.setReLoginMsg(request, backUrl);
			return "indexMsg";
		}
		
		//String customStorageId = adInfo.getCustomStorage();
		advertisementList = advertisementDao.findAll(adInfo, 0, 6);
		return "adCustomEditList";
	}
	
	
	/**
	 * 前台 显示详情
	 */
	public String showDetails() throws Exception {
//		ad = advertisementDao.findById(Integer.parseInt(adInfo.getId()));
//		Object width = request.getSession().getAttribute(GlobalConstants.SESSION_WINDOW_WIDTH);
//		//if window width > 800
//		if(width!=null&&Integer.parseInt(width.toString())>=1200){
//			return "indexShowWsDetails";
//		}else{
//			return "indexShowDetails";
//		}
		
		return null;
	}


	public Object getModel() {
		return adInfo;
	}

	public IAdvertisementDao getAdvertisementDao() {
		return advertisementDao;
	}

	@Resource
	public void setAdvertisementDao(IAdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	public AdvertisementInfo getAdInfo() {
		return adInfo;
	}

	public void setAdInfo(AdvertisementInfo adInfo) {
		this.adInfo = adInfo;
	}


	public Advertisement getAd() {
		return ad;
	}

	public void setAd(Advertisement ad) {
		this.ad = ad;
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

	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}

	public void setAdvertisementList(List<Advertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}







}
