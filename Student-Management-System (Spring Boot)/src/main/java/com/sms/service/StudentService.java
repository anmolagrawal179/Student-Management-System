package com.sms.service;

import java.util.List;

import com.sms.response.StudentResponse;

public interface StudentService {

	StudentResponse addStudent(StudentResponse studentResponse);
	
	List<StudentResponse> getAllStudents();
	
	StudentResponse getStudentById(long id);
	
	StudentResponse updateStudent(StudentResponse studentResponse, long id);
	
	void deleteStudent(long id);
}