package com.bikebuilder.bucketservice.adapter.`in`.web.dto

import com.bikebuilder.bucketservice.domain.model.Bucket
import java.time.Instant
import java.util.UUID

data class BucketResponse(
    val ownerId: UUID,
    val createdAt: Instant,
    val updatedAt: Instant?,
    val items: List<BucketItemResponse>
) {
    companion object {
        fun from(bucket: Bucket): BucketResponse =
            BucketResponse(
                bucket.ownerId,
                bucket.createdAt,
                bucket.updatedAt,
                items = bucket.items.map(BucketItemResponse::from)
            )
    }
}