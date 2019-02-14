package com.sabbath.client.config

import com.sabbath.client.jpa.ClientRepository
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.security.SecureRandom


@Configuration
class MetricsConfig(
        val registry: MeterRegistry,
        val clientRepository: ClientRepository
) {

    @Bean
    fun metricsCommonTags(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry -> registry.config().commonTags("application", "users-service") }
    }

    @Bean
    fun random() = SecureRandom()

    @Bean
    fun randomGauge() = Gauge
            .builder("myGauge", random())
            { it.nextInt(100).toDouble() }
            .register(registry)

    @Bean
    fun testCounter() = Counter
            .builder("myCounter")
            .description("my test counter")
            .register(registry)

    @Bean
    fun mySummary() = registry.summary("mySummary")
//
//    @Bean
//    fun meterFilter = MeterFilter
}