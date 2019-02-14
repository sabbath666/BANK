package com.sabbath.bank.jpa

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class Account(
        val account: String? = "666666666666666666",
        var balance: Int = 0
) : Domain()