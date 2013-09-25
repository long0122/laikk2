package com.lkk.web.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 企业
 * 
 * @author Warren
 * 
 */
@Entity
@Table(name = "t_unit")
public class Unit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String logo;
	private String unit2dBarcode;
	private String public2dBarcode;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String state;
	private User manager;
	private Date validity;
	private Level level;
	private String busLicense;
	private String idCard;
	private String intro;
	private String telephone;
	private String phone;
	private String unitImg;
	private String qq;
	private String fax;
	private String addr;
	private String email;
	private List<CustomCategory> customCategorys = new ArrayList<CustomCategory>();
	// Constructors

	/** default constructor */
	public Unit() {
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(
			cascade={CascadeType.PERSIST,CascadeType.MERGE},
			fetch=FetchType.LAZY,
			mappedBy="unit",
			targetEntity=CustomCategory.class
	)
	@NotFound(action = NotFoundAction.IGNORE)
	public List<CustomCategory> getCustomCategorys() {
		return customCategorys;
	}

	public void setCustomCategorys(List<CustomCategory> customCategorys) {
		this.customCategorys = customCategorys;
	}
	

	@OneToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "manager")
	public User getManager() {
		return this.manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "level")
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	
	@Column(name = "bus_license", length = 500)
	public String getBusLicense() {
		return busLicense;
	}

	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}
	@Column(name = "id_card", length = 50)
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "state", length = 4)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "validity", length = 10)
	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	@Column(name = "logo")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "unit_2dBarcode")
	public String getUnit2dBarcode() {
		return unit2dBarcode;
	}

	public void setUnit2dBarcode(String unit2dBarcode) {
		this.unit2dBarcode = unit2dBarcode;
	}

	@Column(name = "public_2dBarcode")
	public String getPublic2dBarcode() {
		return public2dBarcode;
	}

	public void setPublic2dBarcode(String public2dBarcode) {
		this.public2dBarcode = public2dBarcode;
	}
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "intro")
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "unit_img")
	public String getUnitImg() {
		return unitImg;
	}

	public void setUnitImg(String unitImg) {
		this.unitImg = unitImg;
	}
	@Column(name = "qq")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name = "addr")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}