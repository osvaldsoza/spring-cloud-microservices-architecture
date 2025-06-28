package com.github.osvaldsoza.configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class Startup

fun main(args: Array<String>) {
    runApplication<Startup>(*args)
}
