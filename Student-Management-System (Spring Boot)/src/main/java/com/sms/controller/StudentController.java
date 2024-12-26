package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.response.StudentResponse;
import com.sms.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	ResponseEntity<StudentResponse> addStudent(@RequestBody StudentResponse studentResponse) {
		return new ResponseEntity<StudentResponse>(studentService.addStudent(studentResponse),HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<StudentResponse>> getAllStudents()
	{
		return new ResponseEntity<List<StudentResponse>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<StudentResponse> getStudentById(@PathVariable long id)
	{
		return new ResponseEntity<StudentResponse>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentResponse studentResponse,@PathVariable long id)
	{
		return new ResponseEntity<StudentResponse>(studentService.updateStudent(studentResponse,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable long id)
	{
		studentService.deleteStudent(id);
	}
	
}