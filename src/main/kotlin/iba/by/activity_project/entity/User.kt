package iba.by.activity_project.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String
    ) {
    constructor() : this(null,"")

}