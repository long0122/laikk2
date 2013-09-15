package com.lkk.web.model;

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
 * À¸Ä¿±í
 * @author Warren
 *
 */
@Entity
@Table(name = "t_category")
public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private int orderIndex;
	private String state;
	private String url;
//	private String parent;
	private Category parent;
	// Constructors

	/** default constructor */
	public Category() {
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

	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="parent")
	public Category getParent() {
		return parent;
	}


	public void setParent(Category parent) {
		this.parent = parent;
	}


	@Column(name = "name", length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "order_index", length = 4)
	public int getOrderIndex() {
		return orderIndex;
	}


	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}


	@Column(name = "state", length = 4)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "url", length = 150)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	@Column(name = "parent", length = 10)
//	public String getParent() {
//		return this.parent;
//	}
//
//	public void setParent(String parent) {
//		this.parent = parent;
//	}

}