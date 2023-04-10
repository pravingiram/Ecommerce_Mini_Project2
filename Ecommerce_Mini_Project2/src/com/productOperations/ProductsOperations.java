package com.productOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.exceptions.*;
import com.Dashboard;
import com.connection.ConnectinProvider;

public class ProductsOperations {

	   private  int id;
	   private  String name;
	   private  String description;
	   private  double price;
	   private int productQuantity;

	
	   Connection con = ConnectinProvider.getConnection();
	  Scanner scanner = new Scanner(System.in);

	
	public void getBuyProducts() throws SQLException, Exception {

		System.out.println("Enter the product id to buy product"); 

		  int productId = scanner.nextInt();

	   System.out.println("Enter the product quantity"); 
		   productQuantity = scanner.nextInt();
		  
		  System.out.println("Do You want to view cart details (0->No & 1->Yes)"); 
		  int viewCart = scanner.nextInt();

       int x=0;
		
		PreparedStatement preparedStatement = null;
		
			

			String sql = "SELECT * FROM products WHERE id=?";
		      
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			
			  ResultSet rs= preparedStatement.executeQuery();
			  
			  
			  if(rs.last()) {
			    	x=rs.getRow();
			    	rs.beforeFirst();
			     }
			     if(x==0) {
                 
			    	   throw new ProductNotFoundException("Products not found by id");
			    	 
			     }else {

                  while(rs.next()) {
                  	
                  id = rs.getInt(1);
                  name =rs.getString(2);
					description =rs.getString(3);
					price = rs.getDouble(4);
				
					 System.out.println("The Product Id : " + id);
					 System.out.println("The Product Name : " + name);
					 System.out.println("The Product Description : " + description);
					 System.out.println("The Product Price : " + price);
					 System.out.println("Buy product Quantity : " +productQuantity);
					 System.out.println();
					 
				       addProductToCart(id, name, description, price, productQuantity);
				       
					 
                   }
			

                  if(viewCart==1) {
                  	
                	  confirmOrder();
                  }
                    else {
                  	System.out.println("don't view cart try again...");
            		Dashboard.dashBoardView();

                  }
			  
			     }
		 
	    
	 }


	private void addProductToCart(int id2, String name2, String description2, double price2, int productQuantity2) {
		
		   ViewCart viewCarts =  new ViewCart();
	       
		   viewCarts.addToCart(id2, name2, description2, price2, productQuantity2);
		   viewCarts.viewProductCart();
	
	}


	public void confirmOrder() throws Exception {
	

		System.out.println("1) Proceed to Add cartt\n0) CANCEL ORDER & BACK TO DASHBORAD".toUpperCase());
        switch(scanner.nextInt())
        {
            case 1:
                System.out.println("Product Add to cart successsfully");
            break;
            case 0:
        		Dashboard.dashBoardView();

            break;
            default:
                System.out.println("Invalid choice");
            break;
        }
        

	}
	
	
	
	
	
}

