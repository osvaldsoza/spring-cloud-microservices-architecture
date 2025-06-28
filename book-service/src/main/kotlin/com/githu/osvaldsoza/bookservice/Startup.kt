package com.githu.osvaldsoza.bookservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class Startup

fun main(args: Array<String>) {
    runApplication<Startup>(*args)
}
