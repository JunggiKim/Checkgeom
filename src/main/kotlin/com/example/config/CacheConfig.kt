//package com.example.config
//
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.redis.connection.RedisConnectionFactory
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
//import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
//import org.springframework.data.redis.serializer.StringRedisSerializer
//
//
//@Configuration
//@EnableRedisRepositories
//class RedisConfig (
//    private val redisProperties: RedisProperties
//){
//
//    @Bean
//    fun redisConnectionFactory(): RedisConnectionFactory {
//        return LettuceConnectionFactory(redisProperties.host, redisProperties.port)
//    }
//
//    @Bean
//    fun redisTemplate(): RedisTemplate<String, Any> {
//        val redisTemplate = RedisTemplate<String, Any>()
//        redisTemplate.keySerializer = StringRedisSerializer()
//        redisTemplate.valueSerializer =GenericJackson2JsonRedisSerializer()
//
//        redisTemplate.hashKeySerializer = StringRedisSerializer()
//        redisTemplate.hashValueSerializer = GenericJackson2JsonRedisSerializer()
//
//
//
//        redisTemplate.connectionFactory = redisConnectionFactory()
//
//        return redisTemplate
//    }
//}