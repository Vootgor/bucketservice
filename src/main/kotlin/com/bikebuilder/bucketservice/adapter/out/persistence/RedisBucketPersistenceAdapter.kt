package com.bikebuilder.bucketservice.adapter.out.persistence

import com.bikebuilder.bucketservice.application.port.out.SaveBucketPort
import com.bikebuilder.bucketservice.domain.model.Bucket
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisBucketPersistenceAdapter(
    private val redisTemplate: RedisTemplate<String, Bucket>
) : SaveBucketPort {

    override fun save(bucket: Bucket): Bucket {
        redisTemplate.opsForValue().set(bucket.ownerId.toString(), bucket)
        return bucket
    }
}