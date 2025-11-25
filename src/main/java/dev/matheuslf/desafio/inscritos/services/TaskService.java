package dev.matheuslf.desafio.inscritos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import dev.matheuslf.desafio.inscritos.dto.TaskInsertDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskUpdateDTO;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;
import dev.matheuslf.desafio.inscritos.repositories.TaskRepository;
import dev.matheuslf.desafio.inscritos.specifications.TaskSpecs;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectService projectService;
	
	public List<Task> findAll(TaskStatus status, Long projectId) {
		Specification<Task> spec = Specification.where(TaskSpecs.hasStatus(status)).and(TaskSpecs.hasProject(projectId));
		return taskRepository.findAll(spec);
	}
	
	public Task findById(Long id) {
		return taskRepository.findById(id).get();
	}
	
	public Task insert(TaskInsertDTO dto) {
		Project project = projectService.findById(dto.projectId());
		Task obj = new Task(null, dto.title(), dto.description(), dto.status(), dto.priority(), dto.dueDate(), project);
		return taskRepository.save(obj);
	}
	
	public Task update(Long id ,TaskUpdateDTO dto) {
		Task obj = findById(id);
		obj.setStatus(dto.status());
		return taskRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}
}
