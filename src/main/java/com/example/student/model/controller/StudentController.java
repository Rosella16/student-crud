package com.example.student.model.controller;

import com.example.student.model.entity.Student;
import com.example.student.model.request.StudentRequest;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
@Getter
@Setter
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }
    @GetMapping ("/get-all-students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PutMapping("{id}")
    public Student updateStudentById(@PathVariable UUID id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudentByID(id, studentRequest);
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable UUID id){
        return studentRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable UUID id){
        studentService.deleteStudentById(id);
    }



}
