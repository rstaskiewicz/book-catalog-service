package com.rstaskiewicz.catalogservice.infrastructure

import com.rstaskiewicz.catalogservice.domain.Book
import com.rstaskiewicz.catalogservice.domain.BookRepository
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class SpringJdbcBookRepository(private val bookDao: BookDao) : BookRepository {

    override fun findAll(): Collection<Book> = bookDao.findAll()

    override fun findByIsbn(isbn: String) = bookDao.findByIsbn(isbn)

    override fun existsByIsbn(isbn: String) = bookDao.existsByIsbn(isbn)

    override fun save(book: Book) = bookDao.save(book)

    override fun deleteByIsbn(isbn: String) = bookDao.deleteByIsbn(isbn)
}

interface BookDao : ListCrudRepository<Book, Long> {

    fun findByIsbn(isbn: String): Book?

    fun existsByIsbn(isbn: String): Boolean

    @Modifying
    @Transactional
    @Query("delete from Book where isbn = :isbn")
    fun deleteByIsbn(isbn: String)
}