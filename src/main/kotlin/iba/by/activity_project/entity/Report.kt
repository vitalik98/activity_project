package iba.by.activity_project.entity

import java.time.Month
import java.time.Year
import javax.persistence.*

@Entity
@Table(name="reports")
class Report(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?,

    @ManyToOne
    val user:User?,

    @ManyToOne
    val project:Project?,

    val month: Month?,

    val year: Year?,

    val activities: String?,

    val hours: Int?,

    val days_absent: Int?
) {
    constructor() : this(null,null,null,null,null,null,null,null) {

    }

}