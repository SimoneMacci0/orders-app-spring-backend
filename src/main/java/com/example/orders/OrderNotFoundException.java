package com.example.orders;

class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id) {
    super("No order with given id: " + id + "\n");
  }
}
