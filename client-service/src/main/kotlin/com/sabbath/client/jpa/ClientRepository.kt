package com.sabbath.client.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long> {
}