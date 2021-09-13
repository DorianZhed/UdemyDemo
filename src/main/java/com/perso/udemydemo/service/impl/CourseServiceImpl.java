package com.perso.udemydemo.service.impl;

import com.perso.udemydemo.model.Course;
import com.perso.udemydemo.repositories.CourseRepository;
import com.perso.udemydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Long id = course.getId();
        if(courseRepository.getById(id) == null)
            throw new IllegalArgumentException("The course with the ID: " + id + " doesn't exists");

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


}
