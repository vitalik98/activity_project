package iba.by.activity_project.service

import iba.by.activity_project.entity.User
import iba.by.activity_project.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun post(user: User) = userRepository.save(user)

    fun deleteUser(id: Long) = userRepository.deleteById(id)

    fun findUserById(id: Long): Optional<User> = userRepository.findById(id)

}