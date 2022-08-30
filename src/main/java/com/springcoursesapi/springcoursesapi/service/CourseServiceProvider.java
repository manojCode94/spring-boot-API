package com.springcoursesapi.springcoursesapi.service;

import com.springcoursesapi.springcoursesapi.DAO.CourseDAO;
import com.springcoursesapi.springcoursesapi.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceProvider implements  CourseServiceInterface{

    @Autowired
    private CourseDAO courseDAO;

   // List<Course> courseList;

    public CourseServiceProvider() {

        //courseList = new ArrayList<Course>();
        //courseList.add(new Course(145, "Java Core", "This is java core course for beginner" ));
        //courseList.add(new Course(146, "Java Script", "This is java Script course for Beginner"));
        //courseList.add(new Course(147, "Node js", "This is Node JS  course Intermiddiate"));
        //courseList.add(new Course(147, "Data  science in python", "This is Data science using python programming language "));
    }

    @Override
    public List<Course> getCourses() {
        return courseDAO.findAll();
        //return  courseList;
    }

    @Override
    public Course getCourse(long courseId) {

        /*for(Course c : courseList) {
            if (c.getId() == courseId) {
                return c;
            }
        }
         */

        return courseDAO.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {

        /*long courseId = 0;
        for(Course c: courseList) {
            courseId = c.getId();
        }
        course.setId(courseId + 1);
        courseList.add(course);

         */
        courseDAO.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        /*courseList.forEach((c) -> {
            if(c.getId() == course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
            }
        });

         */
        courseDAO.save(course);
        return course;

    }

    @Override
    public void deleteCourse(long courseId) {
        /*
        courseList = this.courseList.stream().filter(c -> c.getId() != courseId).collect(Collectors.toList());

         */
        //get existing entity by id
         Course c =  courseDAO.findById(courseId).get();
         //then delete that entity
         courseDAO.delete(c);
    }
}
