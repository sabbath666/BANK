package com.sabbath.client.jpa

import java.util.*
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = "clients")
data class Client(
        val firstname: String?,

        val lastname: String?,

        @field: Temporal(TemporalType.DATE)
        val birthdate: Date,

        val clientId: String? = UUID.randomUUID().toString()
) : Domain()