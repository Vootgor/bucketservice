package com.bikebuilder.bucketservice.adapter.`in`.web.dto

import java.math.BigDecimal
import java.util.UUID


data class BucketCreateRequest(
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
}