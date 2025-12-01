package com.bikebuilder.bucketservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.integration.redis.util.RedisLockRegistry

@Configuration
class RedisLockConfig(
    private val redisConnectionFactory: RedisConnectionFactory
) {
    @Bean
    fun redisLockRegistry(): RedisLockRegistry =
        RedisLockRegistry(redisConnectionFactory, "bucket-locks", 10_000)
}