package com.sabbath.bank.controller

import com.sabbath.bank.client.CheckServiceClient
import com.sabbath.bank.dto.CreditRequest
import com.sabbath.bank.dto.CreditResponse
import com.sabbath.bank.jpa.AccountsRepository
import com.sabbath.bank.jpa.CreditStatus
import org.springframework.web.bind.annotation.*

private val logger = mu.KotlinLogging.logger { }

@RestController
class BankController(
        val checkServiceClient: CheckServiceClient,
        val accountsRepository: AccountsRepository
) {

    @PostMapping("/giveCredit")
    fun giveCredit(@RequestBody creditRequest: CreditRequest): CreditResponse {
        try {
            checkClient(creditRequest.clientId)
            checkMoney(creditRequest.sum)
            reduceBalance(creditRequest.sum)
            logger.info ("выдан кредит для клиента ${creditRequest.clientId} на сумму ${creditRequest.sum}")
            return CreditResponse(
                    clientId = creditRequest.clientId,
                    status = CreditStatus.APPROVED
            )
        } catch (e: Exception) {
            return CreditResponse(
                    clientId = creditRequest.clientId,
                    status = CreditStatus.DECLINED,
                    message = e.message
            )
        }
    }

    private fun reduceBalance(sum: Int) {
        accountsRepository.findAll()[0].apply {
            balance = balance.minus(sum)
            accountsRepository.save(this)
        }
    }

    @GetMapping("/getBalanceSum")
    fun getBalanceSum() = accountsRepository.findAll()[0].balance

    @PostMapping("/addBalanceSum")
    fun addBalanceSum(@RequestParam sum: Int){
        val account = accountsRepository.findAll()[0]
        account.balance+=sum
        accountsRepository.save(account)
    }


    private fun checkClient(clientId: String) {
        checkServiceClient.checkClient(clientId)
    }

    private fun checkMoney(sum: Int) {
        if (accountsRepository.findAll()[0].balance < sum) throw RuntimeException("в банке кончились деньги!!")
    }

}