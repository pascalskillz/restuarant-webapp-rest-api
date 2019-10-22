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

    @Column(name = "category")
    private String category;

    @Column(name = "special")
    private boolean isSpecial;

    @Column(name = "vegan")
    private boolean isVagen;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

//    @OneToMany(mappedBy)
//    private similarItem similarItem();


    public  MenuItem(){

    }

    public MenuItem(String itemName, double itemPrice, int cookTime, String category,
                    boolean isSpecial, boolean isVagen, String description, String imageUrl) {

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cookTime = cookTime;
        this.category = category;
        this.isSpecial = isSpecial;
        this.isVagen = isVagen;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public boolean isVagen() {
        return isVagen;
    }

    public void setVagen(boolean vagen) {
        isVagen = vagen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
