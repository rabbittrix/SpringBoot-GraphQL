package com.jrsf.shopping.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jrsf.shopping.domain.Client;
import com.jrsf.shopping.domain.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClientService clientService;

    public Client client(Long id){

        return clientService.findById(id);
    }

    public List<Client> clients(){
        List<Client> list = new ArrayList<>();
        return clientService.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }

    public Client saveClient(ClientInput input){
        ModelMapper m = new ModelMapper();
        Client c = m.map(input,Client.class);
        return clientService.save(c);
    }

    public Boolean deleteClient(Long id){
        return clientService.deleteById(id);
    }
}
