package com.demo.Todo.controller;

import com.demo.Todo.entity.Course;
import com.demo.Todo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        logger.info("Course object{ }",course.toString());
        return courseService.saveCourse(course);
    }
    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return courseService.saveCourses(courses);
    }
    //Get
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }
    @GetMapping("/courseById/{id}")
    public Course findCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }
    @GetMapping("/courseByName/{name}")
    public Course findCourseByName(@PathVariable String name){
        return courseService.getCoursebyName(name);
    }
    @GetMapping("/listCourseByUsername/{username}")
    public List<Course> findCourseByUsername(@PathVariable String username){
        return courseService.getCoursesForUser(username);
    }
    //PUT
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        System.out.println("Updated");
        return courseService.updateCourse(course);
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }

}
