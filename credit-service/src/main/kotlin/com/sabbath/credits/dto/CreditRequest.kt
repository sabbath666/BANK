package com.sabbath.credits.dto

import com.sabbath.credits.jpa.Currency

data class CreditRequest(
        val clientId: String,
        val sum: Int,
        val currency: Currency?=Currency.RUB
)