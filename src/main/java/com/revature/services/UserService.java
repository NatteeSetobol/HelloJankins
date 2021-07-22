package com.revature.services;

public class UserService {

	public boolean login(String username, String password) {
		if(username.equals("John")&&password.equals("password")) {
			return true;
		}
		return false;
	}

}
