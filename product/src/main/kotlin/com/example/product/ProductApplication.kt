package com.example.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductApplication


// todos: building cli with the mysql, redis cache, s3 aws  
// there is a framework bug . 


fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}