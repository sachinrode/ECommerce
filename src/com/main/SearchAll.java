package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchAll {

	public void searchProduct() throws SQLException, ClassNotFoundException
	{
	  DisplayAllProducts dsp=new DisplayAllProducts();
	  dsp.getProductList();
	  
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter pid to search:");
	  String id=sc.next();
	  
	  try 
	  {
		  Db_Connection db_Connection=new Db_Connection();
			Connection con=db_Connection.getConnection();
			//Connection con=null;
			PreparedStatement ps=null;
			List<Products> searchproduct=new ArrayList<>();
			PreparedStatement ps2=con.prepareStatement("select * from product where pid=?");
			ps2.setString(1, id);
		    ResultSet rs=ps2.executeQuery();
		     if(rs.next())
		     {
		    	 searchproduct.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));	
		         System.out.println(searchproduct);
		     }
		     else 
		     {
		         System.out.println("          Please Enter Corret Product Id!!!!");
		     }

	  }
     	  catch (Exception e) 
	     {
     			System.out.println(e.getMessage());	
     	 }
}

	
	
	
	public void searchUser() throws SQLException, ClassNotFoundException
	{
		DisplayAllUsers dau=new DisplayAllUsers();
		dau.getUsersList();
		
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter username to search:");
	  String uname=sc.next();
	  try 
	  {
		  Db_Connection db_Connection=new Db_Connection();
			Connection con=db_Connection.getConnection();
			//Connection con=null;
			PreparedStatement ps=null;
			List<Users> searchusers=new ArrayList<>();
			PreparedStatement ps1=con.prepareStatement("select * from user where username=?");
			ps1.setString(1, uname);
		    ResultSet rs1=ps1.executeQuery();
		     if(rs1.next())
		     {
		         searchusers.add(new Users(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6)));
		         System.out.println(searchusers); 
		     }
		     else 
		     {
		         System.out.println("          Please Enter Corret UserName!!!!");
		     }
		     
	     }

		  catch (Exception e)
	        {
		 		System.out.println(e.getMessage());	
		 	}
		 				    
     	  }
}



