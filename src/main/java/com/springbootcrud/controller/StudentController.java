package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.entity.Student;
import com.springbootcrud.services.StudentServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/students")
@Api(tags = "Student Management API")
public class StudentController {
	@Autowired
	private StudentServiceImpl impl;

	@PostMapping
	@ApiOperation(value = "create student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student createStudent = impl.createStudent(student);
		return new ResponseEntity<Student>(createStudent, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "get student by id")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		Student studentById = impl.getStudentById(id);
		if (studentById != null) {
			return new ResponseEntity<Student>(studentById, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(studentById, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	@ApiOperation(value = "get all student")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudents = impl.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "update student")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		Student updateStudent = impl.updateStudent(id, student);
		if (updateStudent != null) {
			return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(updateStudent, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete student")
	public String deleteStudent(@PathVariable Integer id) {
		String deleteStudent = impl.deleteStudent(id);
		return deleteStudent;

	}
}
