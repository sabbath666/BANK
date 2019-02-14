package com.sabbath.client

import com.sabbath.client.jpa.ClientRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ClientServiceApplicationTests {
    @Autowired
    lateinit var clientRepository: ClientRepository

    @Test
    fun contextLoads() {
    }

}
