package com.sabbath.emulatorservice.dto


data class CreditRequest(
        val clientId: String,
        val sum: Int,
        val currency: Currency?=Currency.RUB
)