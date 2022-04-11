package iba.by.activity_project.resource


import iba.by.activity_project.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserResource(private val userService: UserService) {



    @GetMapping("/users")
    fun index() = userService.getAllUsers()
}