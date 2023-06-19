package com.rstaskiewicz.catalogservice

import com.rstaskiewicz.catalogservice.config.DataConfig
import com.rstaskiewicz.catalogservice.domain.Book
import com.rstaskiewicz.catalogservice.domain.BookRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.core.JdbcAggregateTemplate
import org.springframework.test.context.ActiveProfiles

@DataJdbcTest
@Import(DataConfig::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class BookRepositoryJdbcTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var jdbcAggregateTemplate: JdbcAggregateTemplate

    @Test
    fun findBookByIsbnWhenExisting() {
        val bookIsbn = "1234561237"
        val book = Book(bookIsbn, "Title", "Author", 12.90)
        jdbcAggregateTemplate.insert<Any>(book)
        val actualBook = bookRepository.findByIsbn(bookIsbn)
        assertNotNull(actualBook)
        assertEquals(book.isbn, actualBook?.isbn)
    }
}