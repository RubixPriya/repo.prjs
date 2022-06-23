package com.rubix.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class StudentBasedService {
	
	@Autowired
	private StudentBasedRepository studentBasedRepository;
	
	public void useStandardRepoMethods() {
		
		Student newStudent = new Student(999, "Priya", "Sdn", 8);
		newStudent = studentBasedRepository.save(newStudent);
		System.out.printf(" student inserted and the id is %d\n" , newStudent.getStudentID());
		
		displayStudent("All Students ", studentBasedRepository.findAll());
		
		System.out.printf(" student count is %d\n", studentBasedRepository.count());
	}
	
	public void displayStudent(String message, Iterable<Student> Students) {
		System.out.printf("\n %s\n", message);
		for (Student stu: Students) {
			System.out.println(stu);
		}
	}
	
	
	
	public void useCustomQueryMethods () {
		
		//Get all Students based on grade
		displayStudent("\n Student Based on Grade: \n", studentBasedRepository.findBygrade(8));
		
		System.out.println("Finished Printing based on grade");
		
		displayStudent("\n Students Printing between the grade range from and to:", studentBasedRepository.findInGradeRange(6, 9));
		
		System.out.printf(" Student Print for particular id and name: ", studentBasedRepository.findBygradeAndStudentName(6, "Aruna"));
		
		Student student = studentBasedRepository.findBygradeAndStudentName(6, "Aruna");
		System.out.println(student);
		
		Pageable pageable = PageRequest.of(0,5, Direction.ASC, "grade");
		Page<Student> page = studentBasedRepository.findByGradeGreaterThan(5, pageable);
		displayStudent("Student Grade for Higher Classes :", page.getContent());
		
		pageable = PageRequest.of(1, 5, Direction.ASC, "grade");
		page = studentBasedRepository.findByGradeGreaterThan(5, pageable);
		displayStudent("Student Grade for Higher Classes :", page.getContent());
		
	}

}
