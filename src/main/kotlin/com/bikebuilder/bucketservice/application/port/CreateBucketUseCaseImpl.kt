package com.bikebuilder.bucketservice.application.port

import com.bikebuilder.bucketservice.adapter.`in`.CreateBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateCommand
import com.bikebuilder.bucketservice.application.port.out.SaveBucketPort
import com.bikebuilder.bucketservice.domain.model.Bucket
import org.springframework.stereotype.Service

@Service
class CreateBucketUseCaseImpl(
    private val saveBucketPort: SaveBucketPort
) : CreateBucketUseCase {

    override fun createBucket(command: BucketCreateCommand): BucketResponse {
        val bucket = Bucket.create(command)
        val saved = saveBucketPort.save(bucket)
        return BucketResponse.fromBucket(saved)
    }

}