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
		Task t1 = new Task(null, "limite de arquivos", "estabelecer limite de arquivos para cópia", TaskStatus.DOING, TaskPriority.HIGH, d1);
		
		taskRepository.save(t1);
	}
}
