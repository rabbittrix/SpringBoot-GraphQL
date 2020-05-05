package com.jrsf.shopping.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    public Shopping findById(Long id){ return shoppingRepository.findById(id).orElse(null); }

    public List<Shopping> findAll(){
        return shoppingRepository.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }

    @Transactional
    public Shopping save(Shopping s){
        return shoppingRepository.save(s);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (shoppingRepository.findById(id).isPresent()){
            shoppingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
