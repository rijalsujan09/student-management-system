package com.projectsujan.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectsujan.sms.entity.Student;
import com.projectsujan.sms.service.StudentService;


@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String addStudentForm(Model model) {

		// create empty student to hold student form
		Student student = new Student();
		model.addAttribute("students", student);
		return "addstudent";

	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String updateStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editstudent";
	}

	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable("id") Long id,
			@ModelAttribute("student") Student student ,
			Model model) {
		
		Student existingstudent = studentService.getStudentById(id);
		
		existingstudent.setId(id);
		existingstudent.setFirstName(student.getFirstName());
		existingstudent.setLastName(student.getLastName());
		existingstudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingstudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deteteStudent(@PathVariable ("id") Long id) {
		
		studentService.deleteStudentById(id);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/view/{id}")
	public String viewStudent(@PathVariable ("id") Long id, @ModelAttribute("student") Student student,  Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		return "viewstudent";
	}
	

}
