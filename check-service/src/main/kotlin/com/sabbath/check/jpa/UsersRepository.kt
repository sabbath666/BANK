package com.sabbath.users.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<User, Long> {
}