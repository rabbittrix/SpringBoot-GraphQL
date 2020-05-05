package com.jrsf.shopping.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id){

        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll(){
        List<Client> list = new ArrayList<>();
        return clientRepository.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }

    @Transactional
    public Client save(Client c){
        return clientRepository.save(c);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (clientRepository.findById(id).isPresent()){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
