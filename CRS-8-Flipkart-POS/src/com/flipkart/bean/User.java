package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;


public class User {
    private String userId;
    private String name;
    private Role role;
    private String password;
    private Gender gender;
    private String address;
    private String country;

    public User(String userId, String name, Role role, String password, Gender gender, String address,
                String country) {
//        super();
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.country = country;
    }

    /**
     * gives gender of a user
     *
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * sets gender of a user
     *
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * gives address of a user
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets address of a user
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gives country for a user
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets country for a user
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * default constructor for User
     */

    public User() {

    }

    /**
     * gives userId for a user
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * sets userId for a user
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * gives name for a user
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name for a user
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gives role for a user(Admin/Professor/Student)
     *
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * sets role for a user(Admin/Professor/Student)
     *
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * gives password for a user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets password for a user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
