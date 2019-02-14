package com.sabbath.uiservice.client

import com.sabbath.uiservice.domains.Credit
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CreditServiceClient(
        val restTemplate: RestTemplate
) {
    fun getAllCredits() =
            restTemplate.exchange(
                    "/credit/getCredits",
                    HttpMethod.GET,
                    null,
                    object : ParameterizedTypeReference<List<Credit>>() {}).body
}