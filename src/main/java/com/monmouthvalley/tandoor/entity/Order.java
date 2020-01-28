package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tandoor_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "created_at")
    private Date dateCreated;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "menu_item_id")
    private int menuItemId;

    @Column(name = "quantity")
    private int quantity;


    public Order(){

    }

    public Order(String orderNumber, Date dateCreated, String customerName, int menuItemId, int quantity) {
        this.orderNumber = orderNumber;
        this.dateCreated = dateCreated;
        this.customerName = customerName;
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

