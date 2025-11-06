package com.bikebuilder.bucketservice.adapter.`in`.web.dto

import com.bikebuilder.bucketservice.domain.model.BucketItem
import java.math.BigDecimal
import java.util.UUID

data class BucketItemResponse(
    val productId: UUID,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
) {
    companion object {
        fun from(item: BucketItem): BucketItemResponse =
            BucketItemResponse(
                item.productId,
                item.name,
                item.price,
                item.quantity
            )
    }
}