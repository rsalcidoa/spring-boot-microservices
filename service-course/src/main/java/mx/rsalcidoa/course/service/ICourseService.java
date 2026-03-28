package mx.rsalcidoa.course.service;

import java.util.List;

import mx.rsalcidoa.course.entity.Course;
import mx.rsalcidoa.course.http.response.StudentsByCourseIdResponse;

public interface ICourseService {

	void addCourse(Course course);
	List<Course> findAllCourses();
	Course findCourseById(Long id);
	StudentsByCourseIdResponse findStudentsByCourseId(Long idCourse);
}
