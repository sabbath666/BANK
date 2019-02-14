package com.sabbath.uiservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UiServiceApplication

fun main(args: Array<String>) {
    runApplication<UiServiceApplication>(*args)
}

