package com.sabbath.credits.controller

import com.sabbath.credits.dto.CreditRequest
import com.sabbath.credits.jpa.Credit
import com.sabbath.credits.jpa.CreditStatus
import com.sabbath.credits.jpa.CreditsRepository
import org.springframework.web.bind.annotation.*

private val logger = mu.KotlinLogging.logger { }

@RestController
class CreditController(
        val creditsRepository: CreditsRepository
) {

    @PostMapping("/credit")
    fun credit(@RequestBody request: CreditRequest) {
        val credit = Credit(
                clientId = request.clientId,
                sum = request.sum,
                currency = request.currency
        )
        logger.info("получена заявка на кредит: $credit")
        creditsRepository.save(credit)
    }

    @GetMapping("/creditSum/{clientId}")
    fun getCreditInfo(@PathVariable clientId: String) =
            creditsRepository
                    .findAll()
                    .filter { it.clientId == clientId && it.status == CreditStatus.APPROVED }
                    .map { it.sum!! }
                    .sum()

    @GetMapping("/getCredits")
    fun getCredits() = creditsRepository
            .findAll()
}