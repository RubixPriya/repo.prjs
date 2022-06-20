package com.rubix.example.student;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	
	private Scanner scanner = new Scanner(System.in);
	
	@Autowired
	private StudentRepository studentRepo;
	
	public void displayEntites() {
		
		//To display the student count
		long studentCount = studentRepo.getStudentCount();
		System.out.printf("Student Count is %s\n", studentCount);
		
		System.out.println("List of Students as follows");
		displayStudents(studentRepo);
		
		long id = getStudentIdToDisplay(" Enter Id to display: ");
		Student student = studentRepo.getStudentInfo(id);
		System.out.printf("\n%s\n", student);
		
	}
	
	public void displayStudents(StudentRepository studentRepo) {
		// To display the studentList
		List<Student> studentsList = studentRepo.displayStudentList();
		for (Student students : studentsList) {
			System.out.println(students);
		}

	}
	
	public long getStudentIdToDisplay(String message) {
		System.out.printf("\n%s\n", message);
		return scanner.nextLong();
		
	}
	
	public void modifyEntities() {
		
		displayStudents(studentRepo);
		
		System.out.println("Going to add new Student");
		Student newStudent = new Student(-1, "PriyaDharshini", "Sholavandhan", 2);
		System.out.println("New Student Object is : " + newStudent);
		studentRepo.insertStudent(newStudent);
		
		System.out.println("Printing all the records after insertion of a new record to verify");
		displayStudents(studentRepo);
		
		
		
		System.out.println("Going to update a student record....");
		
		long id = getStudentIdToDisplay(" Enter Id to update: ");
		studentRepo.updateStudent(id);
		displayStudents(studentRepo);
		
		long deleteId = getStudentIdToDisplay(" Enter Id to delete: ");
		studentRepo.deleteStudent(deleteId);
		displayStudents(studentRepo);
		
		
	}

	
}
