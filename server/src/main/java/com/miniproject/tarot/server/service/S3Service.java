package com.miniproject.tarot.server.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class S3Service {
    
    @Autowired
    private AmazonS3 s3client;

    public void get(String imgName) {
        String imageUrlToCheck = "https://tarot.sgp1.digitaloceanspaces.com/";

        try {
            GetObjectRequest gor = new GetObjectRequest("tarot", "%s".formatted(imgName));
            S3Object s3Object = s3client.getObject(gor);
            ObjectMetadata metadata = s3Object.getObjectMetadata();
            Map<String, String> userData = metadata.getUserMetadata();
            System.out.println(userData.get("title"));

            // if (userData.size() == 0) return Optional.empty();

            // String title = userData.get("title");
            // return Optional.of(imageUrlToCheck + title);
        } catch (Exception e) {
            // return Optional.empty();
        }
    }
}
