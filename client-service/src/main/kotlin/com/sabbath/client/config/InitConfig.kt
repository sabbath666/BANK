package com.sabbath.client.config

import com.github.javafaker.Faker
import com.sabbath.client.jpa.ClientRepository
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.annotation.PostConstruct

@Configuration
class InitConfig(
        val clientRepository: ClientRepository
) {

    @PostConstruct
    fun initUsers() {
        val faker = Faker.instance(Locale.forLanguageTag("ru"))
        clientRepository.saveAll(listOf(
//                Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday())
//                Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday()),
//                Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday()),
//                Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday()),
//                Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday())
        ))

    }
}