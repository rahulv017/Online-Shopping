package com.online.shopping.DAO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.online.shopping.Model.ShopppingCart;

public class Retrieve {
      Connection gg;
	  Conn con;
	public Retrieve() {
		con=new Conn();
		// TODO Auto-generated constructor stub
	}
	
	/*List<ShopppingCart> view()
	{
		Statement stat=null;
		 List<ShopppingCart> shop=new ArrayList<ShopppingCart>();
		String query="Select * from shopping";
		try {
			ResultSet res=stat.executeQuery(query);
		
		
		 ShopppingCart sh=new ShopppingCart();
		 while(res.next())
		 {
			  sh.setProduct_id(res.getInt("id"));
			  sh.setPrice(res.getInt("price"));
			  sh.setProdduct_desc(res.getString("prodduct_desc"));
			  sh.setProduct_name(res.getString("product_name"));
			  sh.setUsername(res.getString("username"));
			  shop.add(sh);
			  
		 }
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return shop;
		
	}*/
	 public boolean addCart(ShopppingCart shop,String userid)
	 {
		 int pro_id=shop.getProduct_id();
		 String name=shop.getProduct_name();
		 String pro_desc=shop.getProdduct_desc();
		 int price=shop.getPrice();
		 String query = " insert into shopping (user_id, product_id, product_name, price,quntity, prodduct_desc)"
			        + " values (?, ?, ?, ?, ?,?)";
		 try {
			PreparedStatement preparedStmt=gg.prepareStatement(query);
			 preparedStmt.setString (1,userid );
		      preparedStmt.setInt (2, pro_id);
		      preparedStmt.setString   (3, name);
		      preparedStmt.setInt(4, price);
		      preparedStmt.setInt    (5,1);
		      preparedStmt.setString   (6, pro_desc);
		      return true;
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		 
	 }
	  public List<ShopppingCart> viewMyCart(String userid)
	  {
		  Statement stat=null;
			 List<ShopppingCart> shop=new ArrayList<ShopppingCart>();
			String query="Select product_id,product_name,price,quantity,prodduct_desc from shopping where username="+userid;
			try {
				ResultSet res=stat.executeQuery(query);
			
			
			 ShopppingCart sh=new ShopppingCart();
			 while(res.next())
			 {
				  sh.setProduct_id(res.getInt("product_id"));
				  sh.setPrice(res.getInt("price"));
				  sh.setProdduct_desc(res.getString("prodduct_desc"));
				  sh.setProduct_name(res.getString("product_name"));
				  
				  shop.add(sh);
				  
			 }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return shop;
			
	  }
	   boolean deleteCart(String userid,int pro_id)
	   {
		   Statement statement = null;

			String deleteTableSQL = "DELETE shopping WHERE username ="+userid+"and product_id="+pro_id+"";
			try {
				statement=gg.createStatement();
				statement.executeQuery(deleteTableSQL);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
	   }
	    public int addUser(String userid,String password)
	    {
	    	Statement statement=null;
	    	String adduser="Insert into user(username,password) values username="+userid+"password="+password;
	    	try {
				statement=gg.createStatement();
				statement.executeQuery(adduser);
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
	    }
	    
	 
	  

}
