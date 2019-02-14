package com.sabbath.emulatorservice

import io.sentry.spring.SentryServletContextInitializer
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.boot.web.client.RootUriTemplateHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.web.servlet.HandlerExceptionResolver

@Configuration
class Config(
        val env: Environment
) {

    @Bean
    fun sentryExceptionResolver(): HandlerExceptionResolver = MyResolver()

    @Bean
    fun sentryServletContextInitializer() = SentryServletContextInitializer()

    @Bean
    fun restTemplate() = RestTemplateBuilder()
            .uriTemplateHandler(RootUriTemplateHandler(env["gateway.uri"]))
            .build()
}