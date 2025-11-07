package com.bikebuilder.bucketservice.application.port.out

import com.bikebuilder.bucketservice.domain.model.Bucket

interface SaveBucketPort {
    fun save(bucket: Bucket): Bucket
}