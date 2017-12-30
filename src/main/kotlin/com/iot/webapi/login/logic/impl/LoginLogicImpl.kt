package com.iot.webapi.login.logic.impl

import com.iot.webapi.login.logic.LoginLogic

class LoginLogicImpl: LoginLogic{
    override fun login(pass: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val hash: String = sha256(pass)
//        val ldi = LoginLogic
    }

    override fun sha256(pass: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}