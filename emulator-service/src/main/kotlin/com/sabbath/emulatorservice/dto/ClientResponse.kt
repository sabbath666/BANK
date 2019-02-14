package com.sabbath.emulatorservice.dto

import java.util.*

data class ClientResponse(
        val firstname: String?,
        val lastname: String?,
        val birthdate: Date,
        val clientId: String
)