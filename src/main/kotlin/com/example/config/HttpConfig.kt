package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient


@Configuration
class HttpConfig {

    @Bean
    fun restClient() : RestClient {
        return RestClient.create()
    }

}