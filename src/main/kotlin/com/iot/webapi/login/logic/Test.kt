package com.iot.webapi.login.logic

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HalloController{

    @GetMapping("hello")
    fun hello(@RequestParam("name") name: String): String = "Hello,$name!"
}