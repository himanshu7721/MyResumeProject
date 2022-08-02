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
public class Education implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String board_name;
	private String percentage;
	
	//@JsonIgnore
	@ManyToOne(targetEntity=Resume.class,cascade=CascadeType.MERGE)
    @JoinColumn(name = "Resume_id")
	@JsonBackReference(value="selling-item")
	private Resume resume;
	
	public Education() {
		super();
	}
	public Education(long id, String board_name, String percentage, Resume resume) {
		super();
		this.id = id;
		this.board_name = board_name;
		this.percentage = percentage;
		this.resume = resume;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
	

}
