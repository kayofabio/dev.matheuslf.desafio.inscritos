package dev.matheuslf.desafio.inscritos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.matheuslf.desafio.inscritos.dto.ProjectInsertDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	public List<Project> findAll() {
		return repository.findAll();
	}
	
	public Project findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Project insert(ProjectInsertDTO dto) {
		Project project = new Project(null, dto.name(), dto.description(), dto.startDate(), dto.endDate());
		if (dto.tasks() != null) {
			for (TaskDTO taskDTO : dto.tasks()) {
				Task task = new Task(null, taskDTO.title(), taskDTO.description(), taskDTO.status(), taskDTO.priority(), taskDTO.dueDate(), project);
				project.getTasks().add(task);
			}
		}
		return repository.save(project);
	}
}
