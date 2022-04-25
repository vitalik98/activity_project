package iba.by.activity_project.entity

import javax.persistence.*

@Entity
@Table(name = "projects")
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val type: String
) {
    constructor() : this(null,"","")

}