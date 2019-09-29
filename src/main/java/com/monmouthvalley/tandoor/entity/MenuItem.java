package com.monmouthvalley.tandoor.entity;


import javax.persistence.*;

@Entity
@Table(name = "menuItem")
public class MenuItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private double itemPrice;

    @Column(name = "cook_time")
    private int cookTime;

    @Column(name = "image_url")
    private String imageUrl;


    public  MenuItem(){

    }

    public MenuItem(String itemName, double itemPrice, int cookTime, String imageUrl) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cookTime = cookTime;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", cookTime=" + cookTime +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
