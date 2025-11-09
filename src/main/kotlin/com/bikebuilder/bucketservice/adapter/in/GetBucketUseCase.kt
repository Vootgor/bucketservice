package com.bikebuilder.bucketservice.adapter.`in`

import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import java.util.UUID

interface GetBucketUseCase {
    fun getBucket(ownerId: UUID): BucketResponse
}