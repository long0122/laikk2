package com.lkk.web.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Category category;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String state;
	private User manager;
	private Date validity;

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


	@ManyToOne(fetch = FetchType.LAZY)
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
	@JoinColumn(name = "category")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

}