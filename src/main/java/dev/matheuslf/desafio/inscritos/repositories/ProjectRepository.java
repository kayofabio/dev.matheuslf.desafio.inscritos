package dev.matheuslf.desafio.inscritos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.matheuslf.desafio.inscritos.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
