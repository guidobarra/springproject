package com.guba.demo.controller;

import com.guba.demo.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // hasRole('ROLE_') hasAnyRole('ROLE_'.....) hasAuthority('permission')  hasAnyAuthority('permission'...)

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINING')")
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @DeleteMapping(path = "{idStudent}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("idStudent") Integer idStudent) {
        System.out.println("deleteStudent");
        System.out.println(idStudent);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void createStudent(@RequestBody Student student) {
        System.out.println("createStudent");
        System.out.println(student);
    }

    @PutMapping(path = "{idStudent}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("idStudent") Integer idStudent, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", idStudent, student));
    }

}
