package com.example.university.application.studentapp.service;

import com.example.university.application.studentapp.model.Course;
import com.example.university.application.studentapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {

        if (courseRepository.existsById(courseId)) {

            updatedCourse.setId(courseId);

            return courseRepository.save(updatedCourse);
        } else {

            return null;
        }
    }

    public boolean deleteCourse(Long courseId) {

        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
            return true;
        } else {

            return false;
        }
    }
}