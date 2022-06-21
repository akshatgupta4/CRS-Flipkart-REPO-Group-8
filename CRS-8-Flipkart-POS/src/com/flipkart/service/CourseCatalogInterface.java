package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {
    public List<Course> viewAllCourses();
    public void addCourse(Course newCourse);
}
