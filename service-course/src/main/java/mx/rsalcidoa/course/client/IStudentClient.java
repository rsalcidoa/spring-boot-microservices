package mx.rsalcidoa.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.rsalcidoa.course.dto.StudentDTO;

@FeignClient(name = "msvc-student", url = "http://localhost:9080/api/v1/student")
public interface IStudentClient {

	@GetMapping("/findByCourseId/{courseId}")
	List<StudentDTO> getAllStudentsByCourseId(@PathVariable Long courseId);
}