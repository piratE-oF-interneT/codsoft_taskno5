package com.app.factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.app.entity.StudentEntity;
import com.app.persistence.PersistenceInterface;

public class InstanceFactory {
	
	private PersistenceInterface persistenceInterface;
	
	
	public InstanceFactory(PersistenceInterface persistenceInterface) {
		super();
		this.persistenceInterface = persistenceInterface;
	}


	public void software() throws Exception {
		
		boolean check = true;
		while(check) {
			Scanner scanner = new Scanner(System.in);
			Integer choice = null;
			
			
			try {
				System.out.println("1. Add new student \n 2. edit student \n 3. search student \n 4. display all");
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				// TODO: handle exception
				
				System.out.println("Incorrect choice/");
				continue;
			}
			
			switch (choice) {
			case 1: {
				
				try {
					StudentEntity entity = new StudentEntity();
					System.out.println("Enter roll : ");
					Integer roll= scanner.nextInt();
					System.out.println("Enter name : ");
					String name = scanner.next();
					System.out.println("Enter Grade : ");
					Integer grade = scanner.nextInt();
					entity.setRoll(roll);
					entity.setName(name);
					entity.setGrade(grade);
					
					persistenceInterface.addStudent(entity);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("database error");
				}
				catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Incorrect input/");
				}
				break;
			}
			case 2 :{
				
				
				
				try {
					System.out.println("Enter roll : ");
					Integer roll= scanner.nextInt();
					System.out.println("Enter new name : ");
					String name = scanner.next();
					System.out.println("Enter new Grade : ");
					Integer grade = scanner.nextInt();
					persistenceInterface.editStudent(roll, name, grade);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Incorrect input..");
				}
				catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Incorrect input..");

				}
				break;
			}
			case 3:{
				
				
				try {
					System.out.println("Enter roll : ");
					Integer roll= scanner.nextInt();
					
					StudentEntity entity = persistenceInterface.searchStudent(roll);
					System.out.println(entity);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("database error");
				}
				catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("incorrect input");
				}
				break;
			}
			case 4:{
				try {
					persistenceInterface.displayAllStudents();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("database error");
				}
				break;
				
				
		    }
			default:
				System.out.println("enter choice between 1 to 4");
			}	
			
			
			System.out.println("Do you want to continue y/n : ");
			String choose = scanner.next();
			if (choose.equals("n")) {
				check=false;
			}
			
		}
		
		
		
	}

}
