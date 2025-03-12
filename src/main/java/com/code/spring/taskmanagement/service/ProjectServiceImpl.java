package com.code.spring.taskmanagement.service;


import com.code.spring.taskmanagement.entity.Project;
import com.code.spring.taskmanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import com.code.spring.taskmanagement.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public Project updateProject(Long projectId, Project projectDetails) {
        Project project = getProjectById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + projectId));
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        Project project = getProjectById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + projectId));
        projectRepository.delete(project);
    }

    @Override
    public Optional<List<Project>> getProjectsByUser(Long userId) {
        List<Project> projects = projectRepository.findByCreatedByUserId(userId);
        return projects.isEmpty() ? Optional.empty() : Optional.of(projects);
    }
}
