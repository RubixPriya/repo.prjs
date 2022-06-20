package com.rubix.example.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentID = -1;
	
	@Column(name="name")
	private String studentName;
	
	private String address;
	
	private int grade;

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Student() {
		
	}
	
	public Student(long studentID, String studentName, String address, int grade) {
		
		this.studentID = studentID;
		this.studentName = studentName;
		this.address = address;
		this.grade = grade;
		
	}
	
	@Override
	public String toString() {
		return String.format("Student [studentID=%s, studentName=%s, address=%s, grade=%s]", studentID, studentName, address, grade);
	}
	
	@Override
	public int hashCode() {
		return (int) studentID;
	}
	
	@Override
	public boolean equals(Object newObj) {
		boolean result = false;
		if (newObj instanceof Student) {
			Student student = (Student) newObj;
			result = (this.studentID == student.studentID);
			
		}
		return result;
	}
	
	
	}
	
	

