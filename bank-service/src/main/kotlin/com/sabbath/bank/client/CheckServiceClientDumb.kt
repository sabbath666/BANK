package com.sabbath.bank.client

import com.sabbath.bank.jpa.CheckStatus
import org.springframework.stereotype.Service

@Service
class CheckServiceClientDumb : CheckServiceClient {
    override fun checkClient(clientId: String)=CheckStatus.ALLOW
}