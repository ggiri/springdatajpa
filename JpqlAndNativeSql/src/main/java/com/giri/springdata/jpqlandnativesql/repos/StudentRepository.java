package com.giri.springdata.jpqlandnativesql.repos;

import com.giri.springdata.jpqlandnativesql.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents();
    @Query("select s1.firstName, s1.lastName from Student s1")
    List<Object[]> findStudentPartialData();
}
