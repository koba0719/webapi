package com.iot.webapi.login.logic

interface LoginLogic {
    fun login(pass: String): Boolean
    fun sha256(pass: String): String
}