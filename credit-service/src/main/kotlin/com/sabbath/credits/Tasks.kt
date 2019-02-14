package com.sabbath.credits

import com.sabbath.credits.dto.CreditRequest
import com.sabbath.credits.dto.CreditResponse
import com.sabbath.credits.jpa.CreditStatus
import com.sabbath.credits.jpa.CreditsRepository
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.client.RestTemplate

@Configuration
class Tasks(
        val restTemplate: RestTemplate,
        val creditsRepository: CreditsRepository
) {

    @Scheduled(fixedDelay = 1000)
    fun sendCreditToBank() {
        creditsRepository.findAllByStatusIn(CreditStatus.NEW_CREDIT).forEach {
            val creditResponse = restTemplate.postForObject(
                    "/bank/giveCredit",
                    CreditRequest(clientId = it.clientId!!, sum = it.sum!!),
                    CreditResponse::class.java
            )
            it.status = creditResponse!!.status
            it.message = creditResponse.message
            creditsRepository.save(it)
        }

    }
}