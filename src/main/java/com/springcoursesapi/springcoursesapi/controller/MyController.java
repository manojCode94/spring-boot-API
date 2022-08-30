package com.springcoursesapi.springcoursesapi.controller;



import com.springcoursesapi.springcoursesapi.model.Course;
import com.springcoursesapi.springcoursesapi.service.CourseServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MyController {

    @Autowired
    private CourseServiceProvider courseServiceProvider;

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String Home(){
        return "Welcome to the coursed API application";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return  this.courseServiceProvider.getCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable long courseId) {
        return this.courseServiceProvider.getCourse((courseId));
    }

    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody  Course course) {
        return this.courseServiceProvider.addCourse(course);
    }

    @RequestMapping(path = "/courses", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return this.courseServiceProvider.updateCourse(course);
    }

    @RequestMapping(path="/courses/{courseId}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable  long courseId) {
        try
        {
            this.courseServiceProvider.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
