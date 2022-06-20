package com.rubix.example.student;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDB {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init() {
		
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Subha", "Salem", 6});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"James", "Erode", 9});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Walter", "Coimbatore", 12});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Aruna", "Madurai", 6});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Lakshanya", "Trichy", 7});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Kirubakaran", "Salem", 2});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Monisha", "Salem", 4});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"AAkash", "Erode", 8});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Lakshmanan", "Trichy", 5});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Muthu", "Coimbatore", 4});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Lakshanya", "Madurai", 3});
		jdbcTemplate.update("insert into students (name, address, grade) values(?, ?, ?)", new Object[] {"Akshaya", "Bhavani", 2});
		
	}
	

}
