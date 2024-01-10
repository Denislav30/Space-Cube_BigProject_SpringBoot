package com.example.university.application.studentapp.service;

import com.example.university.application.studentapp.model.Student;
import com.example.university.application.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student updateStudent(Long studentId, Student updatedStudent) {

        if (studentRepository.existsById(studentId)) {

            updatedStudent.setId(studentId);

            return studentRepository.save(updatedStudent);
        } else {

            return null;
        }
    }

    public boolean deleteStudent(Long studentId) {

        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        } else {

            return false;
        }
    }
}
