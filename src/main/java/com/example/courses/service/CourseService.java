package com.example.courses.service;

import com.example.courses.dao.CoursesRepository;
import com.example.courses.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseInterface{

    private CoursesRepository coursesRepository;

    public CourseService(CoursesRepository theCoursesRepository)
    {
        coursesRepository=theCoursesRepository;
    }

    @Override
    public List<Course> findAll()
    {
        return coursesRepository.findAll();
    }

    @Override
    public Course findById(int theId){
        Optional<Course> result = coursesRepository.findById(theId);
        Course theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theCourse;
    }
    @Override
    public void save(Course theCourse) {
        coursesRepository.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {
        coursesRepository.deleteById(theId);
    }


}
