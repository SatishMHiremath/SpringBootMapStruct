package com.mapstruct.BeanMapper.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mapstruct.BeanMapper.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
