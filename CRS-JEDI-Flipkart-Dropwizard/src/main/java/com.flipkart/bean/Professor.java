
package com.flipkart.bean;

public class Professor extends User{
    private String department;
    private String designation;

    /**
     * gives department for a professor
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * sets department for a professor
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * gives designation for a professor
     * @return designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * sets designation for a professor
     * @param designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }


    /**
     * default constructor for professor
     */
   public Professor(){}


}