package com.deneme.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
