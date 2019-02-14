package com.sabbath.client

import com.github.javafaker.Faker
import java.util.*


fun main(args: Array<String>) {

    val faker = Faker.instance(Locale.forLanguageTag("en"))
    val name = faker.lebowski().character()
    val fact = faker.chuckNorris().fact()
    println(name)
}
