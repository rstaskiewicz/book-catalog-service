package com.rstaskiewicz.catalogservice.config

import com.rstaskiewicz.catalogservice.domain.BookRepository
import com.rstaskiewicz.catalogservice.infrastructure.BookDao
import com.rstaskiewicz.catalogservice.infrastructure.SpringJdbcBookRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing

@Configuration
@EnableJdbcAuditing
class DataConfig {

    @Bean
    fun bookRepository(bookDao: BookDao): BookRepository {
        return SpringJdbcBookRepository(bookDao)
    }
}
