package com.jrsf.shopping.graphql;

import lombok.Data;

@Data
public class ProductInput {

    private Long id;
    private String name;
    private double price;
}
