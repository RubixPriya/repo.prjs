package com.rubix.example.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public List<Student> displayStudentList() {
		
		String jpql = "select s from Student s";
		TypedQuery<Student> student = entityManager.createQuery(jpql, Student.class);
		
		return student.getResultList();
		
	}
	
	public Student getStudentInfo(long id) {
		
		return entityManager.find(Student.class, id);
	}
	
	@Transactional
	public void insertStudent(Student s) {
		entityManager.persist(s);
	}
	
	@Transactional
	public void updateStudent(long id) {
		Student student = entityManager.find(Student.class, id);
		student.setGrade(student.getGrade() + 1);
		
	}
	
	@Transactional
	public void deleteStudent(long id) {
		
		Student removeStudent = entityManager.find(Student.class, id);
	    entityManager.remove(removeStudent);
	}
	
	public long getStudentCount() {
		String jpql = "select count(s) from Student s";
		TypedQuery<Long> studentCount = entityManager.createQuery(jpql, Long.class);
		return studentCount.getSingleResult();
		
		
	}
	

}
