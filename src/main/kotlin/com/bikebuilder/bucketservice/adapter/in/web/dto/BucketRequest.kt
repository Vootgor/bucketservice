package com.bikebuilder.bucketservice.adapter.`in`.web.dto

import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateOrUpdateCommand
import java.math.BigDecimal
import java.util.UUID


data class BucketRequest(
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
    fun toCommand(ownerId: UUID): BucketCreateOrUpdateCommand {
        return BucketCreateOrUpdateCommand(
            ownerId = ownerId,
            productId = productId,
            name = name,
            price = price,
            quantity = quantity
        )
    }
}