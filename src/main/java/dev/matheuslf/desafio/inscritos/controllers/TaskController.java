package dev.matheuslf.desafio.inscritos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskInsertDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskUpdateDTO;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;
import dev.matheuslf.desafio.inscritos.services.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll(
			@RequestParam(required = false) TaskStatus status, 
			@RequestParam(required = false) Long projectId) {
		List<TaskDTO> list = taskService.findAll(status, projectId)
				.stream()
				.map(x -> entityToDTO(x))
				.toList();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {	
		Task obj = taskService.findById(id);
		return ResponseEntity.ok().body(entityToDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> insert(@RequestBody @Valid TaskInsertDTO dto) {
		Task obj = taskService.insert(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityToDTO(obj));
	}
	
	@PutMapping(value = "/{id}/status")
	public ResponseEntity<TaskDTO> updateStatus(@PathVariable Long id, @RequestBody @Valid TaskUpdateDTO dto) {
		Task obj = taskService.update(id, dto);
		return ResponseEntity.ok().body(entityToDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		taskService.deleteById(id);
		return ResponseEntity.noContent().build();
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
