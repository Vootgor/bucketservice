package com.bikebuilder.bucketservice.application.port

import com.bikebuilder.bucketservice.adapter.`in`.CreateBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateCommand
import com.bikebuilder.bucketservice.application.port.out.SaveBucketPort
import com.bikebuilder.bucketservice.domain.model.Bucket
import com.bikebuilder.bucketservice.domain.model.BucketItem
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CreateBucketUseCaseImpl(
    private val saveBucketPort: SaveBucketPort
) : CreateBucketUseCase {

    override fun createBucket(command: BucketCreateCommand): BucketResponse {
        val bucket = Bucket(
            ownerId = command.ownerId,
            createdAt = Instant.now(),
            updatedAt = null,
            items = mutableListOf(
                BucketItem(
                    productId = command.productId,
                    name = command.name,
                    price = command.price,
                    quantity = command.quantity,
                )
            )
        )
        val saved = saveBucketPort.save(bucket)
        return BucketResponse.from(saved)
    }

}