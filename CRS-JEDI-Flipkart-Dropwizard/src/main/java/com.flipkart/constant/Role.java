package com.flipkart.constant;


public enum Role {
    ADMIN(1),
    PROFESSOR(2),
    STUDENT(3);

    private final int value;

    Role(final int newValue) {
        value = newValue;
    }
    public static Role getRole(String role)
    {
        Role userRole=null;
        System.out.println(role);
        if(role.equalsIgnoreCase("ADMIN"))
            userRole=Role.ADMIN;
        else if(role.equalsIgnoreCase("PROFESSOR"))
            userRole=Role.PROFESSOR;
        else if(role.equalsIgnoreCase("STUDENT"))
            userRole=Role.STUDENT;
        return userRole;
    }

    public int getValue() { return value; }
}