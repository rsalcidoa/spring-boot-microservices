package mx.rsalcidoa.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.rsalcidoa.course.entity.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Long>{}
