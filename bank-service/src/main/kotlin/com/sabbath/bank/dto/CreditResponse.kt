package com.sabbath.bank.dto

import com.sabbath.bank.jpa.CreditStatus

data class CreditResponse(
        val clientId: String,
        val status: CreditStatus,
        val message: String? = ""
)