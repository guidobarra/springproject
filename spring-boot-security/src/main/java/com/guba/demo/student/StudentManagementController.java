package com.guba.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @DeleteMapping(path = "{idStudent}")
    public void deleteStudent(@PathVariable("idStudent") Integer idStudent) {
        System.out.println("deleteStudent");
        System.out.println(idStudent);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        System.out.println("createStudent");
        System.out.println(student);
    }

    @PutMapping(path = "{idStudent}")
    public void updateStudent(@PathVariable("idStudent") Integer idStudent, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", idStudent, student));
    }

}
