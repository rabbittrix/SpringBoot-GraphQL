package com.jrsf.shopping.graphql;

import lombok.Data;

@Data
public class ShoppingInput {

    private Long id;
    private Integer quantity;
    private String status;

    private Long clientId;
    private Long productId;
}
