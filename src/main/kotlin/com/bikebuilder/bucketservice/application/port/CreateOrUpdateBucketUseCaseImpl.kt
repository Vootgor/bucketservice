package com.bikebuilder.bucketservice.application.port

import com.bikebuilder.bucketservice.adapter.`in`.CreateOrUpdateBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateOrUpdateCommand
import com.bikebuilder.bucketservice.application.port.out.GetBucketPort
import com.bikebuilder.bucketservice.application.port.out.SaveBucketPort
import com.bikebuilder.bucketservice.domain.model.Bucket
import org.springframework.stereotype.Service

@Service
class CreateOrUpdateBucketUseCaseImpl(
    private val saveBucketPort: SaveBucketPort,
    private val getBucket: GetBucketPort
) : CreateOrUpdateBucketUseCase {

    override fun createBucket(command: BucketCreateOrUpdateCommand): BucketResponse {

        val bucketExist = getBucket.findByOwnerId(command.ownerId)
        val savedBucket: Bucket

        if(bucketExist!=null) {
            bucketExist.update(command)
            savedBucket = saveBucketPort.save(bucketExist)
            return BucketResponse.fromBucket(savedBucket)
        }

        val bucket = Bucket.create(command)
        savedBucket = saveBucketPort.save(bucket)
        return BucketResponse.fromBucket(savedBucket);
    }

}