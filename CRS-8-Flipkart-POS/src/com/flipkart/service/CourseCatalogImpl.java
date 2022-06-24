package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseCatalogImpl implements CourseCatalogInterface{
    public static HashMap<String, Course> courseCatalog = new HashMap<String, Course>();

    public List<Course> viewAllCourses() {
        List<Course> courseList = new ArrayList<Course>();
        courseCatalog.forEach((k, v) -> courseList.add(v));;
        return courseList;
    }
    public void addCourse(Course newCourse) {
        courseCatalog.put(newCourse.getCourseCode(), newCourse);
        return;
    }

    public void deleteCourse(String courseCode) {

        try{
            courseCatalog.remove(courseCode);
            return;
        }
        catch(Exception e){
            System.out.println("Enter correct course code!!.");
        }

    }

}
