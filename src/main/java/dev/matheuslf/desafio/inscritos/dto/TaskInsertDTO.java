package dev.matheuslf.desafio.inscritos.dto;

import java.util.Date;

import dev.matheuslf.desafio.inscritos.entities.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record TaskInsertDTO(
		@NotEmpty @Size(min = 3, max = 100) String title, 
		String description, 
		TaskStatus status, 
		TaskPriority priority, 
		Date dueDate, 
		Long projectId) {

}
