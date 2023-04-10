package com.adminOperations.billingOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.connection.ConnectinProvider;

public class BillingOperations {

	 static Connection con =ConnectinProvider.getConnection();
		
	
	
	public static void purchaseItemByUser() throws Exception {
		
		Statement statement = null;
		
			
		String sql ="select * from user";	
		
		statement= con.createStatement();
		
           ResultSet set= statement.executeQuery(sql);
           
           while(set.next()) {
        	   
            String userName= set.getString(1);

              	
           }
			

		
		
		
	}
	
	
	
}
