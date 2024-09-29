package com.app.persistence;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.aop.ThrowsAdvice;

import com.app.entity.StudentEntity;

public class PersistenceLogicImpl implements PersistenceInterface{
	
	private DataSource dataSource;

	public PersistenceLogicImpl(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	Connection connection = null;
	
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	private static final String INSERT_QUERY = "INSERT INTO studentmanagement(roll,name,grade) values(?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE studentmanagement SET name=?,grade=? WHERE roll=?";
	private static final String SEARCH_QUERY = "SELECT roll,name,grade FROM studentmanagement WHERE roll=?";
	private static final String SEARCHALL_QUERY = "SELECT roll,name,grade FROM studentmanagement";

	


	@Override
	public void addStudent(StudentEntity studentEntity)throws Exception {
		// TODO Auto-generated method stub
		
		try {
			connection = dataSource.getConnection();
			psmt = connection.prepareStatement(INSERT_QUERY);
			psmt.setInt(1, studentEntity.getRoll());
			psmt.setString(2, studentEntity.getName());
			psmt.setInt(3, studentEntity.getGrade());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
//			System.out.println("cannot add student");
			System.out.println(e);
		}
		
		return ;
	}

	@Override
	public void editStudent(Integer roll,String name,Integer grade)throws Exception {
		// TODO Auto-generated method stub
		
		try {
			connection = dataSource.getConnection();
			psmt = connection.prepareStatement(UPDATE_QUERY);
			psmt.setString(1, name);
			psmt.setInt(2, grade);
			psmt.setInt(3, roll);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public StudentEntity searchStudent(Integer id)throws Exception {
		// TODO Auto-generated method stub
		StudentEntity entity = new StudentEntity();
		try {
			connection = dataSource.getConnection();
			psmt = connection.prepareStatement(SEARCH_QUERY);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				entity.setRoll(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setGrade(rs.getInt(3));
			}
			

		} catch (SQLException e) {
			// TODO: handle exception
//			System.out.println("cannot search student");
			System.out.println(e);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Id not found...");
		}
		return entity;
	
	}
	@Override
	public void displayAllStudents()throws Exception {
		// TODO Auto-generated method stub
		List<StudentEntity> entities = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			psmt = connection.prepareStatement(SEARCHALL_QUERY);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				StudentEntity entity = new StudentEntity();

				entity.setRoll(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setGrade(rs.getInt(3));
				
				entities.add(entity);
			}
			for (StudentEntity studentEntity : entities) {
				System.out.println(studentEntity);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.out.println("cannot search student");
		}
		
		
	}
	
	
	
	

}
