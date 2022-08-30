package com.springcoursesapi.springcoursesapi.service;

import com.springcoursesapi.springcoursesapi.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseServiceInterface {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

     public void deleteCourse(long courseId);
}

