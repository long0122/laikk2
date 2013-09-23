package com.lkk.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicPageAction;
import com.lkk.web.context.GlobalConstants;
import com.lkk.web.dao.interfaces.ICategoryDao;
import com.lkk.web.dao.interfaces.ICityDao;
import com.lkk.web.dao.interfaces.IProvinceDao;
import com.lkk.web.dao.interfaces.IRoleDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.Category;
import com.lkk.web.model.City;
import com.lkk.web.model.Province;
import com.lkk.web.model.Role;
import com.lkk.web.model.Unit;
import com.lkk.web.model.User;
import com.lkk.web.utils.MD5;
import com.lkk.web.vo.Pager;
import com.lkk.web.vo.UnitInfo;
import com.lkk.web.vo.UserInfo;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户
 * 
 * @author Warren
 * 
 */
@Component("user")
@Scope("prototype")
public class UserAction extends BasicPageAction implements ModelDriven {

	private UserInfo userinfo = new UserInfo();
	private IUserDao userDao;
	private IRoleDao roleDao;
	private List<User> users = new ArrayList<User>();
	private List<Role> roles = new ArrayList<Role>();
	private User staff = new User();
	private User admin = new User();
	private IProvinceDao provinceDao;
	private List<Province> provinces = new ArrayList<Province>();
	private ICityDao cityDao;
	private List<City> citys = new ArrayList<City>();
	private ICategoryDao categoryDao;
	private IUnitDao unitDao;
	private List<Category> categorys = new ArrayList<Category>();
	private String username;
	private Unit unit;

	/**
	 * list
	 */
	@Override
	public String execute() throws Exception {
		// 分页
		if (isTo.equals("1")) {
			pageNo = pageNoSelect;
		}
		int pageNo_ = Integer.parseInt(pageNo);
		int startIndex = pageSize * (pageNo_ - 1);

		this.users = this.userDao.findAll(startIndex, pageSize);
		long rowCount_ = (long) userDao.countAll();
		int rowCount = (int) rowCount_;

		if (pageNo_ > rowCount) {
			pageNo_ = rowCount;
		}
		pager = new Pager(pageSize, pageNo_, rowCount, users);

		return "list";
	}

	/**
	 * 到搜索界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toSearch() throws Exception {
		request.getSession().removeAttribute(GlobalConstants.SESSION_USER_INFO);
		roles = roleDao.findAll();
		provinces = provinceDao.findAll();
		return "toSearch";
	}

	/**
	 * 搜索
	 * 
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {
		// 分页
		if (isTo.equals("1")) {
			pageNo = pageNoSelect;
		}
		int pageNo_ = Integer.parseInt(pageNo);
		int startIndex = pageSize * (pageNo_ - 1);
		Object userinfo_ = request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_INFO);
		if (userinfo_ != null) {
			userinfo = (UserInfo) userinfo_;
		} else {
			request.getSession().setAttribute(
					GlobalConstants.SESSION_USER_INFO, userinfo);
		}
		this.users = this.userDao.search(startIndex, pageSize, userinfo);
		long rowCount_ = (long) userDao.countSearch(userinfo);
		int rowCount = (int) rowCount_;

		if (pageNo_ > rowCount) {
			pageNo_ = rowCount;
		}
		pager = new Pager(pageSize, pageNo_, rowCount, users);

		return "searchList";
	}

	/**
	 * 删除(查询界面)
	 * 
	 * @return
	 */
	public String deleteForSearch() throws Exception {
		userDao.deleteById(userinfo.getId());
		backUrl = "";
		return "success";
	}
	/**
	 * 查看
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toSee() throws Exception {
		staff = userDao.findById(userinfo.getId());
		return "toSee";
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() throws Exception {
		User user = (User) request.getSession().getAttribute(
				GlobalConstants.SESSION_USER_ADMIN);
		// String code = user.getRole().getCode();
		// String roleCode = "";
		// if(GlobalConstants.ROLE_CODE_01.equals(code)) {
		// roleCode = GlobalConstants.ROLE_CODE_03;
		// }
		// if(GlobalConstants.ROLE_CODE_03.equals(code)) {
		// roleCode = GlobalConstants.ROLE_CODE_04;
		// }
		// if(GlobalConstants.ROLE_CODE_04.equals(code)) {
		// roleCode = GlobalConstants.ROLE_CODE_05;
		// }

		// 分页
		if (isTo.equals("1")) {
			pageNo = pageNoSelect;
		}
		int pageNo_ = Integer.parseInt(pageNo);
		int startIndex = pageSize * (pageNo_ - 1);

		this.users = this.userDao.findByAuthorId(startIndex, pageSize, user
				.getId());
		long rowCount_ = (long) userDao.countByAuthorId(user.getId());
		int rowCount = (int) rowCount_;

		if (pageNo_ > rowCount) {
			pageNo_ = rowCount;
		}
		pager = new Pager(pageSize, pageNo_, rowCount, users);

		return "listByAuthor";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// @Override
	public Object getModel() {
		return userinfo;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	@Resource
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IProvinceDao getProvinceDao() {
		return provinceDao;
	}

	@Resource
	public void setProvinceDao(IProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public ICityDao getCityDao() {
		return cityDao;
	}

	@Resource
	public void setCityDao(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Resource
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public IUnitDao getUnitDao() {
		return unitDao;
	}

	@Resource
	public void setUnitDao(IUnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
