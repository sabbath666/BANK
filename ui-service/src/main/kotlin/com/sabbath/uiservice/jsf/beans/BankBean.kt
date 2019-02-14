package com.sabbath.uiservice.jsf.beans

import com.sabbath.uiservice.client.BankServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class BankBean {
    @Autowired
    lateinit var bankServiceClient: BankServiceClient

    var balance: Int = 0

    @PostConstruct
    fun init() {
        update()
    }

    fun update() {
        try {
            balance = bankServiceClient.getBalanceSum()!!
        } catch (e: Exception) {
            println(e)
        }
    }
}