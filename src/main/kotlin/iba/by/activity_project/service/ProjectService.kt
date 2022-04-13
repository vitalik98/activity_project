package iba.by.activity_project.service

import iba.by.activity_project.entity.Project
import iba.by.activity_project.repository.ProjectRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(private val projectRepository: ProjectRepository) {

    fun getAllProjects(): List<Project> = projectRepository.findAll()

    fun post(project: Project) = projectRepository.save(project)

    fun deleteProject(id: Long) = projectRepository.deleteById(id)

    fun findProjectById(id: Long): Optional<Project> = projectRepository.findById(id)
}