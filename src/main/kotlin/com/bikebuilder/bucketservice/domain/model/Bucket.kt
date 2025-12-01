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
        items.find { item -> item.productId == command.productId }
            ?.also {
                val updated = it.copy(quantity = it.quantity + command.quantity)
                items[items.indexOf(it)] = updated
            }
            ?: items.add(BucketItem.parseItemData(command))
        updatedAt = Instant.now()
    }
}