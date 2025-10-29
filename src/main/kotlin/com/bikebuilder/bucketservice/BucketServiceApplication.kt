package com.bikebuilder.bucketservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BucketServiceApplication

fun main(args: Array<String>) {
	runApplication<BucketServiceApplication>(*args)
}
