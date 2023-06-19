package com.rstaskiewicz.catalogservice

import com.rstaskiewicz.catalogservice.config.PolarProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(PolarProperties::class)
class CatalogServiceApplication

fun main(args: Array<String>) {
	runApplication<CatalogServiceApplication>(*args)
}
