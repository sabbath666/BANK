package com.sabbath.credits

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
class CreditServiceApplication

fun main(args: Array<String>) {
    runApplication<CreditServiceApplication>(*args)
}

@Controller
class SwaggerUIController {
    @RequestMapping(value = ["/"])
    fun index() = "redirect:swagger-ui.html"

}

