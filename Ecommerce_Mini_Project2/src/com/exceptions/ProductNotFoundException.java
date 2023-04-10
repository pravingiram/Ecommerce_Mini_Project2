package com.exceptions;

public class ProductNotFoundException  extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String msg)
	{
		super(msg);
	}

	public String toString()
	{
		return "PRODUCT NOT FOUND :";
	}

	

}
