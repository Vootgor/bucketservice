package com.bikebuilder.bucketservice.application.port.out

import com.bikebuilder.bucketservice.domain.model.Bucket
import java.util.UUID

interface GetBucketPort {
    fun findByOwnerId(ownerId: UUID): Bucket?
}