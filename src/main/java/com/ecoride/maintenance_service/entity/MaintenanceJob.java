package com.ecoride.maintenance_service.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance_jobs")
public class MaintenanceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleCode;

    @Column(nullable = false)
    private String issueType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private String status;

    private LocalDate scheduledDate;
    private LocalDate completedDate;

    private String attachmentUrl;
    private String attachmentName;

    public MaintenanceJob() {
    }

    public MaintenanceJob(Long id, String vehicleCode, String issueType, String description,
                          String priority, String status, LocalDate scheduledDate, LocalDate completedDate) {
        this.id = id;
        this.vehicleCode = vehicleCode;
        this.issueType = issueType;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.scheduledDate = scheduledDate;
        this.completedDate = completedDate;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }
}