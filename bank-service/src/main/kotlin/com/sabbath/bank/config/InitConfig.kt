package com.sabbath.bank.config

import com.sabbath.bank.jpa.Account
import com.sabbath.bank.jpa.AccountsRepository
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import java.util.*
import javax.annotation.PostConstruct

@Configuration
class InitConfig(
        val accountsRepository: AccountsRepository,
        val env: Environment
) {

    @PostConstruct
    fun initAccounts() {
        val random = Random()
        accountsRepository.save(
                Account(
                        account = "6666666666666",
                        balance = (1 + random.nextInt(10)) * 1_000_000
                ))
    }
}