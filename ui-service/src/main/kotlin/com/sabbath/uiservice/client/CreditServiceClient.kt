package com.sabbath.uiservice.client

import com.sabbath.uiservice.domains.Credit
import com.sabbath.uiservice.dto.CreditRequest
import com.sabbath.uiservice.dto.Currency
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

    fun addCredit(clientId:String,sum:Int){
        restTemplate.postForObject(
                "/credit/credit",
                CreditRequest(
                        clientId,
                        sum,
                        Currency.RUB
                ),
                Any::class.java
        )
    }

}