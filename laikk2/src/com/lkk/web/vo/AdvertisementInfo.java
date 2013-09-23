package com.lkk.web.vo;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *广告表
 * 
 * @author Warren
 * 
 */
public class AdvertisementInfo implements java.io.Serializable {

	// Fields
	private String id;
	private File picture;
	private String pictureContentType;    //上传文件类型
	private String pictureFileName;       //上传文件名
	private String title;
	private String area;
	/**
	 * 状态 0-在仓库 1- 已上架 2-促销中
	 */
	private String state;
	private String content;
	private String price;
	private String pricePro;
	private String unit;
	private String category;
	private String customStorage;
	// Constructors

	/** default constructor */
	public AdvertisementInfo() {
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureContentType() {
		return pictureContentType;
	}

	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPricePro() {
		return pricePro;
	}

	public void setPricePro(String pricePro) {
		this.pricePro = pricePro;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomStorage() {
		return customStorage;
	}

	public void setCustomStorage(String customStorage) {
		this.customStorage = customStorage;
	}

	

}