package iba.by.activity_project.repository

import iba.by.activity_project.entity.UserProject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jdbc.repository.query.Query

interface UserProjectRepository: JpaRepository<UserProject, Long> {

    @Query("select * from user_project where user_id=:id")
    fun findAllByUserId(id: Long):List<UserProject>

    @Query("select * from user_project where project_id=:id")
    fun findAllByProjectId(id: Long): List<UserProject>
}