package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.util.CRSDbConnection;

public class UserDaoOperation implements UserDaoInterface{
	public static volatile UserDaoOperation instance=null;
	public  UserDaoOperation()
	{

	}

	public static UserDaoOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(UserDaoOperation.class){
				instance=new UserDaoOperation();
			}
		}
		return instance;
	}

	public boolean verifyCredentials(String userId, String password){
		Connection connection = CRSDbConnection.getConnection();
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueryConstants.VERIFY_CREDENTIALS_QUERY);
			preparedStatement.setString(1,userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(!resultSet.next()){
				System.out.println("user not found");
			}
			else return password.equals(resultSet.getString("password"));

		}
		catch(SQLException ex)
		{
			System.out.println("Something went wrong, please try again! "+ ex.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


	public Role getRole(String userId) {
		Connection connection = CRSDbConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueryConstants.GET_ROLE_ID_QUERY);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();

			if(rs.next())
			{
				int roleId=rs.getInt("roleId");
				if(roleId==1) {
					return Role.ADMIN;
				}
				else if(roleId==2){
					return Role.PROFESSOR;
				}
				return Role.STUDENT;

			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
