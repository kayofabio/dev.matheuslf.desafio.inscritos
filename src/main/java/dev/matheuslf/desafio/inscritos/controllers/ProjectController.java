package dev.matheuslf.desafio.inscritos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> findAll() {
		List<ProjectDTO> list = projectService.findAll()
				.stream()
				.map(x -> entityToDTO(x))
				.toList();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {
		ProjectDTO obj = entityToDTO(projectService.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	private ProjectDTO entityToDTO(Project project) {
		return new ProjectDTO(project.getId(), 
				project.getName(), 
				project.getDescription(), 
				project.getStartDate(), 
				project.getEndDate(), 
				project.getTasks());
	}
}
