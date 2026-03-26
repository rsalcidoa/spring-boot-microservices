package mx.rsalcidoa.course.service;

import java.util.List;

import mx.rsalcidoa.course.entity.Course;

public interface ICourseService {
	void addCourse(Course course);
	List<Course> findAllCourses();
	Course findCourseById(Long id);
}
