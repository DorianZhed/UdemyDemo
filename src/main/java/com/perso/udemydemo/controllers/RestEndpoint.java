package com.perso.udemydemo.controllers;

import com.perso.udemydemo.configurations.CourseConfiguration;
import com.perso.udemydemo.model.Course;
import com.perso.udemydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestEndpoint {

    @Value("${default.course.name}")
    private String cName;

    @Value("${default.course.chapterCount}")
    private int cChapterCount;

    @Autowired
    private CourseConfiguration courseConfiguration;

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping("/course")
    public String saveCourse(@RequestBody Course course) {
        if(courseService.addCourse(course) != null)
            return "Course data saved successfully";

        return "Error saving course";
    }

    @PutMapping("/course")
    public String updateCourse(@RequestBody Course course) {
        if(courseService.updateCourse(course) != null)
            return "Course data updated successfully";

        return "Error updating course";
    }

    @DeleteMapping("/course")
    public String deleteCourse(@RequestParam(name = "id") Long id) {
        try {
            courseService.deleteCourse(id);
            return "Success";
        } catch (Exception e) {
            return "Error";
        }
    }

    @GetMapping("/defaultCourse")
    public Course getDefaultCourse(){
        return new Course(this.cName, this.cChapterCount);
    }

    @GetMapping("/hierarchicalCourse")
    public Map<String,Object> getConfigAnnotateProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", courseConfiguration.getName());
        map.put("chapterCount", courseConfiguration.getChapterCount());
        map.put("rating", courseConfiguration.getRating());
        map.put("author", courseConfiguration.getAuthor());

        return map;
    }

    @GetMapping("/course")
    public Course getCourse(@RequestParam(value="name", defaultValue = "SpringBoot", required = false) String name,
                            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(name, chapterCount);
    }

    @PostMapping("/register/course")
    public String registerCourse(@RequestBody Course course) {
        return "Your course named: " + course.getName() + " with " + course.getChapterCount() + " chapters saved successfully.";
    }
}
