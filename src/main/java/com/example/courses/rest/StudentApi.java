package com.example.courses.rest;

import com.example.courses.dao.StudentRepository;
import com.example.courses.entity.Course;
import com.example.courses.entity.Student;
import com.example.courses.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentApi {

    private StudentService studentService;

    public StudentApi(StudentService theStudentService)
    {
        studentService = theStudentService;
    }

    @GetMapping("/student")
    public List<Student> listStudent() {
        return studentService.findAll();
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student theStudent) {
        // save the employee
        studentService.save(theStudent);

        // use a redirect to prevent duplicate submissions
        return theStudent;
    }
    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable int studentId){

        Student tempStudent = studentService.findById(studentId);
        studentService.save(tempStudent);

        return tempStudent;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student tempStudent = studentService.findById(studentId);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Employee id not found - " + tempStudent);
        }

        studentService.deleteById(studentId);

        return "Deleted student id - " + studentId;
    }
}
