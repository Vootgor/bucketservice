package com.bikebuilder.bucketservice

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<BucketServiceApplication>().with(TestcontainersConfiguration::class).run(*args)
}
