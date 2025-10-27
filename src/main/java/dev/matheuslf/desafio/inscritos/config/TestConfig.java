package dev.matheuslf.desafio.inscritos.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskPriority;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		Project p1 = new Project(null, "FileCopy", "copiador de arquivos", new Date(), null);
		Date d1 = Date.from(Instant.parse("2022-10-20T15:40:35Z"));
		Date d2 = Date.from(Instant.parse("2024-05-12T11:45:50Z"));
		
		Project p2 = new Project(null, "ShortLink", "Encurtador de link", d1, d2);
		
		projectRepository.saveAll(Arrays.asList(p1, p2));
		
		d1 = Date.from(Instant.parse("2025-11-01T00:00:00Z"));
		d2 = Date.from(Instant.parse("2025-12-20T00:00:00Z"));
		Task t1 = new Task(null, "Documentação", "Criar documentação do projeto", TaskStatus.DOING, TaskPriority.HIGH, d1, p1);
		Task t2 = new Task(null, "Front-end", "Desenvolver o front-end do projeto", TaskStatus.DONE, TaskPriority.LOW, d2, p2);
		Task t3 = new Task(null, "Hospedagem", "Definir onde hospedar o projeto", TaskStatus.TODO, TaskPriority.MEDIUM, d2, p2);
		Task t4 = new Task(null, "Front-end", "Desenvolver o front-end do projeto", TaskStatus.TODO, TaskPriority.MEDIUM, d1, p1);
		Task t5 = new Task(null, "Back-end", "Criar back-end do projeto", TaskStatus.DOING, TaskPriority.HIGH, d1, p1);
		
		p1.getTasks().add(t1);
		p2.getTasks().add(t2);
		p2.getTasks().add(t3);
		p1.getTasks().add(t4);
		p1.getTasks().add(t5);
		taskRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		projectRepository.saveAll(Arrays.asList(p1, p2));
	}
}
