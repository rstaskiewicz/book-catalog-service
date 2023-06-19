package com.rstaskiewicz.catalogservice.config

import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.validation.annotation.Validated

@Validated
@RefreshScope
@ConfigurationProperties("polar")
data class PolarProperties (

    @field:NotBlank
    var greeting: String = "Welcome!",
)
