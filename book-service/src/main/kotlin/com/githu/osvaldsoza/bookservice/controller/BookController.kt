package com.githu.osvaldsoza.bookservice.controller

import com.githu.osvaldsoza.bookservice.model.Book
import com.githu.osvaldsoza.bookservice.proxy.CambioProxy
import com.githu.osvaldsoza.bookservice.repository.BookRepository
import com.githu.osvaldsoza.bookservice.response.Cambio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@RestController
@RequestMapping("/book-service")
class BookController {

    @Autowired
    private lateinit var environment: Environment

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var cambioProxy: CambioProxy


    @GetMapping("/{id}/{currency}")
    fun findBook(
        @PathVariable("id") id: Long,
        @PathVariable("currency") currency: String,
    ): Book? {
        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found") }

        val cambio = cambioProxy.getCambio(BigDecimal(book.price.toString()), "USD", currency)

        val port = environment.getProperty("local.server.port")
        book.environment = port
        book.currency = currency
        book.price = cambio!!.convertedValue

        return book
    }

//    @GetMapping("/{id}/{currency}")
//    fun findBook(
//        @PathVariable("id") id: Long,
//        @PathVariable("currency") currency: String,
//    ) : Book?{
//        val book = bookRepository.findById(id).orElseThrow{ RuntimeException("Book not found")}
//
//        val params = HashMap<String,String>()
//        params["amount"] = book.price.toString()
//        params["from"] = "USD"
//        params["to"] = currency
//
//        val respponse = RestTemplate()
//            .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
//                Cambio::class.java,
//                params
//                )
//
//        val cambio = respponse.body
//
//        val port = environment.getProperty("local.server.port")
//        book.environment = port
//        book.currency = currency
//        book.price = cambio!!.convertedValue
//
//        return book
//    }
}