package com.sabbath.emulatorservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class EmulatorServiceApplication

fun main(args: Array<String>) {
    runApplication<EmulatorServiceApplication>(*args)
}

