package com.usersOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectinProvider;

public class LoginOperations {
	
	 static Connection con =ConnectinProvider.getConnection();
	
	static Scanner scanner = new Scanner(System.in);
	
	public static  void loginUser() throws SQLException {
	
		
		System.out.println("Enter the user name");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		
		System.out.println("Enter the password");
		String password = scanner.nextLine();

		
		PreparedStatement ps1 = null;
		try {
			
			
			ps1= con.prepareStatement("select userName, password from user where userName=? and password=? ");
			ps1.setString(1, userName);
			ps1.setString(2, password);
			
           ResultSet set= ps1.executeQuery();
           
           if(set.next()) {
        	   
              	   String userName1= set.getString(1);
              	   String password2= set.getString(2);

              	   
       		System.out.println("Login successfuly");

           }
			
           else {
             System.out.println("valid UserName and Password try again");
           }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps1.close();
		}
		
		
		
	}

}
