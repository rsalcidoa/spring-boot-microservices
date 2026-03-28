package mx.rsalcidoa.course.http.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.rsalcidoa.course.dto.StudentDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsByCourseIdResponse {

	private String courseName;
	private String teacher;
	private List<StudentDTO> studentDTOList;
}
