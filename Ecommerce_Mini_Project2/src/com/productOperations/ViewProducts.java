package com.productOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.connection.ConnectinProvider;

public class ViewProducts {
	
	 Connection con = ConnectinProvider.getConnection(); 
	
	 public void getProductItem() throws SQLException {
		
		 int x=0;
		Statement psmt = null;
		try {
			
			String sql ="select * from products order by id";
			psmt = con.createStatement();
		
			ResultSet rs = psmt.executeQuery(sql);
			if(rs.last()) {
		    	x=rs.getRow();
		    	rs.beforeFirst();
		     }
		     if(x==0) {
					System.out.println("No Products Available!..");

		     }else {

 			System.out.println("View The Product Item ");
      	     System.out.println("--------------------------------------------");

			
			while(rs.next()) {
				
				int id= rs.getInt(1);
				 String name= rs.getString(2);
            	 String decription= rs.getString(3);
            	 Double price= rs.getDouble(4);
            	 int quantity= rs.getInt(5);
            	 
            	 System.out.println("Product Id " +id );
            	 System.out.println("Product Name" +name );
            	 System.out.println("Product Description "  + decription);
            	 System.out.println("Product Price " + price );
            	 System.out.println("Product Quantity " + quantity );
            	 System.out.println("--------------------------------------------");

			   }
		     }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			psmt.close();
		}
		
	
		
		
	}

}
