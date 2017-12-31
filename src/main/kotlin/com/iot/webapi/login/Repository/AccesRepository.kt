package com.iot.webapi.login.Repository

import com.iot.webapi.login.Entity.DataAccess
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccessRepository : JpaRepository<DataAccess,Int>{
}