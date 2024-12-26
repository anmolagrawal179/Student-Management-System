package com.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private String email;
	
	
}
