package com.sabbath.bank

import com.sabbath.bank.jpa.AccountsRepository
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Metrics(
        val registry: MeterRegistry,
        val accountsRepository: AccountsRepository
) {
    @Bean
    fun balanceGauge() = Gauge
            .builder("balance")
            { accountsRepository.findAll()[0].balance }
            .register(registry)
}