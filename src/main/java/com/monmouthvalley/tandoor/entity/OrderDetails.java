package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tandoor_order_details")
public class OrderDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "menu_item_id")
    private int menuItemId;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order order;

    //when you delete order don't delete menuItem
    @OneToMany(fetch = FetchType.LAZY,
            cascade= {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH})
    @JoinColumn(name = "item_name")
    private List<MenuItem> menuItems;

    public OrderDetails(){

    }

    public OrderDetails(int quantity, int menuItemId, Order order, List<MenuItem> menuItems) {
        this.quantity = quantity;
        this.menuItemId = menuItemId;
        this.order = order;
        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
