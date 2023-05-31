package com.rstaskiewicz.catalogservice.domain

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun viewBookList() = bookRepository.findAll()

    fun viewBookDetails(isbn: String) = bookRepository.findByIsbn(isbn) ?: throw BookNotFoundException(isbn)

    fun addBookToCatalog(book: Book): Book {
        if (bookRepository.existsByIsbn(book.isbn)) {
            throw BookAlreadyExistsException(book.isbn)
        }
        return bookRepository.save(book)
    }

    fun removeBookFromCatalog(isbn: String) = bookRepository.deleteByIsbn(isbn)

    fun editBookDetails(isbn: String, book: Book): Book {
        return bookRepository.findByIsbn(isbn)
            ?.let { existingBook ->
                val bookToUpdate = Book(
                    existingBook.isbn,
                    book.title,
                    book.author,
                    book.price
                )
                bookRepository.save(bookToUpdate)
            } ?: addBookToCatalog(book)
    }
}