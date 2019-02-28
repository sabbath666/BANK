package com.sabbath.emulatorservice

import io.sentry.spring.SentryExceptionResolver
import org.springframework.context.annotation.Configuration


@Configuration
class SentryConfig {


}

class MyResolver : SentryExceptionResolver() {
    override fun getOrder(): Int {
        return Int.MIN_VALUE
    }
}