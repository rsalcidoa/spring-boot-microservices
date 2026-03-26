package mx.rsalcidoa.course.controller;

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

import mx.rsalcidoa.course.dto.CourseDTO;
import mx.rsalcidoa.course.entity.Course;
import mx.rsalcidoa.course.service.ICourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
	
	private final ICourseService courseService;
	
	public CourseController(ICourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCourse(@RequestBody CourseDTO courseDTO) {
		courseService.addCourse(Course.builder()
								.name(courseDTO.getName())
								.teacher(courseDTO.getTeacher())
								.build());
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<CourseDTO>> findAllCourses() {
		return ResponseEntity.ok(
				courseService.findAllCourses()
				.stream()
				.map(course -> CourseDTO.builder()
								.id(course.getId())
								.name(course.getName())
								.teacher(course.getTeacher())
								.build())
				.toList());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<CourseDTO> findCourseById(@PathVariable Long id) {
		Course course = courseService.findCourseById(id);
		CourseDTO courseDTO = CourseDTO.builder()
								.id(course.getId())
								.name(course.getName())
								.teacher(course.getTeacher())
								.build();
		return ResponseEntity.ok(courseDTO);
	}
}
