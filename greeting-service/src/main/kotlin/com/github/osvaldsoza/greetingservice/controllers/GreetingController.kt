package com.github.osvaldsoza.greetingservice.controllers

import com.github.osvaldsoza.greetingservice.configs.GreetingConfiguration
import com.github.osvaldsoza.greetingservice.models.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    @Autowired
    private lateinit var configuration: GreetingConfiguration

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "") name: String?): Greeting {
        var valueName = name
        if(name!!.isEmpty()) valueName = configuration.defaultValue
        return Greeting(counter.incrementAndGet(), "${configuration.greeting}, $valueName")
    }
}