package com.mapstruct.BeanMapper.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Date createdAt;
    private Date updatedAt;
}
