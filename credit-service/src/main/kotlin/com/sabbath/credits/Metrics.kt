package com.sabbath.credits

import com.sabbath.credits.jpa.CreditStatus
import com.sabbath.credits.jpa.CreditsRepository
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Metrics(
        val registry: MeterRegistry,
        val creditsRepository: CreditsRepository
) {
    @Bean
    fun balanceGauge() = Gauge
            .builder("credits_approved_total")
            { creditsRepository.findAllByStatusIn(CreditStatus.APPROVED).count() }
            .register(registry)
}