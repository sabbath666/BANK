package com.sabbath.users.jpa

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
        val username: String?
) : Domain()