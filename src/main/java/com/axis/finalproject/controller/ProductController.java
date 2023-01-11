package com.axis.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.axis.finalproject.entity.Product;
import com.axis.finalproject.product.dto.ProductDto;

import com.axis.finalproject.service.ProductService;

@RestController
@RequestMapping("/api/test/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService; 

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> product = productService.listProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/add")
	public ResponseEntity<String> addStakeholder(@RequestBody ProductDto productDto){
		productService.addproduct(productDto);
		return new ResponseEntity<String>("product added Successfuly",HttpStatus.OK);
	}

}