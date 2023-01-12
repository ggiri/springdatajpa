package com.giri.springdata.jpqlandnativesql;

import com.giri.springdata.jpqlandnativesql.entities.Student;
import com.giri.springdata.jpqlandnativesql.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		List<Student> allStudents = repository.findAllStudents();
		allStudents.forEach(s-> System.out.println(s.toString()));
	}

	@Test
	void testPartialDataOfStudents(){
		List<Object[]> students = repository.findStudentPartialData();
		for (Object[] student : students) {
			System.out.println(student[0]);
			System.out.println(student[1]);

		}
	}

}
