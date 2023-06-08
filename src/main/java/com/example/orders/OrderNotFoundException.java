package com.example.orders;

class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id) {
    super("No order exists with id: " + id + "\n");
  }
}
