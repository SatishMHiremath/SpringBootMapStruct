package com.mapstruct.BeanMapper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapstruct.BeanMapper.dto.ProductDTO;
import com.mapstruct.BeanMapper.mapper.ProductMapper;
import com.mapstruct.BeanMapper.model.Product;
import com.mapstruct.BeanMapper.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productService.save(productMapper.toProduct(productDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
