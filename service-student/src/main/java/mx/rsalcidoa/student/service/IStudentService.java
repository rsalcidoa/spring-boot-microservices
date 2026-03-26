package mx.rsalcidoa.student.service;

import java.util.List;

import mx.rsalcidoa.student.entity.Student;

public interface IStudentService {
	void addStudent(Student student);
	List<Student> findAllStudents();
	Student findStudentById(Long id);
	List<Student> findStudentsByCourseId(Long idCourse);
}
