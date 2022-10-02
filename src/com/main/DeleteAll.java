package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAll {

	public void deleteUserDetails() throws SQLException, ClassNotFoundException
	{
		Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
		//Connection con=null;
		PreparedStatement ps=null;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER  USER NAME->>");
		String username=sc.next();
		ps=con.prepareStatement("delete from user where username=?;");
		ps.setString(1, username);
		ps.executeUpdate();
		System.out.println("USER DATA DELETED-1");

	}		
		
	
	
	public void deleteProductDetails() throws ClassNotFoundException, SQLException
	{
		//delete product data
		Db_Connection db_Connection=new Db_Connection();
		Connection con=db_Connection.getConnection();
		//Connection con=null;
		PreparedStatement ps=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER  PID->>");
		String pid=sc.next();
		ps=con.prepareStatement("delete from product where pid=?;");
							
				ps.setString(1, pid);
				ps.executeUpdate();
				System.out.println("PRODUCT DATA DELETED-1");		

	}
	

	
}
