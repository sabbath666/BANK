package com.sabbath.uiservice.client

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class BankServiceClient(
        val restTemplate: RestTemplate
) {
    fun getBalanceSum() = restTemplate.getForObject(
            "/bank/getBalanceSum",
            Int::class.java)

}