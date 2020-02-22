package com.spring5.practice.service;

import com.spring5.practice.dtos.StudentDto;
import com.spring5.practice.model.Course;
import com.spring5.practice.model.Student;
import com.spring5.practice.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> showAll() {
        return studentRepository.findAll();
    }


    public void save(StudentDto studentDto) {

        var country = countryService.getCountryByCode(studentDto.getCountryCode());

        var studentEntity = new Student();
        BeanUtils.copyProperties(studentDto, studentEntity);
        studentEntity.setCountry(country);

        Set<Course> courses = new HashSet<Course>();
        for (var courseCode : studentDto.getCourseCodes()) {
            var course = courseService.getCourseByCourseCode(courseCode);
            courses.add(course);
        }
        studentEntity.setCourses(courses);

        studentRepository.save(studentEntity);
    }
}
