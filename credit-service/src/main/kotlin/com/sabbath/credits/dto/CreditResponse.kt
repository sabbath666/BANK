package com.sabbath.credits.dto

import com.sabbath.credits.jpa.CreditStatus

data class CreditResponse(
        val clientId: String,
        val status: CreditStatus,
        val message: String? = null
)