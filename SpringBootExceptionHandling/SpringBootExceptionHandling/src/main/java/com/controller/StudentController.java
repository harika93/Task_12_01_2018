package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Student;
import com.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value= "/getStudent/{studentId}", method= RequestMethod.GET)
	public ModelAndView retreiveStudent(@PathVariable Long studentId) {
		
		ModelAndView modelAndView= new ModelAndView("studentDetails");
		
		Student student= studentService.findStudentByID(studentId);
		
		if(student != null) {
			modelAndView.addObject("student", student);
		}
		
		return modelAndView;
	}
}
