package com.sabbath.credits.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.boot.web.client.RootUriTemplateHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get

@Configuration
class Config(
        val env:Environment
) {

    @Bean
fun restTemplate() = RestTemplateBuilder()
                .uriTemplateHandler(RootUriTemplateHandler(env["gateway.uri"]))
                .build()
}