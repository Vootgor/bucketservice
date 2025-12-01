package com.bikebuilder.bucketservice.adapter.`in`.web

import com.bikebuilder.bucketservice.adapter.`in`.CreateOrUpdateBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.GetBucketUseCase
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketRequest
import com.bikebuilder.bucketservice.adapter.`in`.web.dto.BucketResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/bucket")
class BucketController(
    private val createOrUpdateBucketUseCase: CreateOrUpdateBucketUseCase,
    private val getBucketUseCase: GetBucketUseCase
) {

    @PostMapping("/")
    fun createBucket(
        @RequestHeader("X-Request-ID") id: UUID,
        @RequestBody request: BucketRequest
    ): BucketResponse {
        val command = request.toCommand(id)
        return createOrUpdateBucketUseCase.createBucket(command)
    }

    @GetMapping("/{ownerId}")
    fun getBucket(@PathVariable ownerId: UUID): BucketResponse {
        return getBucketUseCase.getBucket(ownerId)
    }
}

/*
3) addProduct
4) removeProduct
5) createOrder*/
