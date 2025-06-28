package com.githu.osvaldsoza.bookservice.response


data class Cambio(

    var id: Long = 0,
    var from: String = "",
    var to: String = "",
    var conversionFactory: Double,
    var convertedValue: Double,
    var environment: String? = ""
)