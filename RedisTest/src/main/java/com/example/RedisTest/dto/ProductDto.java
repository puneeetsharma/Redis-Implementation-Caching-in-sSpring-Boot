package com.example.RedisTest.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    private String productId;
    private String productName;
    private double productPrice;
}
