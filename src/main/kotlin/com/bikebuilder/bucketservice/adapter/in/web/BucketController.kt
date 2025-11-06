package com.bikebuilder.bucketservice.adapter.`in`.web

import com.bikebuilder.bucketservice.adapter.`in`.CreateBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketCreateRequest
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import com.bikebuilder.bucketservice.application.port.`in`.command.BucketCreateCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/bucket")
class BucketController(
    private val createBucketUseCase: CreateBucketUseCase
) {

    @PostMapping("/")
    fun createBucket(
        @RequestHeader("X-Request-ID") id: UUID,
        @RequestBody request: BucketCreateRequest
    ): BucketResponse {

        val command = BucketCreateCommand(
            ownerId = id,
            productId = request.productId,
            name = request.name,
            price = request.price,
            quantity = request.quantity
        )
        return createBucketUseCase.createBucket(command)
    }
}

/*
1) createBucket
2) getBucket
3) addProduct
4) removeProduct
5) createOrder*/
