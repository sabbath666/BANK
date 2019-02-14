package com.sabbath.credits.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface CreditsRepository : JpaRepository<Credit, Long> {
    fun findAllByStatusIn(vararg statuses: CreditStatus): List<Credit>
}