package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public class CourseCatalogImpl implements CourseCatalogInterface{
    private static List<Course> courseCatalog;

    public List<Course> viewAllCourses() {
        return courseCatalog;
    }
    public void addCourse(Course newCourse) {
        courseCatalog.add(newCourse);
        return;
    }

}
