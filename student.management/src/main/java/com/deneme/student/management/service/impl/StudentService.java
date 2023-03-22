package com.deneme.student.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deneme.student.management.dto.StudentDTO;
import com.deneme.student.management.entity.Student;
import com.deneme.student.management.exception.StudentNotFoundException;
import com.deneme.student.management.repository.StudentRepository;
import com.deneme.student.management.service.IStudentService;

@Service 
public class StudentService implements IStudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public List<Student> list() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException {
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new StudentNotFoundException("Aranan Öğrenci Bulunamadı!");
		}
	}

	@Override
	public Student add(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public Student update(Student student) {
		return repo.saveAndFlush(student);
	}

	@Override
	public Integer delete(Student student) {
		
		repo.delete(student);
		return student.getId();
	}

}
