package com.bikebuilder.bucketservice.domain.model

import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateOrUpdateCommand
import java.math.BigDecimal
import java.util.UUID

data class BucketItem(
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
    companion object {
        fun parseItemData (command: BucketCreateOrUpdateCommand):BucketItem{
            return BucketItem(
                productId = command.productId,
                name = command.name,
                price = command.price,
                quantity = command.quantity
            )
        }
    }
}