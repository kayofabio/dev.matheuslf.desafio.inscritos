package dev.matheuslf.desafio.inscritos.dto;

import java.util.Date;

import dev.matheuslf.desafio.inscritos.entities.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;

public record TaskDTO(Long id, String title, String description, TaskStatus status, TaskPriority priority, Date dueDate, Long projectId) {

}
