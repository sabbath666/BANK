package com.sabbath.uiservice.domains

import com.sabbath.credits.jpa.CreditStatus
import com.sabbath.credits.jpa.Currency

data class Credit(
        val clientId: String?,
        val currency: Currency? = Currency.RUB,
        val sum: Int?,
        var status: CreditStatus? = CreditStatus.NEW_CREDIT,
        var message: String? = null
        //TODO можно добавить даты...
)