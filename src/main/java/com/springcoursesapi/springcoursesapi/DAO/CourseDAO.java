package com.springcoursesapi.springcoursesapi.DAO;

import com.springcoursesapi.springcoursesapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {
}
