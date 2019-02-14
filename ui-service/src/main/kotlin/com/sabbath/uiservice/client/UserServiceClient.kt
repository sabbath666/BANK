package com.sabbath.uiservice.client

import com.sabbath.uiservice.domains.Client
import com.sabbath.uiservice.dto.ClientRequest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserServiceClient(
        val restTemplate: RestTemplate
) {
    fun getAllClients(): List<Client> {
        val clients = restTemplate.exchange(
                "/client/getClients",
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<Client>>() {}).body
        clients!!.forEach {
            it.sum = restTemplate.getForObject("/credit/creditSum/${it.clientId}", Int::class.java)
        }
        return clients
    }

    fun addClient(client: ClientRequest) {
        restTemplate.postForObject(
                "/client/addClient",
                client,
                Any::class.java
        )
    }
}