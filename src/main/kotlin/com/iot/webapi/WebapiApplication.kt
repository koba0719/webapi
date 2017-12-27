package com.iot.webapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebapiApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebapiApplication::class.java, *args)
}
