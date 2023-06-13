package com.example.orders;

class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id) {
    super("There is no order with given id: " + id + "\n");
  }
}
