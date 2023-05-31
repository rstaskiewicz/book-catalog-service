package com.rstaskiewicz.catalogservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class WelcomeController {

    @GetMapping
    fun welcome() = "Welcome to the book catalog!"
}