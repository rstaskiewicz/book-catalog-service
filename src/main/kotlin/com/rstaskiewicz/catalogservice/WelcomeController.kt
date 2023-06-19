package com.rstaskiewicz.catalogservice

import com.rstaskiewicz.catalogservice.config.PolarProperties
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@ConditionalOnProperty("polar.greeting-disabled", matchIfMissing = true)
class WelcomeController(private val polarProperties: PolarProperties) {

    @GetMapping
    fun welcome() = polarProperties.greeting
}