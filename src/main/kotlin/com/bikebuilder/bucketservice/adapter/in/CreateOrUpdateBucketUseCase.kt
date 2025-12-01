package com.bikebuilder.bucketservice.adapter.`in`

import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateOrUpdateCommand

interface CreateOrUpdateBucketUseCase {
    fun createBucket(command: BucketCreateOrUpdateCommand): BucketResponse
}