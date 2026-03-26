package mx.rsalcidoa.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.rsalcidoa.course.entity.Course;
import mx.rsalcidoa.course.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	
	public CourseServiceImpl(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
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
}