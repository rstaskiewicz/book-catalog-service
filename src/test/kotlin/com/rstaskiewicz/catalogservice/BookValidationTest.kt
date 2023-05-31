package com.rstaskiewicz.catalogservice

import com.rstaskiewicz.catalogservice.domain.Book
import jakarta.validation.Validation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BookValidationTest {

    private var validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun whenAllFieldsCorrectThenValidationSucceeds() {
        val book = Book("1234567890", "Title", "Author", 9.90)
        val violations = validator.validate(book)
        assertThat(violations).isEmpty()
    }

    @Test
    fun whenIsbnDefinedButIncorrectThenValidationFails() {
        val book = Book("a234567890", "Title", "Author", 9.90)
        val violations = validator.validate(book)
        assertThat(violations).hasSize(1)
        assertThat(violations.iterator().next().message)
            .isEqualTo("The ISBN format must be valid.")
    }
}