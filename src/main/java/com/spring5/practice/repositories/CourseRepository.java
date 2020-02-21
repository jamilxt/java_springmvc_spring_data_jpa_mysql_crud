package com.spring5.practice.repositories;

import com.spring5.practice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByActiveIsTrue();

    Course findByCourseId(Long id);

    Course findByCourseCode(String courseCode);

}
