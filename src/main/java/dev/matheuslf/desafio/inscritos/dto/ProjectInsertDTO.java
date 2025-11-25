package dev.matheuslf.desafio.inscritos.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ProjectInsertDTO(
		@NotEmpty @Size(min = 3, max = 100) String name, 
		String description, 
		Date startDate, 
		Date endDate, 
		List<TaskDTO> tasks) {
}
