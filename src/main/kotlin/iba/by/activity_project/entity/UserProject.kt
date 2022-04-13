package iba.by.activity_project.entity

import javax.persistence.*

@Entity
@Table(name = "user_project")
class UserProject(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @ManyToOne
    val user: User?,

    @ManyToOne
    val project: Project?
) {
    constructor() : this(null, null, null) {

    }

}