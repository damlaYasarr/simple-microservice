package com.example.product.services
import com.amazonaws.services.s3.model.ObjectMetadata
import com.example.product.repository.ProductRepository
import com.example.product.model.Product
import com.example.product.s3.S3Service
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class ProductServices(private val productRepository: ProductRepository ){

    @Cacheable("productcache")
    //burada tum paginated result i cache lemis oluyoruz, ancak normalde product by product cache yapmaliyiz.
    //bu serviste oyle bir endpoint olmadigi icin su anlik, Cacheable i gosterme amacli burada kullandik.
    fun getAllProducts(pageNumber: Int, pageSize: Int): Page<Product> {
        val pageRequest = PageRequest.of(pageNumber, pageSize)
        return productRepository.findAll(pageRequest)
    }

    fun saveProduct(product: Product, inputStream: InputStream, metadata: ObjectMetadata): Product {
        // key can be adjusted to have timestamp
        S3Service.uploadImage(product.name, inputStream, metadata)
        val imageUrl = S3Service.getImageUrl(product.name)
        product.photoUri = imageUrl
        return productRepository.save(product)
    }
}