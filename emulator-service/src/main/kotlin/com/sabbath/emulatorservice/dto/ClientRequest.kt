package com.sabbath.emulatorservice.dto

import java.util.*

data class ClientRequest(
        val firstname: String?,
        val lastname: String?,
        val birthdate: Date
)