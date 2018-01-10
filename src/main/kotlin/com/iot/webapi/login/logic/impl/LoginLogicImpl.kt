package com.iot.webapi.login.logic.impl

import com.iot.webapi.login.logic.LoginLogic
import com.iot.webapi.login.model.DataAccess
import java.security.MessageDigest

class LoginLogicImpl: LoginLogic{
    override fun login(searchString: String, userList: MutableList<DataAccess>): Boolean {
        for (search in userList){
            if (search.user_id == searchString) {
                return true
            }
        }
        return false
    }

    override fun sha256(pass: String): String {
        val bytes: ByteArray = pass.toByteArray()
        val md: MessageDigest = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        var result: String = String()
        for (byte in digest){
            result += "%02x".format(byte)
        }
        return result
    }
}