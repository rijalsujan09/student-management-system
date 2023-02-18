package com.projectsujan.sms.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.sms.entity.Student;

// we do not have to add @Repository  annotation  because  
// JpaRepository already have internal implementation of @Repository annotation

public interface StudentRepository extends JpaRepository<Student, Long> {

	

}
