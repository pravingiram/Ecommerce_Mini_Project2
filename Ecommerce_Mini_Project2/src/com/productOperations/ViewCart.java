package com.productOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.connection.ConnectinProvider;

public class ViewCart {
	   
	    static Connection con = ConnectinProvider.getConnection();

		private ArrayList<Integer> product_id=new ArrayList<Integer>();
		private ArrayList<String> product_name=new ArrayList<String>();
		private ArrayList<String> product_description=new ArrayList<String>();
		private ArrayList<Double> product_price=new ArrayList<Double>();
		private ArrayList<Integer> product_quantity=new ArrayList<Integer>();

	    public ArrayList<Integer> getProduct_id()throws IOException {
			return product_id;
		}

		
		public ArrayList<String> getProduct_name()throws IOException {
			return product_name;
		}

		
		public ArrayList<String> getProduct_description()throws IOException {
			return product_description;
		}

		
		public ArrayList<Double> getProduct_price()throws IOException {
			return product_price;
		}

		public ArrayList<Integer> getProduct_quantity() throws IOException{
			return product_quantity;
		}

		
		
	    

	   public void viewProductCart(){

	    int x=product_id.size();
			if(x!=0)
			{
				System.out.println("YOUR CART IS : \n");
				int i;
				System.out.println("************************************************************************************\n");
				System.out.printf("%-10s%-10s%-20s%-15s%-10s\n", "ID","Name","Description","Price","Quantity_Purchased");
				System.out.println("*************************************************************************************\n");
				for(i=0;i<x;i++)
				{
					System.out.printf("%-10d%-10s%-20s%-15.0f%-10d\n",product_id.get(i),product_name.get(i),product_description.get(i),product_price.get(i),product_quantity.get(i) );
				}
				System.out.println("************************************************\n");
			}
			else
				System.out.println("CART IS EMPTY !");
		

	       }

	       public void removeFromCart(int productsId){


	        int res;
			int x=-1;
			int prevq=0;
			int newq=0;
			res=product_id.indexOf(productsId);
			if(res==-1)
				System.out.println("YOU HAVE NOT PURCHASED THIS PRODUCT !");
			
	            else
	            {
	            	product_id.remove(res);
	            	product_name.remove(res);
	            	product_description.remove(res);
	            	product_price.remove(res);

	                try
	                {
	                    String sql = "SELECT quantity FROM products WHERE id=?";

	                    PreparedStatement ps1=con.prepareStatement(sql);

	                    ps1.setInt(1, productsId);
	                    ResultSet rs=ps1.executeQuery();
	                    while(rs.next())
	                    {
	                        prevq=rs.getInt(1);
	                    }
	                    newq=prevq-product_quantity.get(res);
	                    product_quantity.remove(res);
	                    PreparedStatement ps2=con.prepareStatement("update products set quantity=? where id=?");
	                    ps2.setInt(1, newq);
	                    ps2.setInt(2, productsId);
	                    x=ps2.executeUpdate();
	                }
	                catch(Exception e)
	                {
	                    System.out.println(e);
	                }
	                if(x!=0)
	                    System.out.println("CART UPDATED SUCCESSFULLY !");
	            }
	            



	       }


		public void addToCart(int id2, String name2, String description2, double price2, int productQuantity2) {
			// TODO Auto-generated method stub
		      product_id.add(id2);
		      product_name.add(name2);
		      product_description.add(description2);
		      product_price.add(price2);
		      product_quantity.add(productQuantity2);



			
		}



	}



