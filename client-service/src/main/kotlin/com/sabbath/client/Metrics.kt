package com.sabbath.client

import com.sabbath.client.jpa.ClientRepository
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Metrics(
        val registry: MeterRegistry,
        val clientRepository: ClientRepository
) {
    @Bean
    fun balanceGauge() = Gauge
            .builder("clients_total")
            { clientRepository.count() }
            .register(registry)
}