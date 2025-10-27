package dev.matheuslf.desafio.inscritos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll() {
		List<TaskDTO> list = taskService.findAll()
				.stream()
				.map(x -> entityToDTO(x))
				.toList();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
		TaskDTO obj = entityToDTO(taskService.findByIdd(id));
		return ResponseEntity.ok().body(obj);
	}
	
	private TaskDTO entityToDTO(Task task) {
		return new TaskDTO(task.getId(), 
				task.getTitle(), 
				task.getDescription(),
				task.getStatus(),
				task.getPriority(),
				task.getDueDate(),
				task.getProject().getId());
	}
}
