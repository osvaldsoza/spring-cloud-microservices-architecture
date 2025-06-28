package com.github.osvaldsoza.cambioservice.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "cambio")
data class Cambio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "from_currency", nullable = false, length = 3)
    var from: String = "",

    @Column(name = "to_currency", nullable = false, length = 3)
    var to: String = "",

    @Column(name = "conversion_factor", nullable = false)
    var conversionFactory: BigDecimal = BigDecimal.ZERO,

    @Transient
    var convertedValue: BigDecimal = BigDecimal.ZERO,

    @Transient
    var environment: String? = ""
)