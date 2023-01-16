package com.giri.springdata.jpqlandnativesql;

import com.giri.springdata.jpqlandnativesql.entities.Student;
import com.giri.springdata.jpqlandnativesql.repos.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JpqlAndNativeSqlApplicationTests {
	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("Giridhar");
		student.setLastName("Gopal");
		student.setScore(100);
		Student student1 = new Student();
		student1.setFirstName("Giri");
		student1.setLastName("Gopal");
		student1.setScore(90);
		Student student2 = new Student();
		student2.setFirstName("Giri");
		student2.setLastName("G");
		student2.setScore(80);
		Student student3 = new Student();
		student3.setFirstName("Gi");
		student3.setLastName("Go");
		student3.setScore(70);
		repository.save(student);
		repository.save(student1);
		repository.save(student2);
		repository.save(student3);
	}

	@Test
	void testFindAllStudents(){
		Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC, "id");
		List<Student> allStudents = repository.findAllStudents(pageable);
		allStudents.forEach(s-> System.out.println(s.toString()));
	}

	@Test
	void testPartialDataOfStudents(){
		List<Object[]> students = repository.findStudentPartialData();
		for (Object[] student : students) {
			System.out.println(student[0]+" "+student[1]);
		}
	}

	@Test
	void testFindAllStudentsByFirstName() {
		List<Student> students = repository.findAllStudentsByFirstName("Giri");
		students.forEach(p->{
			System.out.println("Students first name:"+p);
		});
	}

	@Test
	void testFindAllStudentsBetweenScores() {
		List<Student> students = repository.findAllStudentsBetweenScores(70,100);
		students.forEach(p->{
			System.out.println("Students between the scores:"+p);
		});
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void testDeleteStudentByFirstName() {
		repository.deleteStudentsByFirstName("Giridhar");
		System.out.println(repository.count());
	}

	@Test
	void testFindAllStudentsNQ(){
		List<Student> students = repository.findAllStudentsNQ();
		students.forEach(s-> System.out.println(s));
	}

	@Test
	void testFindAllStudentsByFirstNameNQ(){
		List<Student> students = repository.findAllStudentsByFirstNameNQ("Giri");
		students.forEach(s-> System.out.println(s));
	}

	@Test
	void testFindAllStudentsPartialNQ(){
		List<Object[]> students = repository.findAllStudentsPartialInfoNQ("Giri");
		for(Object[] student:students){
			System.out.println(student[0]+" "+student[1]);
		}
	}

}
