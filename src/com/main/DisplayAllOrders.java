package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class DisplayAllOrders {

	public void getOrderList() throws SQLException
	{
		System.out.println("        =====================================All Orders======================================");
	
		//orders list
		List<Order> order=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		try {
		
			Db_Connection db_Connection=new Db_Connection();
		   	con=db_Connection.getConnection();
			ps=con.prepareStatement("select oid,pid,user.username,quantity,price,totalprice,city,phoneno from ecommerce.user inner join ecommerce.order on ecommerce.user.username = ecommerce.order.username");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order.add(new Order(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}			System.out.println(order+"\n");
		}
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}
		
			System.out.println("\n        ==========================================================================================");

     			
}
}