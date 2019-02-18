package com.sabbath.uiservice.jsf.beans

import com.github.javafaker.Faker
import javax.annotation.ManagedBean
import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped

@ManagedBean
@ApplicationScoped
class SessionBean {

    var fact: String = ""

    @PostConstruct
    fun init() {
        update()
    }

    fun update() {
        val faker = Faker()
        fact = faker.chuckNorris().fact()
    }
}