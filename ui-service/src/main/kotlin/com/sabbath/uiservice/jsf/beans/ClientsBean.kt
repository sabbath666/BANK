package com.sabbath.uiservice.jsf.beans

import com.sabbath.uiservice.client.UserServiceClient
import com.sabbath.uiservice.domains.Client
import com.sabbath.uiservice.dto.ClientRequest
import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
class ClientsBean {
    @Autowired
    lateinit var userServiceClient: UserServiceClient

    val clients: MutableList<Client> = mutableListOf()
    var newClientFirtsname: String? = null
    var newClientLastname: String? = null
    var newClientBirthDate: Date? = null

    @PostConstruct
    fun init() {
        update()
    }

    fun update() {
        try {
            clients.clear()
            clients.addAll(userServiceClient.getAllClients()!!)
        } catch (e: Exception) {

        }
    }

    fun addClient() {
        userServiceClient.addClient(
                ClientRequest(
                        firstname = newClientFirtsname!!,
                        lastname = newClientLastname!!,
                        birthdate = newClientBirthDate!!
                )
        )
        update()
        val context = RequestContext.getCurrentInstance()
        context.execute("PF('inputDialog').hide();")
    }
}