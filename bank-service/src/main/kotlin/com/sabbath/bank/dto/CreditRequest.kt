package com.sabbath.bank.dto

import com.sabbath.bank.jpa.Currency


data class CreditRequest(
        val clientId: String,
        val sum: Int,
        val currency: Currency
)