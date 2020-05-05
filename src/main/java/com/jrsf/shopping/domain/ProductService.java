package com.jrsf.shopping.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
        /*
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " + i, "test"+i+"@gmail.com"));
        }
        return list;
         */
    }


    public Product findById(Long id){ return productRepository.findById(id).orElse(null); }

    @Transactional
    public Product save(Product p){
        return productRepository.save(p);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
