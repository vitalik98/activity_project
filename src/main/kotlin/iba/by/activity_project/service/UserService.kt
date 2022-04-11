package iba.by.activity_project.service

import iba.by.activity_project.entity.User
import iba.by.activity_project.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val db: UserRepository) {

    fun getAllUsers(): List<User> = db.findUsers()
}