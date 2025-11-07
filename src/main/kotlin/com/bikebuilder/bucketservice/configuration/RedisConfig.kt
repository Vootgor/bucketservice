package com.bikebuilder.bucketservice.configuration

import com.bikebuilder.bucketservice.domain.model.Bucket
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig(
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, Bucket> {
        val template = RedisTemplate<String, Bucket>()
        template.connectionFactory = connectionFactory
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer(objectMapper)
        template.afterPropertiesSet()
        return template
    }
}