package com.bikebuilder.bucketservice.domain.model

import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateOrUpdateCommand
import java.time.Instant
import java.util.UUID

data class Bucket(
    val ownerId: UUID,
    val createdAt: Instant,
    var updatedAt: Instant?,
    var items: MutableList<BucketItem>
) {

    companion object {
        fun create(command: BucketCreateOrUpdateCommand): Bucket {
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

    fun update(command: BucketCreateOrUpdateCommand) {
        val existing = items.find { items -> items.productId == command.productId }
        if (existing != null) {
            val updated = existing.copy(quantity = existing.quantity + command.quantity)
            items[items.indexOf(existing)] = updated
        }else{
            items.add(BucketItem.parseItemData(command))
        }
        updatedAt = Instant.now()
    }
}