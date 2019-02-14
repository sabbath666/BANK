package com.sabbath.check

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@EnableConfigurationProperties
class CheckServiceApplication

fun main(args: Array<String>) {
    runApplication<CheckServiceApplication>(*args)
}

@Controller
class SwaggerUIController {
    @RequestMapping(value = ["/"])
    fun index() = "redirect:swagger-ui.html"

}

