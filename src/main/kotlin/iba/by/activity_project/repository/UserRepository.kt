package iba.by.activity_project.repository

import iba.by.activity_project.entity.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    @Query("select * from test")
    fun findUsers():List<User>
}