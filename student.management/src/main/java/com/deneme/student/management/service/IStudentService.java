package com.deneme.student.management.service;

import java.util.List;

import com.deneme.student.management.dto.StudentDTO;
import com.deneme.student.management.entity.Student;
import com.deneme.student.management.exception.StudentNotFoundException;

public interface IStudentService {
	
	List<Student> list();
	Student getStudentById (Integer id) throws StudentNotFoundException;
	Student add(Student student);
	Student update(Student student);
	Integer delete(Student student);

}
