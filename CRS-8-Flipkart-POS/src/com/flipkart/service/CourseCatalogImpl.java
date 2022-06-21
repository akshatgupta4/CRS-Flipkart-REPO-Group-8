package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseCatalogImpl implements CourseCatalogInterface{
    public static HashMap<Integer, Course> courseCatalog;

    public List<Course> viewAllCourses() {
        List<Course> courseList = new ArrayList<Course>();
        courseCatalog.forEach((k, v) -> courseList.add(v));;
        return courseList;
    }
    public void addCourse(Course newCourse) {
        courseCatalog.put(Integer.parseInt(newCourse.getCourseCode()), newCourse);
        return;
    }

}
