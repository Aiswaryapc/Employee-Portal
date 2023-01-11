package com.axis.finalproject.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.entity.Product;

import com.axis.finalproject.exceptions.ProductNotExistsException;
import com.axis.finalproject.product.dto.ProductDto;

import com.axis.finalproject.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	
	
    public List<Product> listProducts() {
        
        List<Product> products = productRepository.findAll();    
        return products;
    }
    public Product getProduct(Integer id) {
    	return productRepository.getById(id);
    }
    
    public Product findById(Integer productId) throws ProductNotExistsException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("product id is invalid: " + productId);
        }
        return optionalProduct.get();
    }
	public void addproduct(ProductDto productDto) {
		Product product = new Product(
				productDto.getCategory(),
				productDto.getName(),
				productDto.getImageUrl(),
				productDto.getDetailedImageUrl(),
				productDto.getDescription()
				);
		productRepository.save(product);
	}

   
    
}
