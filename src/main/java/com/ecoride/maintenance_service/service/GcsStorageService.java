package com.ecoride.maintenance_service.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class GcsStorageService {

    private final Storage storage;

    @Value("${gcp.bucket.name}")
    private String bucketName;

    public GcsStorageService(Storage storage) {
        this.storage = storage;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename() != null
                ? file.getOriginalFilename()
                : "file";

        String fileName = UUID.randomUUID() + "-" + originalName;

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
                .setContentType(file.getContentType())
                .build();

        storage.create(blobInfo, file.getBytes());

        return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
    }
}