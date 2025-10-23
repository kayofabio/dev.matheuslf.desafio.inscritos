package dev.matheuslf.desafio.inscritos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.matheuslf.desafio.inscritos.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
