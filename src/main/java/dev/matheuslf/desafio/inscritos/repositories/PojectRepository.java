package dev.matheuslf.desafio.inscritos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.matheuslf.desafio.inscritos.entities.Project;

public interface PojectRepository extends JpaRepository<Project, Long> {

}
