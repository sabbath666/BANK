package com.sabbath.bank.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface AccountsRepository : JpaRepository<Account, Long> {
}