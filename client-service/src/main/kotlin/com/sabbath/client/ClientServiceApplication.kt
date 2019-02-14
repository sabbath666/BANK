package com.sabbath.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
class ClientServiceApplication

fun main(args: Array<String>) {
    runApplication<ClientServiceApplication>(*args)
}

@Controller
class SwaggerUIController {
    @RequestMapping(value = ["/"])
    fun index() = "redirect:swagger-ui.html"

}

