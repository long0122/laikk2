package com.lkk.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 * 
 * @author Warren
 *
 */
@Entity
@Table(name="t_level")
public class Level implements Serializable{
	private int id;
	private String name;
	private String code;
	private List<LevelModules> levelModules;
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="level",fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	public List<LevelModules> getLevelModules() {
		return levelModules;
	}
	public void setLevelModules(List<LevelModules> levelModules) {
		this.levelModules = levelModules;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	

}
