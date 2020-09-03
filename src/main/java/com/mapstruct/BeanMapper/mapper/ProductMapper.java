package com.mapstruct.BeanMapper.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mapstruct.BeanMapper.dto.ProductDTO;
import com.mapstruct.BeanMapper.model.Product;

//@Mapper(uses=SqlDateMapper.class)
public interface ProductMapper {

	@Mappings({
	 @Mapping(target="createdAt", source="dto.createdAt", dateFormat="dd-MM-yyyy HH:mm:ss"),
	 @Mapping(target="updatedAt", source="dto.updatedAt", dateFormat="dd-MM-yyyy HH:mm:ss")})
//    @Mapping(target = "createdAt", expression = "java(LocalDateTime.ofInstant(source.getCreatedAt(), timezone.toZoneId()))")
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.ofInstant(source.getUpdatedAt(), timezone.toZoneId()))")
//    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    ProductDTO toProductDTO(Product product);

//    @Mapping(target = "createdAt", expression = "java(LocalDateTime.ofInstant(source.getCreatedAt(), timezone.toZoneId()))")
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.ofInstant(source.getUpdatedAt(), timezone.toZoneId()))")
//    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    List<ProductDTO> toProductDTOs(List<Product> products);

//    @Mapping(target = "createdAt", expression = "java(LocalDateTime.ofInstant(source.getCreatedAt(), timezone.toZoneId()))")
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.ofInstant(source.getUpdatedAt(), timezone.toZoneId()))")
    Product toProduct(ProductDTO productDTO);
    

    
}