package iba.by.activity_project.resource

import iba.by.activity_project.entity.Report
import iba.by.activity_project.service.ReportService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/reports")
class ReportResource(private val reportService: ReportService) {

    @GetMapping
    fun index() = reportService.getAllReports()

    @GetMapping("/{id}")
    fun getReport(@PathVariable id: Long): ResponseEntity<Optional<Report>> {
        return if (reportService.findReportById(id).isPresent)
            ResponseEntity.ok(reportService.findReportById(id))
        else
            ResponseEntity.notFound().build()
    }

    @PostMapping
    fun post(@RequestBody report: Report) = reportService.post(report)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return if (reportService.findReportById(id).isPresent)
            ResponseEntity.ok(reportService.deleteReport(id))
        else
            ResponseEntity.badRequest().build()
    }
}