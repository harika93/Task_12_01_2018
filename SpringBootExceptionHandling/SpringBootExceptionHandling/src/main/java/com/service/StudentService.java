package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.StudentNotFoundException;
import com.model.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student findStudentByID(Long studentId) {
		/*
		 *	1st method to fetch student from repository 
		 */
		/*Optional<Student> studentOptional= studentRepository.findById(studentId);
		
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException("Student not found with id "+ studentId);
		}
		
		return studentOptional.get();*/
		
		/*
		 * 2nd method to fetch student from repository
		 */
		Student student= studentRepository.findById(studentId).orElseThrow( () -> 
											new StudentNotFoundException("Student not found with id "+  studentId));
		
		return student;
	}
}
