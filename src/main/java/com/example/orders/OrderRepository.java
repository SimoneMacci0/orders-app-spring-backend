package com.example.orders;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

interface OrderRepository extends JpaRepository<Order, Long> {
    
}