package com.impag.training.jpa.repository;

import com.impag.training.jpa.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{
}
