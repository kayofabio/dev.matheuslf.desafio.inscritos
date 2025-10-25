package dev.matheuslf.desafio.inscritos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<Project>> findAll() {
		List<Project> list = projectService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> findById(@PathVariable Long id) {
		Project obj = projectService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
