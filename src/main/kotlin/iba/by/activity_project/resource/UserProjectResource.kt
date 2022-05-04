package iba.by.activity_project.resource

import iba.by.activity_project.entity.UserProject
import iba.by.activity_project.service.UserProjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/userProject")
class UserProjectResource(private val userProjectService: UserProjectService) {

    @GetMapping
    fun index() = userProjectService.getAllUserProject()

    @GetMapping("/{id}")
    fun getUserProject(@PathVariable id: Long): ResponseEntity<Optional<UserProject>> {
        return if(userProjectService.findUserProjectById(id).isPresent)
            ResponseEntity.ok(userProjectService.findUserProjectById(id))
        else
            ResponseEntity.notFound().build()
    }

    @PostMapping
    fun post(@RequestBody userProject: UserProject) = userProjectService.post(userProject)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return if(userProjectService.findUserProjectById(id).isPresent)
            ResponseEntity.ok(userProjectService.deleteUserProject(id))
        else
            ResponseEntity.badRequest().build()
    }

}