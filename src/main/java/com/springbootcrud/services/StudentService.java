package com.springbootcrud.services;

import java.util.List;

import com.springbootcrud.entity.Student;

public interface StudentService {
	public Student createStudent(Student student);

	public Student getStudentById(Integer id);

	public List<Student> getAllStudents();

	public Student updateStudent(Integer id, Student student);
	
	public String deleteStudent(Integer id);
}
