package com.main;
import com.user.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
 
 public class Application_Main extends Db_Connection {
      
//admin switch case 
	 public static void adminMenu() throws SQLException, ClassNotFoundException
	 {
		DeleteAll delete=new DeleteAll();
		UpdateAll update=new UpdateAll();
		SearchAll search=new SearchAll();
		 int c=0;
			do
			{   System.out.println("****************************E-Commerce*****************************"); 
				System.out.println("===================================================================");
				System.out.print("1>Display All Users");
				System.out.print("     2>Display All Products");
				System.out.println("      3>Display All Orders");
				
				System.out.print("4>Search User");
				System.out.print("           5>Search Product");
				System.out.println("            6>Search Order");
				
				System.out.print("7>Update User");
				System.out.println("            8>Update Product");
				
				System.out.print("9>Delete User");
				System.out.println("           10>Delete Product");
				
				System.out.println("11>Insert New Product");
				System.out.println("12>Exit");
				System.out.println("===================================================================");
				System.out.print("Enter Your Choice:");
				Scanner sc=new Scanner(System.in);
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
				    DisplayAllUsers dau=new  DisplayAllUsers();
				    dau.getUsersList();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 2:
					DisplayAllProducts displayAllProducts=new DisplayAllProducts();
					displayAllProducts.getProductList();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 3:
					DisplayAllOrders duo=new DisplayAllOrders();
					duo.getOrderList();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 4:
					search.searchUser();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 5:
					search.searchProduct();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 6:
					DisplayUserOrders d=new DisplayUserOrders();
					d.getOrderList();
					System.out.println("----------------------------------------------------------------------------------");
					break;

				case 7:
					update.updateUser();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 8:
					update.updateProduct();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 9:
					delete.deleteUserDetails();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 10:
					delete.deleteProductDetails();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 11:
					AddNewProduct addNewProduct=new  AddNewProduct();
					addNewProduct.addProduct();
					System.out.println("----------------------------------------------------------------------------------");
					break;
					
				case 12:
					System.out.println("........Thank You........");
					return;
				default:
					System.out.println("please enter valid choice");
					break;
				}
				
				System.out.print("do you want to continue in Admin(y/n)");
			    c=sc.next().charAt(0);
			 }		
		while((c=='y' || c=='Y') ||  (c=='n' && c=='N'));
		
    }


//user switch case 
	 public static void userMenu() throws SQLException
	 {
		 int c=0;
			do
			{   System.out.println("****************************E-Commerce*****************************"); 
				System.out.println("===================================================================");
				System.out.println("1>Display All Products In Assending Order");
				System.out.print("2>Order Now");
				System.out.println("       3>Add To Cart");
				
				System.out.print("4>Display Orders");
				System.out.println("  5>Display Cart");				
				System.out.println("6>Exit");
				System.out.println("===================================================================");
				System.out.print("Enter Your Choice:");
				Scanner sc=new Scanner(System.in);
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
				   DisplayAllProducts displayAllProducts=new DisplayAllProducts();
				   displayAllProducts.getProductList();
				   
					break;
				case 2:
                    OrderTheProduct op=new OrderTheProduct();
                    op.orderTheProduct();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 3:
					AddProductToCart ap=new AddProductToCart();
					ap.addProductToCart();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 4:
					DisplayUserOrders duo=new DisplayUserOrders();
					duo.getOrderList();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 5:
					DisplayUserCarts duc=new DisplayUserCarts();
					duc.getcartList();
					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 6:
					 System.out.println("........Thank You........");
					return;
				default:
					System.out.println("please enter valid choice");
					break;
				}
				
				System.out.print("do you want to continue in Users(y/n)");
			    c=sc.next().charAt(0);
			 }		
		while((c=='y' || c=='Y') ||  (c=='n' && c=='N'));
		//return;
	 }

	 
//main method
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc=new Scanner(System.in);
		   System.out.println("**************E-Commerce**************"); 
		int c=0;
		do
		{
			System.out.println("======================================");
			System.out.print("1>User");
			System.out.print("  2>Register");
			System.out.print("  3>Admin");
			System.out.println("  4>Exit");
			System.out.println("======================================");
			System.out.print("Enter Your Choice:");
			int choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:
				Connection con=null;
				PreparedStatement ps=null;
				
				System.out.print("*Enter UserName:");
				String userName=sc.next();
				System.out.print("*Enter Your Password:");
				String pass=sc.next();
				
				try 
				{
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from user where username=? and password=?");
				ps.setString(1, userName);
				ps.setString(2, pass);
			    ResultSet rs=ps.executeQuery();
			     if(rs.next())
			     {
			        System.out.println("    login Successful!!!!");
     			    userMenu();	
			     }
			     else
			     {
			         System.out.println("          Please Enter Corret UserName And Password!!!!");
			     }
			    
				}
				catch(Exception e)
				{
					System.out.println(e.getLocalizedMessage());
				}
				
		        System.out.println("----------------------------------------------------------------------------------");
				break;
			
			case 2:
				Registration registration=new Registration();
				registration.registerUser();
				System.out.println("----------------------------------------------------------------------------------");
				break;
				
			case 3:
				System.out.print("*Enter UserName:");
				String adminUserName=sc.next();
				System.out.print("*Enter Your Password:");
				String adminPassword=sc.next();
				
				if((adminUserName.equals("groupr") && adminPassword.equals("admin")))
				{   
					System.out.println("    login Successful!!!!");
					adminMenu();	
				}
				else
				{
					   System.out.println("          Please Enter Corret UserName And Password!!!!");
				}
				System.out.println("----------------------------------------------------------------------------------");
				break;
				
				
			case 4:
				 System.out.println("........Thank You........");
				return;
			default:
				System.out.println("please enter valid choice");
				break;
			}
			System.out.print("do you want to continue in main(y/n)");
		    c=sc.next().charAt(0);
		  }
		while((c=='y' || c=='Y') ||  (c=='n' && c=='N'));
		System.out.println("........Thank You........");
	}
}
