package com.githu.osvaldsoza.bookservice.repository

import com.githu.osvaldsoza.bookservice.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book,Long?> {
}

