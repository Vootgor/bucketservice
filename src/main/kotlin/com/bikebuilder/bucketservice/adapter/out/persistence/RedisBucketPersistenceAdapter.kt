package com.bikebuilder.bucketservice.adapter.out.persistence

import com.bikebuilder.bucketservice.application.port.out.GetBucketPort
import com.bikebuilder.bucketservice.application.port.out.SaveBucketPort
import com.bikebuilder.bucketservice.domain.model.Bucket
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class RedisBucketPersistenceAdapter(
    private val redisTemplate: RedisTemplate<String, Bucket>
) : SaveBucketPort, GetBucketPort {

    override fun save(bucket: Bucket): Bucket {
        redisTemplate.opsForValue().set(bucket.ownerId.toString(), bucket)
        return bucket
    }

    override fun findByOwnerId(ownerId: UUID): Bucket? =
        redisTemplate.opsForValue().get(ownerId.toString())
}