package com;

import java.sql.SQLException;
import java.util.Scanner;

import com.adminOperations.AdminOperations;
import com.adminOperations.ProductQuantity;
import com.productOperations.ProductsOperations;
import com.productOperations.ViewCart;
import com.productOperations.ViewProducts;
import com.usersOperations.LoginOperations;
import com.usersOperations.UserOperations;

public class Dashboard {

	
	
	public static void  dashBoardView() throws Exception {
		
		
		
		System.out.println("Welcome to E-Commerce based application");
		
		System.out.println("------------------------------------------------");
		
		System.out.println("User Operation");
		
		System.out.println("1.User Registration");
		System.out.println("2.User login");
		System.out.println("3.User view Product item as Sorted Order");
		System.out.println("4.Buy Product");
		System.out.println("5.View Cart ");
		System.out.println("6.Purchase the item");
		System.out.println("-------------------------------------------------");
		
		System.out.println("Admin Operation");
		
		System.out.println("7.Add product item");
		System.out.println("8.Calculate Bill");
		System.out.println("9.Display amount to End User");
		System.out.println("10.Check Quantity");
		System.out.println("11.Check registered user");
		System.out.println("12.Check the particular user history");
		System.out.println("-------------------------------------------------");
		
		System.out.println("Guest Operation");
		
		System.out.println("13.View product item");
		System.out.println("14.Not purchase item");
		
		System.out.println("-------------------------------------------------");

		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		
		int choice =scanner.nextInt();
		
		switch(choice) {
		case 1 : 
			UserOperations userOperations = new UserOperations();
			String registerUser = userOperations.registerUser();
			System.out.println(registerUser);
			break;
			
		case 2 :
			LoginOperations.loginUser();
			break;
			
		case 3 :
			ViewProducts productItems = new ViewProducts();
			productItems.getProductItem();
			break;
		case 4 :
			ProductsOperations buyProducts=  new ProductsOperations();	
			buyProducts.getBuyProducts();
			break;
			
		case 5 :
			ProductsOperations viewCart=  new ProductsOperations();	
			viewCart.confirmOrder();
			break;
			
		case 6 :
			System.out.println("Purchase the item");
			break;
			
		case 7 :
			
			AdminOperations product = new AdminOperations();
		    String addProduct = product.addProduct();
			System.out.println(addProduct);
			break;
			
		case 8 :
			System.out.println("Calculate Bill");
			break;
			
		case 9 :
			System.out.println("Display amount to End User");
			break;
			
		case 10 :
			ProductQuantity  productQuantity = new ProductQuantity();
			productQuantity.checkProductQuantity();
			break;
			
		case 11 :
			AdminOperations  adminOperations  = new  AdminOperations();
			adminOperations.checkUserIsRegister();
			break;
			
		case 12 :
			System.out.println("Check the particular user history");
			break;
			
		case 13 :
			ViewProducts viewProducts = new ViewProducts();
			viewProducts.getProductItem();
			break;
				
		default:
			System.out.println(" Enter valid  Operations");
			break;
				
		}
		

		
	}
	
}
