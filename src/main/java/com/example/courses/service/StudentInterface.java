package com.example.courses.service;

import com.example.courses.entity.Student;

import java.util.List;

public interface StudentInterface {

    public List<Student>findAll();

    public Student findById(int theId);

    public void save(Student theStudent);

    public void deleteById(int theId);
}
