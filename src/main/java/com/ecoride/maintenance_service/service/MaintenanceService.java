package com.ecoride.maintenance_service.service;

import com.ecoride.maintenance_service.entity.MaintenanceJob;
import com.ecoride.maintenance_service.repository.MaintenanceJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceJobRepository maintenanceJobRepository;

    public MaintenanceService(MaintenanceJobRepository maintenanceJobRepository) {
        this.maintenanceJobRepository = maintenanceJobRepository;
    }

    public MaintenanceJob createJob(MaintenanceJob job) {
        return maintenanceJobRepository.save(job);
    }

    public List<MaintenanceJob> getAllJobs() {
        return maintenanceJobRepository.findAll();
    }

    public MaintenanceJob getJobById(Long id) {
        return maintenanceJobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance job not found: " + id));
    }

    public List<MaintenanceJob> getJobsByVehicleCode(String vehicleCode) {
        return maintenanceJobRepository.findByVehicleCode(vehicleCode);
    }

    public MaintenanceJob updateJob(Long id, MaintenanceJob updatedJob) {
        MaintenanceJob existing = getJobById(id);
        existing.setVehicleCode(updatedJob.getVehicleCode());
        existing.setIssueType(updatedJob.getIssueType());
        existing.setDescription(updatedJob.getDescription());
        existing.setPriority(updatedJob.getPriority());
        existing.setStatus(updatedJob.getStatus());
        existing.setScheduledDate(updatedJob.getScheduledDate());
        existing.setCompletedDate(updatedJob.getCompletedDate());
        return maintenanceJobRepository.save(existing);
    }

    public void deleteJob(Long id) {
        maintenanceJobRepository.deleteById(id);
    }

    public MaintenanceJob uploadAttachment(Long id, String fileUrl, String fileName) {
        MaintenanceJob job = getJobById(id);
        job.setAttachmentUrl(fileUrl);
        job.setAttachmentName(fileName);
        return maintenanceJobRepository.save(job);
    }
}