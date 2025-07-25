package com.github.osvaldsoza.cambioservice.controller

import com.github.osvaldsoza.cambioservice.model.Cambio
import com.github.osvaldsoza.cambioservice.repository.CambioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode

@RestController
@RequestMapping("cambio-service")
class CambioController {

    @Autowired
    private lateinit var environment: Environment

    @Autowired
    private lateinit var repository: CambioRepository

    @GetMapping("/{amount}/{from}/{to}")
    fun getCambio(
        @PathVariable("amount") amount: BigDecimal,
        @PathVariable("from") from: String,
        @PathVariable("to") to: String
    ): Cambio {
        val port = environment.getProperty("local.server.port")
        val cambio = repository.findByFromAndTo(from,to) ?: throw RuntimeException("Currency unsupported")
        val conversionFactory = cambio.conversionFactory
        val convertedValue = conversionFactory.multiply(amount)
        cambio.convertedValue = convertedValue.setScale(2,RoundingMode.CEILING)
        cambio.environment = port

        return cambio
    }
}