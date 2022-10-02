package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewProduct {

	
	public void addProduct() throws SQLException, ClassNotFoundException
	{
		try 
		{
			System.out.println("*******************Enter The Data*******************");
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter Product Name:");
	        String pName=scanner.nextLine();
	        System.out.print("Enter Price :");
	        String price=scanner.nextLine();
	        System.out.print("Enter Category:");
	        String cat=scanner.nextLine();
	        System.out.print("Enter quantity:");
	        int quant=scanner.nextInt();
	        String quant1=Integer.toString(quant); 
	        
	        Db_Connection db_Connection=new Db_Connection();
			Connection con=db_Connection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product(description,price,categories,quantity)values(?,?,?,?)");
			ps.setString(1,pName);
			ps.setString(2,price);
			ps.setString(3,cat);
			ps.setString(4,quant1);
			
		    ps.executeUpdate();
		    
		    System.out.println("Product Added Successful!!!!");

		}
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		}

        
	}

}
