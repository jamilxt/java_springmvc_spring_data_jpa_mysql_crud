package com.spring5.practice.service;

import com.spring5.practice.dtos.StudentDto;
import com.spring5.practice.model.Course;
import com.spring5.practice.model.Student;
import com.spring5.practice.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

//	private final HibernateConfig hibernateConfig;
//
//	public StudentService(HibernateConfig hibernateConfig) {
//		this.hibernateConfig = hibernateConfig;
//	}

    public List<Student> showAll() {
//		var cb = hibernateConfig.getCriteriaBuilder();
//		var cq = cb.createQuery(Student.class);
//		var root = cq.from(Student.class);
//		cq.select(root);
//		return hibernateConfig.getSession().getEntityManagerFactory().createEntityManager().createQuery(cq)
//				.getResultList();
//        return studentRepository.findAllWithCourses();
        return studentRepository.findAll();
    }

    @Transactional
    public void save(StudentDto studentDto) {
//		var session = hibernateConfig.getSession();
//		Transaction tx = session.getTransaction();
//		if (!tx.isActive())
//			tx = session.beginTransaction();
//		var country = countryService.getCountryByCode(studentDto.getCountryCode());
//		var studentEntity = new Student();
//		BeanUtils.copyProperties(studentDto, studentEntity);
//		studentEntity.setCountry(country);
//		Set<Course> courses = new HashSet<Course>();
//		for (var courseCode : studentDto.getCourseCodes()) {
//			var course = courseService.getCourseByCourseCode(courseCode);
//			courses.add(course);
//		}
//		studentEntity.setCourses(courses);
//		session.save(studentEntity);
//		session.flush();
//		tx.commit();
//        studentRepository.save(studentDto);

//		studentRepository.save(student);


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
