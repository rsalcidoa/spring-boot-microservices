package mx.rsalcidoa.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.rsalcidoa.student.entity.Student;
import mx.rsalcidoa.student.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	private IStudentRepository studentRepository;
	
	public StudentServiceImpl(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Override
	public List<Student> findStudentsByCourseId(Long idCourse) {
		return studentRepository.findAllByCourseId(idCourse);
	}
}