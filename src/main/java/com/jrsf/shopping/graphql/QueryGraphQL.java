package com.jrsf.shopping.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    //public String shopping() { return "Shopping GraphQL";}

    public int soma(int a, int b) {
        return a+b;
    }

}
