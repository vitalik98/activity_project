package iba.by.activity_project.resource


import iba.by.activity_project.entity.User
import iba.by.activity_project.service.UserProjectService
import iba.by.activity_project.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/users")
class UserResource(
    private val userService: UserService,
    private val userProjectService: UserProjectService
    ) {

    @GetMapping
    fun index() = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<Optional<User>> {
        return if(userService.findUserById(id).isPresent)
            ResponseEntity.ok(userService.findUserById(id))
        else
            ResponseEntity.notFound().build()
    }

    @GetMapping("/projects/{user_id}")
    fun getUserProject(@PathVariable user_id:Long) = userProjectService.findAllUserProjectByUserId(user_id)

    @PostMapping
    fun post(@RequestBody user: User) = userService.post(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return if(userService.findUserById(id).isPresent)
            ResponseEntity.ok(userService.deleteUser(id))
        else
            ResponseEntity.badRequest().build()
    }

}