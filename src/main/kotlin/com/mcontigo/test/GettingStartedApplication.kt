package com.mcontigo.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class GettingStartedApplication

fun main(args: Array<String>) {
    runApplication<GettingStartedApplication>(*args)
}
@Bean
fun getRestTemplate(): RestTemplate? {
    return RestTemplate()
}