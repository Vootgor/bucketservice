package com.bikebuilder.bucketservice.domain.model

import java.math.BigDecimal
import java.util.UUID

data class BucketItem(
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
}