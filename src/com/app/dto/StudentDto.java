package com.app.dto;

import com.app.entity.StudentEntity;

public class StudentDto {
	
	
	private StudentEntity studentEntity;
	
	private Integer roll;
	private String name;
	private String grade;
	
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
