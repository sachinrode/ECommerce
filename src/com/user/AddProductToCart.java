package com.user;
import com.main.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.*;
public class AddProductToCart {

	String desc;
    int price;
    String price1=Integer.toString(price);
    public void cart(int pid,String userName) throws ClassNotFoundException, SQLException
    {
    	String pid1=Integer.toString(pid);
        
        
    	Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
    	PreparedStatement ps=con.prepareStatement("select description,price,categories,quantity from product where pid=?");
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{     
			
		      desc=rs.getString(1);
		      price=rs.getInt(2);
		      String cat=rs.getString(3);
		      //int quant=rs.getInt(4);
		      System.out.println(rs.getString(3));
     
  			PreparedStatement ps1=con.prepareStatement("insert into carts(productid,uname,productname,pprice,pcategories)values(?,?,?,?,?)");
  			ps1.setString(1,pid1);
  			ps1.setString(2,userName);
  			ps1.setString(3,desc);
  			ps1.setString(4,price1);
  			ps1.setString(5,cat);
  		    ps1.executeUpdate();
  		    
  		    System.out.println("\n************Cart************");	
  		    System.out.println(" Add To Cart Successful!!!!");
  	 
  
		}
	
    			
   		    
     }
	
    
    
    
	
	public void addProductToCart() throws SQLException
	{
	
		DisplayAllProducts dp=new DisplayAllProducts();
		dp.getProductList();
		
		try 
		{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter Product Id:");
		int pid=scanner.nextInt();
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
		ps2.setInt(1, pid);
	    ResultSet pi=ps2.executeQuery();
	     if(un.next() && pi.next())
	     {
	    	cart(pid,userName);
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
