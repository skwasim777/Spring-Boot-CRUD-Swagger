package com.springbootcrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.entity.Student;
import com.springbootcrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		if (studentRepository.existsById(id)) {
			return studentRepository.findById(id).orElse(null);
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Integer id, Student student) {
		if (studentRepository.existsById(id)) {
			student.setId(id);
			return studentRepository.save(student);
		}
		return null;
	}

	@Override
	public String deleteStudent(Integer id) {
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "deleted successfully";
		}
		return null;
	}

}
