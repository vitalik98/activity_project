package iba.by.activity_project.service

import iba.by.activity_project.entity.Report
import iba.by.activity_project.repository.ReportRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReportService(private val reportRepository: ReportRepository) {

    fun getAllReports(): List<Report> = reportRepository.findAll()

    fun post(report: Report) = reportRepository.save(report)

    fun deleteReport(id: Long) = reportRepository.deleteById(id)

    fun findReportById(id: Long): Optional<Report> = reportRepository.findById(id)


}