package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.constant.Gender;

import java.util.HashMap;

public class UserImpl implements UserInterface{
    public static HashMap<String, User> userList = new HashMap<String, User>();
    public UserImpl() {
        User user = new User("admin", "admin", Role.ADMIN, "admin", Gender.FEMALE, "abc", "abc");
        userList.put("admin", user);
    }

    public boolean verifyCredentials(String userID,String password) {
//        int userId_ = Integer.parseInt(userID);
        User user = userList.get(userID);
        if(user.getPassword().equals(password)) return true;
        return false;
    }

    public Role getRole(String userId){
//        int userId_ = Integer.parseInt(userId);
        User user = userList.get(userId);
        return user.getRole();
    }
}
