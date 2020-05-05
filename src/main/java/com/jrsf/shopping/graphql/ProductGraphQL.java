package com.jrsf.shopping.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jrsf.shopping.domain.Product;
import com.jrsf.shopping.domain.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProductService productService;

    public Product product(Long id){

        return productService.findById(id);
    }

    public List<Product> products(){
        return productService.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }

    public Product saveProduct(ProductInput input){
        ModelMapper m = new ModelMapper();
        Product p = m.map(input,Product.class);
        return productService.save(p);
    }

    public Boolean deleteProduct(Long id){
        return productService.deleteById(id);
    }
}
