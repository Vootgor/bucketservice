package com.bikebuilder.bucketservice.adapter.`in`

import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateCommand

interface CreateBucketUseCase {
    fun createBucket(command: BucketCreateCommand): BucketResponse
}