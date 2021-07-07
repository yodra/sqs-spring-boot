package com.example.sqsspringboot

import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SQSController(private val queueMessagingTemplate: QueueMessagingTemplate) {

    @GetMapping("/")
    fun getReport(): String? {
        val queueName = "default"
        return queueMessagingTemplate
            .receiveAndConvert(queueName, String::class.java)
    }

    @SqsListener("default")
    fun getMessage(message: String) {
        log.info("Message from SQS Queue - $message")
    }

    companion object {
        private val log = LoggerFactory.getLogger(SQSController::class.java)
    }
}
