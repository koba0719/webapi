package com.iot.webapi.login.json

data class LoginResultRequest(
        var loginId: String = "",
        var password: String = "",
        var accessToken: String = ""
)