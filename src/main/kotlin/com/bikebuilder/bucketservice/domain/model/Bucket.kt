package com.bikebuilder.bucketservice.domain.model

import java.time.Instant
import java.util.UUID

data class Bucket(
    val ownerId: UUID,
    val createdAt: Instant,
    var updatedAt: Instant?,
    var items: MutableList<BucketItem>
) {
}