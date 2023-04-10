package com.adminOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectinProvider;

public class AdminOperations {
	
	Connection con =ConnectinProvider.getConnection();
      public Products inputProduct() {
		
  		System.out.println("Enter the Product id");

  		Scanner scanner = new Scanner(System.in);
  		int id = scanner.nextInt();

		System.out.println("Enter the Product Name");
        String name = scanner.nextLine();
		
  		System.out.println("Enter the Product Description");
        String description = scanner.nextLine();
        
        System.out.println("Enter the Product Price");
        Double price = scanner.nextDouble();
        
        System.out.println("Enter the Product quantity");
        int quantity = scanner.nextInt();
        Products product =  new Products(id,name,description,price,quantity);
        
		return product;
        
        }

	
	public String addProduct() throws Exception {
	
    PreparedStatement ps = null;
	try {

		AdminOperations productOperations = new AdminOperations();
		  Products product =   productOperations.inputProduct();
		
		//step 3
	    ps= con.prepareStatement("insert into products(id,name,decription,price,quantity)values(?,?,?,?,?)");
	    ps.setInt(1, product.getId());
		ps.setString(2,product.getName() );
		ps.setString(3, product.getDescription());
		ps.setDouble(4, product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		
		//step 4
		int a = ps.executeUpdate();
		//System.out.println("Insert the Record = " + a);
		
				
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		con.close();
		ps.close();
	}
	
	return "Product Item Add Successfully";

	}
	
	
	public void checkUserIsRegister() throws Exception {

		System.out.println("Enter the user name");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		
		System.out.println("Enter the password");
		String password = scanner.nextLine();

		
		PreparedStatement ps1 = null;
		try {
			
			
			ps1= con.prepareStatement("select * from user where userName=? and password=? ");
			ps1.setString(1, userName);
			ps1.setString(2, password);
			
           ResultSet set= ps1.executeQuery();
           
           if(set.next()) {
        	       int id =set.getInt(1);  
        	       String firstName=set.getString(2);
                   String lastName=set.getString(3);
                   String userName1= set.getString(4);
              	   String password2= set.getString(5);
        	       String city=set.getString(6);
        	       String mailId=set.getString(7);
        	       String mobileNumber=set.getString(8);
        	       
        	       showDetails(id,firstName,lastName,userName1,password2,city,mailId,mobileNumber);
           }
			
           else {
             System.out.println("User not register try again");
           }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps1.close();
		}
		
		

		
	}


	private void showDetails(int id, String firstName, String lastName, String userName1, String password2, String city,
			String mailId, String mobileNumber) {
		
	       System.out.println("UserName : " +userName1);
	       System.out.println("User FirstName : " + firstName);
	       System.out.println("User LastName : " + lastName);
	       System.out.println("User City : " + city);
	       System.out.println("User Email Id : " + mailId);
	       System.out.println("User Mobile : " + mobileNumber);
	       
	}
	
}
