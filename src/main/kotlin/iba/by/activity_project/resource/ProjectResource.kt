package iba.by.activity_project.resource

import iba.by.activity_project.entity.Project
import iba.by.activity_project.service.ProjectService
import iba.by.activity_project.service.UserProjectService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/projects")
class ProjectResource(
    private val projectService: ProjectService,
    private val userProjectService: UserProjectService
) {

    @GetMapping
    fun index(@PageableDefault(size = 5) pageable: Pageable) = projectService.getAllProjectsBySort(pageable)

    @GetMapping("/{id}")
    fun getProject(@PathVariable id: Long): ResponseEntity<Optional<Project>> {
        return if (projectService.findProjectById(id).isPresent)
            ResponseEntity.ok(projectService.findProjectById(id))
        else
            ResponseEntity.notFound().build()
    }

    @GetMapping("/users/{project_id}")
    fun getUserProject(@PathVariable project_id: Long) = userProjectService.findAllUserProjectByProjectId(project_id)

    @PostMapping
    fun post(@RequestBody project: Project) = projectService.post(project)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return if (projectService.findProjectById(id).isPresent)
            ResponseEntity.ok(projectService.deleteProject(id))
        else
            ResponseEntity.badRequest().build()
    }
}