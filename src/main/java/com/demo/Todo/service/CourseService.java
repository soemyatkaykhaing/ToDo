package com.demo.Todo.service;

import com.demo.Todo.entity.Course;
import com.demo.Todo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    //Post
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    public List<Course> saveCourses(List<Course> courses){
        return courseRepository.saveAll(courses);
    }
    //Get
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    public Course getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }
    public Course getCoursebyName(String name){
        return courseRepository.findByName(name);
    }
    public List<Course> getCoursesForUser(String username){
        return courseRepository.findAllByUsername(username);
    }
    //Put
    public Course updateCourse(Course course){
        Course old_course = courseRepository.findById(course.getId()).orElse(null);
        old_course.setName(course.getName());
        old_course.setDescription(course.getDescription());
        old_course.setStatus(course.getStatus());
        return courseRepository.save(old_course);
    }
    //DELETE
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return id + "id -> course removed/completed";
    }
}
