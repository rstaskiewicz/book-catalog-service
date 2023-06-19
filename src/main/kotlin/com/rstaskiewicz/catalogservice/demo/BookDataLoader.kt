package com.rstaskiewicz.catalogservice.demo

import com.rstaskiewicz.catalogservice.domain.Book
import com.rstaskiewicz.catalogservice.infrastructure.BookDao
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


@Component
@Profile("testdata")
class BookDataLoader(private val bookDao: BookDao) {

    @EventListener(ApplicationReadyEvent::class)
    fun loadBookTestData() {
        if (bookDao.count() > 0) {
            return
        }
        val book1 = Book(
            "1234567891", "Northern Lights",
            "Lyra Silverstar", 9.90
        )
        val book2 = Book(
            "1234567892", "Polar Journey",
            "Iorek Polarson", 12.90
        )
        bookDao.saveAll(listOf(book1, book2))
    }
}