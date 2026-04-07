package com.example.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.Student;
import com.example.service.StudentService;
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
private final StudentService service;
public StudentController(StudentService service) {
this.service = service;
}
@PostMapping
public ResponseEntity<Student> addStudent(@RequestBody Student student) {
return ResponseEntity.ok(service.addStudent(student));
}
@GetMapping
public ResponseEntity<List<Student>> getAllStudents() {
return ResponseEntity.ok(service.getAllStudents());
}
@PutMapping("/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id,
@RequestBody Student student) {
	return ResponseEntity.ok(service.updateStudent(id, student));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	service.deleteStudent(id);
	return ResponseEntity.ok("Student deleted successfully");
	}
	}
	Application.properties:
	spring.application.name=student-management-system
	# Database Configuration
	spring.datasource.url=jdbc:mysql://localhost:3306/hibernatedb
	spring.datasource.username=root
	spring.datasource.password=root@123
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	# Hibernate Configuration
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true
	# Server Port (Optional)
	server.port=8085