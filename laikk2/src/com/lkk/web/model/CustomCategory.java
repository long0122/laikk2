package com.lkk.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * 企业自定义分类表 
 * @author Warren
 *
 */
@Entity
@Table(name="t_custom_category")
public class CustomCategory implements Serializable{
	private int id;
	private String name;
	private Unit unit;
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="unit")
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	@OneToMany(
			fetch=FetchType.LAZY,
			mappedBy="customCategory",
			targetEntity=Advertisement.class
	)
	@Cascade(CascadeType.DELETE_ORPHAN)
	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}
	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	@Column(name = "name", nullable = true, length = 150)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
