package com.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.*;
public class OrderTheProduct {
	
	public void order(String pid,int quantity,String userName,String desc) throws ClassNotFoundException, SQLException
	{
	
		try 
		{
			  String p=pid;
			  int q=quantity;
			  String u=userName;
			  
			  int tquantity=0;
			  int price=0;
			  String pname=null;
			  String des=desc;
		    
		  
		    Connection con=null;
			PreparedStatement ps=null;
			
			//check product quantity available or not
			Db_Connection db_Connection=new Db_Connection();
			con=db_Connection.getConnection();
		    ps=con.prepareStatement("select quantity,price,description from product where pid=?");
			ps.setString(1,p);
			
		    ResultSet rs1=ps.executeQuery();
		    while(rs1.next())
		    {
		      tquantity=rs1.getInt(1);
		      price=rs1.getInt(2);
		      pname=rs1.getString(3);
		      System.out.println(rs1.getString(3));
		    }
		    if(tquantity >= q)
		    {    
		    	 //upate the quantity in product table
		    	 int q1=tquantity-q;
		    	 String q2=Integer.toString(q1);//quantity
				ps=con.prepareStatement("update product set quantity=? where pid=? ");
				ps.setString(1,q2);
				ps.setString(2, p);
			    ps.executeUpdate();
			    
			    //insert the order in order table
			    String q3=Integer.toString(q);//quantity
			    String price1=Integer.toString(price);//price
			    int tprice1=price*q;
			    String tprice2=Integer.toString(tprice1);//total price
                			  
			    ps=con.prepareStatement("insert into ecommerce.order(username,pid,quantity,price,totalprice)values(?,?,?,?,?)");
				
			    
			    ps.setString(1,u);
				ps.setString(2, p);
				ps.setString(3, q3);
				ps.setString(4, price1);
				ps.setString(5, tprice2);
				//ps.setString(6, des);
				ps.executeUpdate();
		
			System.out.println("\n************Order Details************");	
			  System.out.println("pid:"+p);
			  System.out.println("product name:"+pname);
			  System.out.println("No of products:"+q3);
			  System.out.println("price of each:"+price1);
			  System.out.println("Total Price:"+tprice2);	
		      System.out.println(pname +" ordered succesfull!!!!");
		    }
		    else
		    {
		    	System.out.println("product not Available!!!!");
		    }	
	
		}  
		catch (Exception e) 
		{
			System.out.println(e.getMessage());	
	 	}
	}
	
	
	
	
	
	
	
	public void orderTheProduct() throws SQLException
	{
		DisplayAllProducts dp=new DisplayAllProducts();
		dp.getProductList();
		
	try 
		{
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter Product Id:");
			String pid=scanner.next();
			System.out.print("Enter Quantity:");
			int quantity=scanner.nextInt();
			System.out.print("Enter Your UserName:");
			String userName=scanner.next();
			
		
		Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
		
		//check username present or not
		PreparedStatement ps1=con.prepareStatement("select username from user where username=?");
		ps1.setString(1, userName);
	    ResultSet un=ps1.executeQuery();
	    
	    //check product id present or not
	    PreparedStatement ps2=con.prepareStatement("select * from product where pid=?");
		ps2.setString(1, pid);
	    ResultSet pi=ps2.executeQuery();
	     if(un.next() && pi.next())
	     {
	    	 String desc=pi.getString(2);	
	    	 
	    	 order(pid,quantity,userName,desc);
	     }
	     else 
	     {
	         System.out.println("          Please Enter Corret UserName And Product Id!!!!");
	     }
	    
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		

	}
	

}
