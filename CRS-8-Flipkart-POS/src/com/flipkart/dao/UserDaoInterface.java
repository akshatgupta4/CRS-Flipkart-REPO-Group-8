package com.flipkart.dao;

import com.flipkart.constant.Role;

public interface UserDaoInterface {
	public boolean verifyCredentials(String userId,String password);


	public Role getRole(String userId);

}
