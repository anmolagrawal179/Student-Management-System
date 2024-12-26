package com.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.exception.StudentNotFoundException;
import com.sms.repository.StudentRepository;
import com.sms.response.StudentResponse;
import com.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StudentResponse addStudent(StudentResponse studentResponse) {
		
		Student student=modelMapper.map(studentResponse, Student.class);
		Student savedStudent=studentRepository.save(student);
		
		return modelMapper.map(savedStudent,StudentResponse.class);
		
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		
		List<Student>  studentList=studentRepository.findAll();
		List<StudentResponse> studentResponseList=studentList.stream().map(student->modelMapper.map(student,StudentResponse.class)).collect(Collectors.toList());
		return studentResponseList;
		
	}

	@Override
	public StudentResponse getStudentById(long id) {
		
		Student student =studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
		
		return modelMapper.map(student,StudentResponse.class);
	}

	@Override
	public StudentResponse updateStudent(StudentResponse studentResponse, long id) {
		
		Student newStudent =studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
		Student student=modelMapper.map(studentResponse,Student.class);
		newStudent.setName(student.getName());
		newStudent.setAge(student.getAge());
		newStudent.setEmail(student.getEmail());
		Student savedNewStudent=studentRepository.save(newStudent);
		
		return modelMapper.map(savedNewStudent,StudentResponse.class);
	}

	@Override
	public void deleteStudent(long id) {
		
		Student student =studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
		studentRepository.delete(student);
	}

	
}
