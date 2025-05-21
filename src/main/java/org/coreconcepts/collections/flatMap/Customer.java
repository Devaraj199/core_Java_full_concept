package org.coreconcepts.collections.flatMap;

import java.util.List;

public class Customer {
    List<Order> orders;
    Customer(List<Order> orders) { this.orders = orders; }
    List<Order> getOrders() { return orders; }

}
