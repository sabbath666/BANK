package com.sabbath.emulatorservice.tasks

import com.sabbath.emulatorservice.clients.ClientServiceClient
import com.sabbath.emulatorservice.clients.CreditServiceClient
import io.sentry.Sentry
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import javax.annotation.PostConstruct

@Configuration
class Tasks(
        val clientServiceClient: ClientServiceClient,
        val creditServiceClient: CreditServiceClient
) {
    @PostConstruct
    fun init(){
        Sentry.init("http://4aab3cb2ac70479ba33eeb4f4fdba1b8@localhost:9010/2")
    }

    @Scheduled(fixedDelay = 1000)
    fun addClient() {
        println("===> add random client")
        try {
            clientServiceClient.addRandomClient()
        } catch (ex: Exception) {
            Sentry.capture(ex)
            throw ex
        }
    }

    @Scheduled(fixedDelay = 1000)
    fun addCredit() {
        println("===> add random credit")
        creditServiceClient.addRandomCredit()
    }
}