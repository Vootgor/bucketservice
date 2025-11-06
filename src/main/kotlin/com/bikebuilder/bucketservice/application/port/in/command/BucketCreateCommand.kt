package com.bikebuilder.bucketservice.application.port.`in`.command

import java.math.BigDecimal
import java.util.UUID

data class BucketCreateCommand(
    val ownerId: UUID,
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
}