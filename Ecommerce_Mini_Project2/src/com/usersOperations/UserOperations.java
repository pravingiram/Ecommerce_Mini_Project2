package com.usersOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectinProvider;

public class UserOperations {

    Connection con =ConnectinProvider.getConnection();
    
public User inputUser() {
		
		System.out.println("Enter the First Name");
		Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        
        System.out.println("Enter the Last Name");
		String lastName = scanner.nextLine();
		
		 System.out.println("Enter the User Name");
		 String userName = scanner.nextLine();
		 
		 System.out.println("Enter the Password");
	     String password = scanner.nextLine();
	     
	     System.out.println("Enter the City");
		 String city = scanner.nextLine();
		 
		 System.out.println("Enter the Mail Id");
		 String email = scanner.nextLine();
		 
		 System.out.println("Enter the Mobile Number");
		 String mobileNumber = scanner.nextLine();
		 
		 User userData = new User(firstName,lastName,userName,password,city,email,mobileNumber);
		 
		return userData;
		
	}

    
    public String registerUser() throws SQLException {
    	
    	PreparedStatement ps = null;
    	try {
    		
    		UserOperations  userInput=  new UserOperations();
    	    User user = userInput.inputUser();
    		
    	    ps = con.prepareStatement("insert into user(firstName,lastName,userName,password,city,mailId,mobileNumber)values(?,?,?,?,?,?,?)");
    		ps.setString(1, user.getFirstName());
    		ps.setString(2, user.getLastName());
    		ps.setString(3, user.getUserName());
    		ps.setString(4, user.getPassword());
    		ps.setString(5, user.getCity());
    		ps.setString(6, user.getEmail());
    		ps.setString(7, user.getMobileNumber());
    		
    		int a = ps.executeUpdate();
    		//System.out.println("Insert the Record " + a);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		con.close();
    		ps.close();
    	}
    	
    	return "User Item Add Successfully";
    	
    }
	
}
