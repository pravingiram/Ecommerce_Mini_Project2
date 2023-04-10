package com.adminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectinProvider;
import com.exceptions.ProductNotFoundException;

public class ProductQuantity {
	
	
	   private static int id;
	   private  String name;
	   private  String description;
	   private  double price;
	   private static int productQuantity;

	  static Connection con = ConnectinProvider.getConnection();
	  static Scanner scanner = new Scanner(System.in);

	public static void checkProductQuantity() throws SQLException, ProductNotFoundException {
		
		
		System.out.println("Enter the product id "); 

		id = scanner.nextInt();
   
		   int x=0;
			
			PreparedStatement preparedStatement = null;
			
				

				String sql = "SELECT quantity FROM products WHERE id=?";
			      
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				  ResultSet rs= preparedStatement.executeQuery();
				  
				  
				  if(rs.last()) {
				    	x=rs.getRow();
				    	rs.beforeFirst();
				     }
				     if(x==0) {
	                 
				    	   throw new ProductNotFoundException("Products not found by id");
				    	 
				     }else {

	                  while(rs.next()) {
	                  	
	                
	                  int quantity =rs.getInt(1);
	                  	 System.out.println("Product Quantity is : " +quantity);
						 System.out.println();
		
						 
	                   }
				
				     }

	}

}
