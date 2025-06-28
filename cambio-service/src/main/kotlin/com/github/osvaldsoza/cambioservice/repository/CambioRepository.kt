package com.github.osvaldsoza.cambioservice.repository

import com.github.osvaldsoza.cambioservice.model.Cambio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CambioRepository : JpaRepository<Cambio, Long?> {

    fun findByFromAndTo(from: String, to: String): Cambio?;
}