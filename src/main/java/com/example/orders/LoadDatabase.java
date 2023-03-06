package com.example.orders;

import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(OrderRepository orderRepository) {

    return args -> {
        
      // If database empty, add test item..
      if(StreamSupport.stream(orderRepository.findAll().spliterator(), false).count() == 0) {
        orderRepository.save(new Order("TEST", Status.COMPLETED));
        orderRepository.findAll().forEach(order -> {
          log.info("Preloaded " + order);
        });
      }  
       
    };
  }
}