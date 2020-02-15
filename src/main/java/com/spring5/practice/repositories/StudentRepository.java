package com.spring5.practice.repositories;

import com.spring5.practice.model.Country;
import com.spring5.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

//    Student findById(Long Id);

//    Student findByCountryCode(String countryCode);

//    Student findById(Long Id);



}
