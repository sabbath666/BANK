package com.sabbath.client.controller

import com.sabbath.client.config.MetricsConfig
import com.sabbath.client.jpa.Client
import com.sabbath.client.jpa.ClientRepository
import io.micrometer.core.instrument.Counter
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ClientController(
        val clientRepository: ClientRepository,
        val testCounter: Counter,
        val metricsConfig: MetricsConfig,
        val env: Environment
) {
    val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/addClient")
    fun addUser(@RequestBody client: Client): Any? {

//        when (Random.nextInt(1, 3)) {
//            1 -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//            2 -> RuntimeException("не получилось добавить клиента")
//            else -> logger.info("добавление клиента $client")
//        }
        clientRepository.save(client)
        return ResponseEntity.ok("")
    }

    @GetMapping("/getClients")
    fun getUsers(): List<Client> = clientRepository.findAll()

    @GetMapping("/testClient")
    fun test(): String? {
        testCounter.increment()
        return "ok"
    }

    @GetMapping("/test2")
    fun test2() {
        metricsConfig.mySummary().record(Random(100).nextDouble())
    }


}