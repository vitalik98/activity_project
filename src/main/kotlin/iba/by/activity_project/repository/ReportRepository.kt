package iba.by.activity_project.repository

import iba.by.activity_project.entity.Report
import org.springframework.data.jpa.repository.JpaRepository

interface ReportRepository : JpaRepository<Report, Long> {
}