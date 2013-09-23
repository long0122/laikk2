package com.lkk.web.model;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *广告表
 * 
 * @author Warren
 * 
 */
@Entity
@Table(name = "t_ad")
public class Advertisement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String picture;
	private String title;
	private Area area;
	private Category category;
	private Unit unit;
	/**
	 * 状态 0-在仓库 1- 已上架 2-促销中3-自定义商品
	 */
	private String state;
	private Timestamp createTime;
	private int numlook;
	private String content;
	private String price;
	private String pricePro;

	private CustomCategory customCategory;
	
	// Constructors

	/** default constructor */
	public Advertisement() {
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

	
	
	
	@Column(name = "picture", length = 100)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "title", length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "area", referencedColumnName = "areaid")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "unit")
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "custom_category")
	public CustomCategory getCustomCategory() {
		return customCategory;
	}

	public void setCustomCategory(CustomCategory customCategory) {
		this.customCategory = customCategory;
	}

	@Column(name = "state", length = 4)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "numlook", length = 10)
	public int getNumlook() {
		return numlook;
	}

	public void setNumlook(int numlook) {
		this.numlook = numlook;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "price", length = 50)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "price_pro", length = 10)
	public String getPricePro() {
		return this.pricePro;
	}

	public void setPricePro(String pricePro) {
		this.pricePro = pricePro;
	}

}