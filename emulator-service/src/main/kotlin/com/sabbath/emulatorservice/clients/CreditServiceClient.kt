package com.sabbath.emulatorservice.clients

import com.sabbath.emulatorservice.dto.ClientResponse
import com.sabbath.emulatorservice.dto.CreditRequest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class CreditServiceClient(
        val restTemplate: RestTemplate
) {

    fun addRandomCredit() {
        throw RuntimeException("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB")
        val random = Random()
        val clientId = getRandomClientId()
        restTemplate.postForObject(
                "/credit/credit",
                CreditRequest(
                        clientId,
                        100_000 + random.nextInt(90_000)
                ),
                Any::class.java
        )
    }

    private fun getRandomClientId(): String {
        val clients = restTemplate.exchange(
                "/client/getClients",
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<ClientResponse>>() {}).body!!
        return clients.random().clientId
    }
}