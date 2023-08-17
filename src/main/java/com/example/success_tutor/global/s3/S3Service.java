package com.example.success_tutor.global.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import jakarta.persistence.AttributeOverride;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Service
public class S3Service {
    
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String uploadFile(BucketDir bucketDir, MultipartFile multipartFile) throws IOException {
        String s3FileName = generateS3FileName(bucketDir, multipartFile.getOriginalFilename());

        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getSize());
        objMeta.setContentType(multipartFile.getContentType());

        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }

    public void deleteFile(String fileUrl) {
        String s3FileName = getS3FileNameFromUrl(fileUrl);
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, s3FileName);
        amazonS3.deleteObject(deleteObjectRequest);
    }

    public String generateS3FileName(BucketDir bucketDir, String originalFilename) {
        return bucketDir.getDirName() + "/" + originalFilename;
    }

    private String getS3FileNameFromUrl(String imageUrl) {
        final String delimiter = ".com/";
        int index = imageUrl.indexOf(delimiter);
//        예외처리
//        if (index == -1) {
//            throw new FileNotFoundException();
//        }

        String bucketAndKey = imageUrl.substring(index + delimiter.length());
        return URLDecoder.decode(bucketAndKey, StandardCharsets.UTF_8);
    }
}
