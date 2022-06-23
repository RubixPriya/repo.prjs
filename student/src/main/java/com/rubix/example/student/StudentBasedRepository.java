package com.rubix.example.student;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentBasedRepository extends CrudRepository<Student, Long>{
	
	List<Student> findBystudentName(String studentName);
	
	Student findBygradeAndStudentName(int grade, String studentName);
	
	List<Student> findBygrade(int grade);
	
	@Query("select s from Student s where s.grade >= ?1 and s.grade <= ?2")
	List<Student> findInGradeRange(int from, int to);
	
	Page<Student> findByGradeGreaterThan(int grade, Pageable pageable);
	

}
