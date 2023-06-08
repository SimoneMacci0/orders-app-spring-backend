package com.example.orders;

class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id) {
    super("Could not find order with the specific id: " + id + "\n");
  }
}
