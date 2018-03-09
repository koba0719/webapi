package com.iot.webapi.login.json

data class LoginResultResponse(
    var Result: Boolean= false,
    var AccessToken: String = ""
)