package iba.by.activity_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
open class ActivityProjectApplication

fun main(args: Array<String>) {
	runApplication<ActivityProjectApplication>(*args)
}
