package iba.by.activity_project.resource


import iba.by.activity_project.entity.User
import iba.by.activity_project.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserResource(private val userService: UserService) {

    @GetMapping
    fun index() = userService.getAllUsers()

    @PostMapping
    fun post(@RequestBody user: User) = userService.post(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = userService.deleteUser(id)
}