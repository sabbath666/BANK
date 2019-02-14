package com.sabbath.bank.client

import com.sabbath.bank.jpa.CheckStatus

interface CheckServiceClient {
    fun checkClient(clientId:String):CheckStatus
}