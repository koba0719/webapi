package com.iot.webapi.login.logic

import com.iot.webapi.login.model.DataAccess

interface LoginLogic {
    fun login(searchString: String, userList: MutableList<DataAccess>): Boolean
    fun sha256(pass: String): String
}