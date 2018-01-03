package com.iot.webapi.login.model

import javax.persistence.*

/**
 * m_user_tblのEntity
 * @param user_seq 主キー
 * @param user_id アカウントID
 * @param sha_pass パスワード
 */

@Entity
@Table(name = "m_user_tbl")
data class DataAccess(
        @Id @GeneratedValue var user_seq: Int? = 0,
        @Column(nullable = false) var user_id: String = "",
        @Column(nullable = false) var sha_pass: String = "") {
}
