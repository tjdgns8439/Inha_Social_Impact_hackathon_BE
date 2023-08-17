package com.example.success_tutor.global.s3;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/S3")
@RequiredArgsConstructor
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        BucketDir bucketDir = BucketDir.Image;
        return s3Service.uploadFile(bucketDir, file);
    }
}
