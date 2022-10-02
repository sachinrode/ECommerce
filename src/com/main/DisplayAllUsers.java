package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayAllUsers {

	public void getUsersList() throws SQLException
	{
		System.out.println("        ======================================All Categories======================================");
	
		//mobiles list
		List<Users> users=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Db_Connection db_Connection=new Db_Connection();
		   	con=db_Connection.getConnection();
			ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				users.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
      		
			System.out.println(users);
		}
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}
		

		System.out.println("\n        ==========================================================================================");

	}	
}
