package com.sabbath.bank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@EnableConfigurationProperties
class BankServiceApplication(val env:Environment)

fun main(args: Array<String>) {
    runApplication<BankServiceApplication>(*args)
}

@Controller
class SwaggerUIController {
    @RequestMapping(value = ["/"])
    fun index() = "redirect:swagger-ui.html"

}

