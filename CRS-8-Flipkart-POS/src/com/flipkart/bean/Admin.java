package com.flipkart.bean;

import java.util.Date;

public class Admin extends User {
    private Date dateOfJoining;

    /**
     * returns date of joining for a user
     *
     * @return Date
     */
    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    /**
     * sets date of joining for a user
     *
     * @param dateOfJoining
     */
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}