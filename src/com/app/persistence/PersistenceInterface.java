package com.app.persistence;

import java.util.List;

import javax.sql.DataSource;

import com.app.entity.StudentEntity;

public interface PersistenceInterface {
	
	public void addStudent(StudentEntity studentEntity)throws Exception;
	
	public void editStudent(Integer roll , String name , Integer grade)throws Exception;
	
	public StudentEntity searchStudent(Integer id)throws Exception;
	
	public void displayAllStudents()throws Exception;
	
	
	
	

}
