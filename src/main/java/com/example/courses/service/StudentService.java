package com.example.courses.service;

import com.example.courses.dao.StudentRepository;
import com.example.courses.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentInterface{

    private StudentRepository studentRepository;

    public StudentService(StudentRepository theStudentRepository)
    {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    @Override
    public Student findById(int theId){
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;
        if(result.isPresent()){
            theStudent= result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theStudent;
    }
    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }

}
