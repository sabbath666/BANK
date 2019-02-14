package com.sabbath.bank.jpa

import java.io.Serializable
import javax.persistence.*

@MappedSuperclass
abstract class Domain(
        @field: Id
        @field: GeneratedValue(strategy = GenerationType.AUTO)
        @field: Column(name = "id", nullable = false, updatable = false,insertable = false)
        open var id: Long? = null
):Serializable