package com.flipkart.dao;

import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

public interface UserDaoInterface {
	public boolean verifyCredentials(String userId, String password);


	public Role getRole(String userId);

	boolean updatePassword(String userId, String newPassword) throws SQLException, UserNotFoundException;
}
