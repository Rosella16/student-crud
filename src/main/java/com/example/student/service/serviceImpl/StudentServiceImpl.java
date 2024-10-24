package com.example.student.service.serviceImpl;

import com.example.student.model.entity.Student;
import com.example.student.model.request.StudentRequest;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Getter
@Setter
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;


    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student newStudent = new Student();
        newStudent.setStudentName(studentRequest.getStudentName());
        newStudent.setGender(studentRequest.getGender());
        newStudent.setDob(studentRequest.getDob());
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student updateStudentByID(UUID id, StudentRequest studentRequest) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        Student newStudent = existingStudent.get();
        newStudent.setStudentName(studentRequest.getStudentName());
        newStudent.setGender(studentRequest.getGender());
        newStudent.setDob(studentRequest.getDob());
        return studentRepository.save(newStudent);
    }
}
