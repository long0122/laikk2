package com.lkk.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Warren
 *
 */
@Entity
@Table(name="t_province")
public class Province implements Serializable{
	private int id;
	private String provinceId;
	private String province;
	private List<User> cities = new ArrayList<User>();
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(
			cascade={CascadeType.PERSIST,CascadeType.MERGE},
			//fetch=FetchType.EAGER,
			mappedBy="province",
			targetEntity=City.class
	)
	public List<User> getCities() {
		return cities;
	}
	public void setCities(List<User> cities) {
		this.cities = cities;
	}
	@Column(name = "provinceid", nullable = true, length = 20)
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	@Column(name = "province", nullable = true, length = 50)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
