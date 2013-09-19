package com.lkk.web.vo;

import java.io.File;

/**
 * 企业
 * 
 * @author Warren
 * 
 */

public class UnitInfo{

	// Fields
	private String username;
	private String password;
	private String password2;
	private String name;
	private File logo;
	private String logoContentType;    //上传文件类型
	private String logoFileName;       //上传文件名
	private File unit2dBarcode;
	private String unit2dBarcodeContentType;
	private String unit2dBarcodeFileName;
	private File public2dBarcode;
	private String public2dBarcodeContentType;    //上传文件类型
	private String public2dBarcodeFileName;       //上传文件名
	private String category;
	private String level;
	private File busLicense;
	private String busLicenseContentType;
	private String busLicenseFileName;
	private String idCard;
	private String city;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public File getLogo() {
		return logo;
	}
	public void setLogo(File logo) {
		this.logo = logo;
	}
	public File getUnit2dBarcode() {
		return unit2dBarcode;
	}
	public void setUnit2dBarcode(File unit2dBarcode) {
		this.unit2dBarcode = unit2dBarcode;
	}
	public File getPublic2dBarcode() {
		return public2dBarcode;
	}
	public void setPublic2dBarcode(File public2dBarcode) {
		this.public2dBarcode = public2dBarcode;
	}
	public File getBusLicense() {
		return busLicense;
	}
	public void setBusLicense(File busLicense) {
		this.busLicense = busLicense;
	}
	public String getLogoContentType() {
		return logoContentType;
	}
	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}
	public String getLogoFileName() {
		return logoFileName;
	}
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}
	public String getPublic2dBarcodeContentType() {
		return public2dBarcodeContentType;
	}
	public void setPublic2dBarcodeContentType(String public2dBarcodeContentType) {
		this.public2dBarcodeContentType = public2dBarcodeContentType;
	}
	public String getPublic2dBarcodeFileName() {
		return public2dBarcodeFileName;
	}
	public void setPublic2dBarcodeFileName(String public2dBarcodeFileName) {
		this.public2dBarcodeFileName = public2dBarcodeFileName;
	}
	public String getUnit2dBarcodeContentType() {
		return unit2dBarcodeContentType;
	}
	public void setUnit2dBarcodeContentType(String unit2dBarcodeContentType) {
		this.unit2dBarcodeContentType = unit2dBarcodeContentType;
	}
	public String getUnit2dBarcodeFileName() {
		return unit2dBarcodeFileName;
	}
	public void setUnit2dBarcodeFileName(String unit2dBarcodeFileName) {
		this.unit2dBarcodeFileName = unit2dBarcodeFileName;
	}
	public String getBusLicenseContentType() {
		return busLicenseContentType;
	}
	public void setBusLicenseContentType(String busLicenseContentType) {
		this.busLicenseContentType = busLicenseContentType;
	}
	public String getBusLicenseFileName() {
		return busLicenseFileName;
	}
	public void setBusLicenseFileName(String busLicenseFileName) {
		this.busLicenseFileName = busLicenseFileName;
	}

	

}