package com.example.success_tutor.global.s3;

import lombok.Getter;

@Getter
public enum BucketDir {

    Image("image");

    private String dirName;

    BucketDir(String dirName){
        this.dirName = dirName;
    }
}
