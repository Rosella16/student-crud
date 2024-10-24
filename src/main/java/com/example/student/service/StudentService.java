package com.example.student.service;


import com.example.student.model.entity.Student;
import com.example.student.model.request.StudentRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    Student createStudent(StudentRequest studentRequest);
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    void deleteStudentById(UUID id);
    Student updateStudentByID(UUID id, StudentRequest studentRequest);




}
