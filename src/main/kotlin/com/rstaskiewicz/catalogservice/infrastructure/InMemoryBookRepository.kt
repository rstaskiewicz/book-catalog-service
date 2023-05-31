package com.rstaskiewicz.catalogservice.infrastructure

import com.rstaskiewicz.catalogservice.domain.Book
import com.rstaskiewicz.catalogservice.domain.BookRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class InMemoryBookRepository : BookRepository {

    companion object {
        private val books: MutableMap<String, Book> = ConcurrentHashMap<String, Book>()
    }

    override fun findAll(): Collection<Book> = books.values

    override fun findByIsbn(isbn: String) = books[isbn]

    override fun existsByIsbn(isbn: String) = books.containsKey(isbn)

    override fun save(book: Book): Book {
        books[book.isbn] = book
        return book
    }

    override fun deleteByIsbn(isbn: String) {
        books.remove(isbn)
    }
}