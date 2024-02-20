package com.prashant.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;
}
