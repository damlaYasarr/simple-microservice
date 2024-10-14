package com.customer.order.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    Long id;
    String customerNumber;
    String productId;
    int quantity;
    Date orderOrder;
}
