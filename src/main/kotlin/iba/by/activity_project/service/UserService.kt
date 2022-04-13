package iba.by.activity_project.service

import iba.by.activity_project.entity.User
import iba.by.activity_project.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val db: UserRepository) {

    fun getAllUsers(): List<User> = db.findAll()

    fun post(user: User) = db.save(user)


    fun deleteUser(id: Long) = db.deleteById(id)

    fun findUserById(id: Long): Optional<User> = db.findById(id)

}