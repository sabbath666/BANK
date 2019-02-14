package com.sabbath.bank.controller

import com.sabbath.bank.client.CheckServiceClient
import com.sabbath.bank.dto.CreditRequest
import com.sabbath.bank.dto.CreditResponse
import com.sabbath.bank.jpa.AccountsRepository
import com.sabbath.bank.jpa.CreditStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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

    private fun checkClient(clientId: String) {
        checkServiceClient.checkClient(clientId)
    }

    private fun checkMoney(sum: Int) {
        if (accountsRepository.findAll()[0].balance < sum) throw RuntimeException("в банке кончились деньги!!")
    }

}