package mx.rsalcidoa.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.rsalcidoa.student.dto.StudentDTO;
import mx.rsalcidoa.student.entity.Student;
import mx.rsalcidoa.student.service.IStudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	
	private final IStudentService studentService;
	
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addStudent(@RequestBody StudentDTO studentDTO) {
		studentService.addStudent(Student.builder()
								.name(studentDTO.getName())
								.lastName(studentDTO.getLastName())
								.email(studentDTO.getEmail())
								.courseId(studentDTO.getCourseId())
								.build());
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<StudentDTO>> findAllStudents() {
		return ResponseEntity.ok(
				studentService.findAllStudents()
				.stream()
				.map(student -> StudentDTO.builder()
									.id(student.getId())
									.name(student.getName())
									.lastName(student.getLastName())
									.email(student.getEmail())
									.courseId(student.getCourseId())
									.build())
				.toList());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<StudentDTO> findStudentById(@PathVariable Long id) {
		Student student = studentService.findStudentById(id);
		StudentDTO studentDTO = StudentDTO.builder()
									.id(student.getId())
									.name(student.getName())
									.lastName(student.getLastName())
									.email(student.getEmail())
									.courseId(student.getCourseId())
									.build();
		return ResponseEntity.ok(studentDTO);
	}
	
	
	@GetMapping("/findByCourseId/{courseId}")
	public ResponseEntity<List<StudentDTO>> findStudentsByCourseId(@PathVariable Long courseId) {
		return ResponseEntity.ok(
				studentService.findStudentsByCourseId(courseId)
				.stream()
				.map(student -> StudentDTO.builder()
									.id(student.getId())
									.name(student.getName())
									.lastName(student.getLastName())
									.email(student.getEmail())
									.courseId(student.getCourseId())
									.build())
				.toList());
	}
}