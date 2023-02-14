package com.example.RedisTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    @Id
    @GeneratedValue
    private String productId;
    private String productName;
    private double productPrice;

}
