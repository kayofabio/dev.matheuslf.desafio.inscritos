package dev.matheuslf.desafio.inscritos.specifications;

import org.springframework.data.jpa.domain.Specification;

import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.TaskStatus;

public class TaskSpecs {

	public static Specification<Task> hasStatus(TaskStatus status) {
        return (root, query, cb) ->
            status == null ? null : cb.equal(root.get("status"), status);
    }

    public static Specification<Task> hasProject(Long projectId) {
        return (root, query, cb) ->
            projectId == null ? null : cb.equal(root.get("project").get("id"), projectId);
    }

}
