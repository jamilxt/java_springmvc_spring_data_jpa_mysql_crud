package com.spring5.practice.repositories;

import com.spring5.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(
//            value = "SELECT * FROM student_courses sc INNER JOIN tbl_student s ON sc.student_id = s.id INNER JOIN tbl_course c ON sc.course_id = c.id",
//            nativeQuery = true
//    )
//    List<Student> findAllWithCourses();

//    Student findById(Long Id);

//    Student findByCountryCode(String countryCode);

//    Student findById(Long Id);

//    List<Student> ;


}
