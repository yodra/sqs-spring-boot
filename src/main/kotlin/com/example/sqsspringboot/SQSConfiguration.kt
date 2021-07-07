package com.example.sqsspringboot

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.AnonymousAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SQSConfiguration {
    @Bean
    fun queueMessagingTemplate(): QueueMessagingTemplate? {
        return QueueMessagingTemplate(amazonSQSAsync())
    }

    fun amazonSQSAsync(): AmazonSQSAsync? {
        return AmazonSQSAsyncClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(AnonymousAWSCredentials()))
            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration("http://localhost:9324", null))
            .build()
    }
}
