package com.iot.webapi.login.repository

import com.iot.webapi.login.model.DataAccess
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccessRepository : JpaRepository<DataAccess, Long>