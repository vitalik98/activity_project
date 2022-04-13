package iba.by.activity_project.service

import iba.by.activity_project.entity.UserProject
import iba.by.activity_project.repository.UserProjectRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserProjectService(private val userProjectRepository: UserProjectRepository) {

    fun getAllUserProject(): List<UserProject> = userProjectRepository.findAll()

    fun post(userProject: UserProject) = userProjectRepository.save(userProject)

    fun deleteUserProject(id: Long) = userProjectRepository.deleteById(id)

    fun findUserProjectById(id: Long): Optional<UserProject> = userProjectRepository.findById(id)

    fun findAllUserProjectByUserId(id: Long): List<UserProject> = userProjectRepository.findAllByUserId(id)

    fun findAllUserProjectByProjectId(id: Long): List<UserProject> = userProjectRepository.findAllByProjectId(id)
}