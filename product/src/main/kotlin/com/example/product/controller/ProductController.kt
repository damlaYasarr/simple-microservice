package com.example.product.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import com.example.product.model.Product
import com.example.product.services.ProductServices


// build S3 and see how to use this caching. and then delete all resources. 

// use the java spring boot caching system for website and storage the picture .

// tüm prorudcları pagination şekinde döndürürüz. 
@RestController
class ProductController {
    
    @GetMapping("/products")
    fun getProducts(@RequestParam("page") pageNumber: Int, @RequestParam("size") pageSize: Int ): Page<Product> {
        return ProductServices.getAllProducts(pageNumber, pageSize)
    }

  
}

