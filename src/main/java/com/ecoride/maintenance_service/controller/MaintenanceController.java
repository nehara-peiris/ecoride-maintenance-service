package com.ecoride.maintenance_service.controller;

import com.ecoride.maintenance_service.entity.MaintenanceJob;
import com.ecoride.maintenance_service.service.GcsStorageService;
import com.ecoride.maintenance_service.service.MaintenanceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;
    private final GcsStorageService gcsStorageService;

    public MaintenanceController(MaintenanceService maintenanceService,
                                 GcsStorageService gcsStorageService) {
        this.maintenanceService = maintenanceService;
        this.gcsStorageService = gcsStorageService;
    }

    @PostMapping
    public MaintenanceJob createJob(@RequestBody MaintenanceJob job) {
        return maintenanceService.createJob(job);
    }

    @GetMapping
    public List<MaintenanceJob> getAllJobs() {
        return maintenanceService.getAllJobs();
    }

    @GetMapping("/{id}")
    public MaintenanceJob getJobById(@PathVariable Long id) {
        return maintenanceService.getJobById(id);
    }

    @GetMapping("/vehicle/{vehicleCode}")
    public List<MaintenanceJob> getJobsByVehicleCode(@PathVariable String vehicleCode) {
        return maintenanceService.getJobsByVehicleCode(vehicleCode);
    }

    @PutMapping("/{id}")
    public MaintenanceJob updateJob(@PathVariable Long id, @RequestBody MaintenanceJob job) {
        return maintenanceService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        maintenanceService.deleteJob(id);
        return "Maintenance job deleted successfully";
    }

    @PostMapping(value = "/{id}/attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MaintenanceJob uploadAttachment(@PathVariable Long id,
                                           @RequestParam("file") MultipartFile file) throws Exception {
        String fileUrl = gcsStorageService.uploadFile(file);
        return maintenanceService.uploadAttachment(id, fileUrl, file.getOriginalFilename());
    }
}