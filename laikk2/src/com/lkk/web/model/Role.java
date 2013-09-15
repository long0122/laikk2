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
@Table(name="t_role")
public class Role implements Serializable{
	private int id;
	private String name;
	private String state;
	private String code;
	private List<User> users = new ArrayList<User>();
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
			mappedBy="role",
			targetEntity=User.class
	)
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Column(name = "name", nullable = true, length = 150)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "state", nullable = true, length = 4)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "code", nullable = true, length = 4)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
