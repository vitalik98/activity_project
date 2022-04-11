package iba.by.activity_project.entity

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Id

@Table("Users")
data class User(@Id val id: Long?, val name: String)