package com.sabbath.uiservice.jsf.beans

import com.sabbath.uiservice.client.CreditServiceClient
import com.sabbath.uiservice.domains.Credit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class CreditsBean {
    @Autowired
    lateinit var creditServiceClient: CreditServiceClient

    var credits = mutableListOf<Credit>(

    )

    @PostConstruct
    fun init() {
        update()
    }

    fun update() {
        try {
            credits.clear()
            credits.addAll(creditServiceClient.getAllCredits()!!)
        } catch (e: Exception) {
            println(e)
        }
    }
}