package com.perso.udemydemo.controllers;

import com.perso.udemydemo.configurations.CourseConfiguration;
import com.perso.udemydemo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestEndpoint {

    @Value("${default.course.name}")
    private String cName;

    @Value("${default.course.chapterCount}")
    private int cChapterCount;

    @Autowired
    private CourseConfiguration courseConfiguration;

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
    public String saveCourse(@RequestBody Course course) {
        return "Your course named: " + course.getName() + " with " + course.getChapterCount() + " chapters saved successfully.";
    }
}
