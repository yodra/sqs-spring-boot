package com.example.sqsspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class SqsSpringBootApplication

fun main(args: Array<String>) {
    runApplication<SqsSpringBootApplication>(*args)
}
