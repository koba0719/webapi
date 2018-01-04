package com.iot.webapi.login.service

import com.iot.webapi.login.repository.AccessRepository
import com.iot.webapi.login.model.DataAccess
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * DBからのデータ取得と加工を行う.
 */
@Service
open class DataAccessService @Autowired constructor(private val accessRepository: AccessRepository) {

    /**
     * 全ユーザリストの取得
     * @return MutableList<DataAccess>
     */

    fun findAllUser(): MutableList<DataAccess> = accessRepository.findAll()
    fun findById(user_id: String): String{

        return ""
    }
}
