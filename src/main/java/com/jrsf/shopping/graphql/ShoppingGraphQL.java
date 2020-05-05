package com.jrsf.shopping.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jrsf.shopping.domain.ClientService;
import com.jrsf.shopping.domain.ProductService;
import com.jrsf.shopping.domain.Shopping;
import com.jrsf.shopping.domain.ShoppingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ShoppingGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    public Shopping shopping(Long id){

        return shoppingService.findById(id);
    }

    public List<Shopping> shoppings(){
        return shoppingService.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }

    public Shopping saveShopping(ShoppingInput input){
        ModelMapper m = new ModelMapper();
        Shopping s = m.map(input, Shopping.class);

        s.setData(new Date());

        s.setClient(clientService.findById(input.getClientId()));
        s.setProduct(productService.findById(input.getProductId()));

        return shoppingService.save(s);
    }

    public Boolean deleteShopping(Long id){
        return shoppingService.deleteById(id);
    }
}
