package com.projectsujan.sms.service;

import java.util.List;

import com.projectsujan.sms.entity.Student;

public interface StudentService {
	
	List<Student>getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(long id);

}
