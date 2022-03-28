package com.example.courses.service;

import com.example.courses.entity.Course;

import java.util.List;

public interface CourseInterface {

    public List<Course> findAll();

    public Course findById(int theId);

    public void save(Course theCourse);

    public void deleteById(int theId);
}
