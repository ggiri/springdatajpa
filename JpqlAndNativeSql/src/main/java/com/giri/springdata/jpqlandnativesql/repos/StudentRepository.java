package com.giri.springdata.jpqlandnativesql.repos;

import com.giri.springdata.jpqlandnativesql.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);
    @Query("select s1.firstName, s1.lastName from Student s1")
    List<Object[]> findStudentPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>:min and score<:max")
    List<Student> findAllStudentsBetweenScores(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName=:firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

    @Query(value="select * from student", nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value="select * from student where fname=:firstName", nativeQuery = true)
    List<Student> findAllStudentsByFirstNameNQ(@Param("firstName") String firstName);

    @Query(value="select s1.fname, s1.lname from student s1 where s1.fname=:firstName ", nativeQuery = true)
    List<Object[]> findAllStudentsPartialInfoNQ(@Param("firstName") String firstName);
}
