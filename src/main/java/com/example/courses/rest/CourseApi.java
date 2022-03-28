package com.example.courses.rest;

import com.example.courses.entity.Course;
import com.example.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseApi {

    @Autowired
    private CourseService courseService;

    public CourseApi(CourseService theCourseService)
    {
        courseService= theCourseService;
    }

    @GetMapping("/course")
    public List<Course> listCourse() {
        return courseService.findAll();
    }
    @PostMapping("/course")
    public Course saveUser(@RequestBody Course theCourse) {

        courseService.save(theCourse);

        return theCourse;
    }

    @PutMapping("/course/{courseId}")
    public Course updateCourse(@PathVariable int courseId) {

        Course tempCourse = courseService.findById(courseId);
        courseService.save(tempCourse);

        return tempCourse;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/course/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {

        Course tempCourse = courseService.findById(courseId);

        // throw exception if null

        if (tempCourse == null) {
            throw new RuntimeException("Employee id not found - " + courseId);
        }

        courseService.deleteById(courseId);

        return "Deleted employee id - " + courseId;
    }



}
