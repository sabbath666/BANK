package com.sabbath.uiservice.domains

import java.util.*

data class Client(
        val clientId: String?=null,
        val firstname: String,
        val lastname: String,
        val birthdate: Date?=null,
        var sum: Int? = 0
)
