package com.bikebuilder.bucketservice.configuration

import com.bikebuilder.bucketservice.domain.model.Bucket
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer
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

        val mapper = objectMapper.copy().apply {
            registerModule(JavaTimeModule())
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        }

        val genericSerializer = GenericJackson2JsonRedisSerializer(mapper)

        template.valueSerializer = object : RedisSerializer<Bucket> {
            override fun serialize(t: Bucket?): ByteArray? = genericSerializer.serialize(t)
            override fun deserialize(bytes: ByteArray?): Bucket? =
                genericSerializer.deserialize(bytes, Bucket::class.java)
        }

        template.afterPropertiesSet()
        return template
    }
}