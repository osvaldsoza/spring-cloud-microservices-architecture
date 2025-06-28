package com.githu.osvaldsoza.bookservice.model

import jakarta.persistence.*
import java.util.*

@Entity(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0,

    @Column(nullable = false, length = 180)
    var author: String = "",

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    var launchDate: Date? = null,

    @Column(nullable = false)
    var price: Double? = null,

    @Column(nullable = false, length = 250)
    var title: String = "",

    @Transient
    var currency: String = "",

    @Transient
    var environment: String? = ""
)
