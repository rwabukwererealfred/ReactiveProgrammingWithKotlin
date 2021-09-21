package com.jpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAndJpaApplication

fun main(args: Array<String>) {
	runApplication<KotlinAndJpaApplication>(*args)
}
