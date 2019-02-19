package com.sabbath.uiservice.jsf.beans

import com.sabbath.uiservice.client.CreditServiceClient
import com.sabbath.uiservice.domains.Credit
import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class CreditsBean {
    @Autowired
    lateinit var creditServiceClient: CreditServiceClient

    var newCreditSum: Int = 0
    var newCreditClientId: String = ""

    var credits = mutableListOf<Credit>(

    )

    @PostConstruct
    fun init() {
//        update()
    }

    fun update() {
        try {
            credits.clear()
            credits.addAll(creditServiceClient.getAllCredits()!!)
        } catch (e: Exception) {
            println(e)
        }
    }

    fun addCredit() {
        if (newCreditClientId.isBlank() || newCreditSum == 0) return
        creditServiceClient.addCredit(newCreditClientId, newCreditSum)
        update()
        val context = RequestContext.getCurrentInstance()
        context.execute("PF('inputDialog').hide();")
    }
}