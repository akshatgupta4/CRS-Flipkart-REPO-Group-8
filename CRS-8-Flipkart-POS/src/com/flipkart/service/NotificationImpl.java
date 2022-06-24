package com.flipkart.service;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.dao.NotificationDaoInterface;
import com.flipkart.dao.NotificationDaoOperation;

import java.sql.SQLException;
import java.util.UUID;

public class NotificationImpl implements NotificationInterface{

    private static volatile NotificationImpl instance=null;
    NotificationDaoInterface notificationDaoInterface= NotificationDaoOperation.getInstance();

    public NotificationImpl()
    {

    }

    public static NotificationImpl getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(NotificationImpl.class){
                instance=new NotificationImpl();
            }
        }
        return instance;
    }

    @Override
    public int sendNotification(String studentId, String message) {
        int notificationId=0;
        try
        {
            notificationId=notificationDaoInterface.sendNotification(studentId,message);

        }
        catch(SQLException ex)
        {
            System.out.println("Error occured "+ex.getMessage());
        }
        return notificationId;
    }

    @Override
    public UUID getReferenceId(int notificationId) {
        // TODO
        return null;
    }


}
