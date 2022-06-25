package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {

    /*
    Method to see all the courses in the catalog.
    @return List of all the courses in caltalog.
     */
    public List<Course> viewAllCourses();

    /*
    Method to add the courses in the catalog.
    @param new course id.
     */
    public void addCourse(Course newCourse);

    /*
    Method to delete the specific course from the catalog.
    @param CourseId of the course which need to get deleted.
     */
    public void deleteCourse(String courseCode);
}
