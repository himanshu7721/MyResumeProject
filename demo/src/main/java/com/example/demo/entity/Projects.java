package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public class Projects implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long project_id;
	private String project_name;
	private String project_role;
	
	//@JsonIgnore
	@ManyToOne(targetEntity=Resume.class,cascade=CascadeType.MERGE)
    @JoinColumn(name = "Resume_id")
	@JsonBackReference(value="selling-item1")
	private Resume resume;
	
	public Projects() {
		super();
	}
	
	public Projects(long project_id, String project_name, String project_role, Resume resume) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_role = project_role;
		this.resume = resume;
	}
	
	
	


	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_role() {
		return project_role;
	}
	public void setProject_role(String project_role) {
		this.project_role = project_role;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
