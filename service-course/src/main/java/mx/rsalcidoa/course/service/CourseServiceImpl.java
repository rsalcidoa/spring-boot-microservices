package mx.rsalcidoa.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.rsalcidoa.course.client.IStudentClient;
import mx.rsalcidoa.course.dto.StudentDTO;
import mx.rsalcidoa.course.entity.Course;
import mx.rsalcidoa.course.http.response.StudentsByCourseIdResponse;
import mx.rsalcidoa.course.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	private IStudentClient studentClient;
	
	public CourseServiceImpl(ICourseRepository courseRepository, IStudentClient studentClient) {
		this.courseRepository = courseRepository;
		this.studentClient = studentClient;
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public List<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public Course findCourseById(Long id) {
		return courseRepository.findById(id).orElseThrow();
	}

	@Override
	public StudentsByCourseIdResponse findStudentsByCourseId(Long idCourse) {

		Course course = courseRepository.findById(idCourse).orElse(new Course());
		List<StudentDTO> studentDTOList = studentClient.getAllStudentsByCourseId(idCourse);
		return StudentsByCourseIdResponse.builder()
				.courseName(course.getName())
				.teacher(course.getTeacher())
				.studentDTOList(studentDTOList)
				.build();
	}
}