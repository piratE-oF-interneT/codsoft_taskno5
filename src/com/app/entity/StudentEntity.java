package com.app.entity;

public class StudentEntity {
	
	private Integer roll;
	private String name;
	private Integer grade;
	
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "StudentEntity [roll=" + roll + ", name=" + name + ", grade=" + grade + "]";
	}
	
	

}
