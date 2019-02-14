package com.sabbath.emulatorservice.clients

import com.github.javafaker.Faker
import com.sabbath.emulatorservice.dto.ClientRequest
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class ClientServiceClient(
        val restTemplate: RestTemplate
) {
    fun addRandomClient() {
        val faker = Faker.instance(Locale.forLanguageTag("ru"))
        restTemplate.postForObject(
                "/client/addClient",
                ClientRequest(
                        firstname = faker.name().firstName(),
                        lastname = faker.name().lastName(),
                        birthdate = faker.date().birthday()),
                Any::class.java
        )
    }
}