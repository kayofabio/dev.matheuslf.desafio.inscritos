package dev.matheuslf.desafio.inscritos.dto;

import java.util.Date;
import java.util.List;

import dev.matheuslf.desafio.inscritos.entities.Task;

public record ProjectDTO(Long id, String name, String description, Date startDate, Date endDate, List<Task> tasks) {

}
