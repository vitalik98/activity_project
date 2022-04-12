package iba.by.activity_project.repository

import iba.by.activity_project.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}