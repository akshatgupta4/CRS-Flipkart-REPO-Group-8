package com.flipkart.service;

import com.flipkart.constant.Role;

public interface UserInterface {
    public boolean verifyCredentials(String userID,String password);

    public Role getRole(String userId);
}
