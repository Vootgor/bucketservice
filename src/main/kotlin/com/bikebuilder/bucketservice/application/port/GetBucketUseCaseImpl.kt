package com.bikebuilder.bucketservice.application.port

import com.bikebuilder.bucketservice.adapter.`in`.GetBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.out.GetBucketPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetBucketUseCaseImpl(
    private val getBucketPort: GetBucketPort
): GetBucketUseCase {

    override fun getBucket(ownerId: UUID): BucketResponse {
        val bucket = getBucketPort.findByOwnerId(ownerId)
            ?: throw NoSuchElementException("No bucket found for ownerId=$ownerId")
        return BucketResponse.fromBucket(bucket)
    }
}