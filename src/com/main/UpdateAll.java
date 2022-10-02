package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAll {

	public void updateUser() throws SQLException, ClassNotFoundException
	{
        Scanner sc=new Scanner(System.in);
		System.out.println("DETAIL TO BE UPDATED");
		System.out.println("1<-CITY");
		System.out.println("2<-PHONE NO.");
		System.out.println("ENTER YOUR CHOICE-->>");

		Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
		//Connection con=null;
		PreparedStatement ps=null;

		int u=sc.nextInt();
		switch(u)
		{
		case 1:
		{
			//city
			System.out.println("ENTER CITY NAME->>");
			String city=sc.next();
	        System.out.println("ENTER USERNAME TO UPDATE->>");
			String uname=sc.next();
			ps=con.prepareStatement("update user set city=? where username=?;");
			ps.setString(1, city);
			ps.setString(2, uname);
			ps.executeUpdate();
			System.out.println("CITY UPDATED-1");
			break;
		}
		case 2:
		{
			//PHONE NO.
			System.out.println("ENTER PHONE NO.->>");
			String salary=sc.next();
			System.out.println("ENTER USERNAME TO UPDATE->>");
			String userName=sc.next();
			ps=con.prepareStatement("update user set salary=? where username=?;");
			ps.setString(1, salary);
			ps.setString(2, userName);
			ps.executeUpdate();
			System.out.println("PHONE NO. UPDATED-1");
			break;
		}
		default:
		{
			System.out.println("WRONG CHOICE");
		}
       break;
		}
		
	}
	
	
	
	public void updateProduct() throws SQLException, ClassNotFoundException
	{
	     Scanner sc=new Scanner(System.in);
		System.out.println("DETAIL TO BE UPDATED");
		System.out.println("1<-PRODUCT  NAME AND CATRGORIES");
		System.out.println("2<-PRICE");
		System.out.println("3<-QUANTITY.");
		System.out.println("ENTER YOUR CHOICE-->>");
		int u=sc.nextInt();
		
		Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
		//Connection con=null;
		PreparedStatement ps=null;
		
		switch(u)
		{
		case 1:
		{//PRODUCT DESCRIPTION AND NAME
			
			System.out.println("ENTER PID TO UPDATE->>");
			String pid=sc.next();
			System.out.println("ENTER PRODUCT NAME->>");
			String description=sc.next();
            System.out.println("ENTER PRODUCT CATEGORIES->>");
			String cat=sc.next();
                        
			ps=con.prepareStatement("update product set description=?,categories=? where pid=?");
			ps.setString(1, description);
			ps.setString(2, cat);
			ps.setString(3, pid);
			ps.executeUpdate();
			System.out.println("PRODUCT DATA UPDATED-1");
			break;
		}
		case 2:
		{
			//PRICE
		
			System.out.println("ENTER PID TO UPDATE->>");
			String id=sc.next();
			System.out.println("ENTER NEW PRICE->>");
			String price=sc.next();
	            
			ps=con.prepareStatement("update user set price=? where pid=?;");
			ps.setString(1, price);
			ps.setString(2, id);
			ps.executeUpdate();
			System.out.println("PRICE UPDATED-1");
			break;
		}
		case 3:
		{
			//QUANTITY
		
			System.out.println("ENTER PID TO UPDATE->>");
			String id=sc.next();
			System.out.println("ENTER NEW QUANTITY->>");
			String quantity=sc.next();
			
			ps=con.prepareStatement("update user set quantity=? where pid=?;");
			ps.setString(1, quantity);
			ps.setString(2, id);
			ps.executeUpdate();
			System.out.println("QUANTITY UPDATED-1");
			break;
		}
		default:
		{
			System.out.println("WRONG CHOICE");
			
		}
       break;
       
	}

	}
}

