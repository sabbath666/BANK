package com.sabbath.uiservice.dto


data class CreditRequest(
        val clientId: String,
        val sum: Int,
        val currency: Currency?= Currency.RUB
)