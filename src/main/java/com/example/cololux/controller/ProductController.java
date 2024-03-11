package com.example.cololux.controller;



import com.example.cololux.dto.ProductDto;
import com.example.cololux.entity.Product;
import com.example.cololux.respository.ProductRepository;
import com.example.cololux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRep;

    @Autowired
    private ProductService service;

    @GetMapping("/get/product")
    public List<Product> getProduct() {
        return productRep.findAll();
    }


    @GetMapping("/get/product/code/{productId}")
    public ResponseEntity<ProductDto> getProductByCode(@PathVariable String productId) {
        ProductDto pDto = service.getProductByCode(productId);
        return new ResponseEntity<>(pDto, HttpStatus.OK);
    }


    @PostMapping("/create/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto pDto = service.saveProduct(productDto);
        return new ResponseEntity<>(pDto, HttpStatus.OK);
    }


    @DeleteMapping("/delete/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        service.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
