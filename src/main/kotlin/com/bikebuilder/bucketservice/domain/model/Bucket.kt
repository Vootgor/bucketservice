package com.bikebuilder.bucketservice.domain.model

import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateCommand
import java.time.Instant
import java.util.UUID

data class Bucket(
    val ownerId: UUID,
    val createdAt: Instant,
    var updatedAt: Instant?,
    var items: MutableList<BucketItem>
) {

    companion object {
        fun create(command: BucketCreateCommand): Bucket {
            return Bucket(
                ownerId = command.ownerId,
                createdAt = Instant.now(),
                updatedAt = null,
                items = mutableListOf(
                    BucketItem(
                        productId = command.productId,
                        name = command.name,
                        price = command.price,
                        quantity = command.quantity
                    )
                )
            )
        }
    }
}