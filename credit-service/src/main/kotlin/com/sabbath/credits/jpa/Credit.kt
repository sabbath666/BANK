package com.sabbath.credits.jpa

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "credits")
data class Credit(
        val clientId: String?,

        @field: Enumerated(EnumType.STRING)
        val currency: Currency? = Currency.RUB,

        val sum: Int?,

        @field: Enumerated(EnumType.STRING)
        var status: CreditStatus?=CreditStatus.NEW_CREDIT,

        var message:String?=null
        //TODO можно добавить даты...
) : Domain()