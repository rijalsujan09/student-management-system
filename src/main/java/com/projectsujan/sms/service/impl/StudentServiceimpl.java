package com.projectsujan.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectsujan.sms.entity.Student;
import com.projectsujan.sms.repository.StudentRepository;
import com.projectsujan.sms.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {
	
	private StudentRepository studentRepository;
	

	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	
	@Override
	public List<Student> getAllStudents() {
		
		return  studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
	}

}
