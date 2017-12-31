package com.iot.webapi.login.Entity

import javax.persistence.*

@Entity
@Table(name = "m_uesr_tbl")
data class DataAccess(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var usr_seq: Int = 0,

        @Column(name = "usr_id", nullable = false)
        var usr_id: String,

        @Column(name = "password", nullable = false)
        var password: String
)



