package com.github.osvaldsoza.greetingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Startup

fun main(args: Array<String>) {
    runApplication<Startup>(*args)
}
