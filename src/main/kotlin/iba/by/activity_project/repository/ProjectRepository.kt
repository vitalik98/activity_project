package iba.by.activity_project.repository

import iba.by.activity_project.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository:JpaRepository<Project,Long> {
}