//package com.lipe.copilote.model;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "ORDERS")
//public class Order {
//
//    @Id
//    @Column(name = "order_id")
//    public long id;
//
//    @Column(name = "customer_id")
//    public long customerId;
//
//    @Column(name = "product_id")
//    public long productId;
//    public int quantity;
//
//    public double price;
//
//    public String status;
//
//    public Order() {
//    }
//
//    public Order(long id, long customerId, long productId, int quantity, double price, String status) {
//        this.id = id;
//        this.customerId = customerId;
//        this.productId = productId;
//        this.quantity = quantity;
//        this.price = price;
//        this.status = status;
//    }
//
//    public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(long customerId) {
//        this.customerId = customerId;
//    }
//
//    public long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = productId;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//}
