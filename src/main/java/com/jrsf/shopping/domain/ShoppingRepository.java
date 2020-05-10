package com.jrsf.shopping.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {

    public List<Shopping> findShoppingsByClientId(Long id);
}
