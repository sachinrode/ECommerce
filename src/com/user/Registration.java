package com.user;
import com.main.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

	
	public void registerUser() throws SQLException, ClassNotFoundException
	{
		try 
		{
			System.out.println("*******************Enter The Data*******************");
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter UserName(ex-name@123):");
	        String userName=scanner.nextLine();
	        System.out.print("Enter Password:");
	        String Password=scanner.nextLine();
	        System.out.print("Enter FirstName:");
	        String firstName=scanner.nextLine();
	        System.out.print("Enter LastName:");
	        String lastName=scanner.nextLine();
	        System.out.print("Enter City:");
	        String city=scanner.nextLine();
	        System.out.print("Enter MobileNo:");
	        String mobileNo=scanner.nextLine();
		
	        Db_Connection db_Connection=new Db_Connection();
			Connection con=db_Connection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(username,password,firstname,lastname,city,phoneno)values(?,?,?,?,?,?)");
			ps.setString(1,userName);
			ps.setString(2,Password);
			ps.setString(3,firstName);
			ps.setString(4,lastName);
			ps.setString(5,city);
			ps.setString(6,mobileNo);
		    ps.executeUpdate();
		    
		    System.out.println("Registration Successful!!!!");

		}
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		}

        
	}
}
