package com.perso.udemydemo.service;

import com.perso.udemydemo.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(Long id);
}
