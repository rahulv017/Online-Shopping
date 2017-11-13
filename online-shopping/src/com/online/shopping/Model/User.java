package com.online.shopping.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	//int user_id;
	String usernname;
	String password;
	
	
	public String getUsernname() {
		return usernname;
	}
	public void setUsernname(String usernname) {
		this.usernname = usernname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
