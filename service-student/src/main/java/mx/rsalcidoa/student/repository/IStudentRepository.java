package mx.rsalcidoa.student.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.rsalcidoa.student.entity.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAllByCourseId(Long idCourse);
}