package com.monmouthvalley.tandoor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   // @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "created_at")
    private Date dateCreated;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private double itemPrice;

    @Column(name = "cook_time")
    private int cookTime;

    //child element
    //Do not delete category when you delete a menuitem


    @ManyToOne(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST ,
                CascadeType.REFRESH} )
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @Column(name = "special")
    private boolean isSpecial;

    @Column(name = "vegan")
    private boolean isVagen;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    //setting up a unidirectional relationship with similarItems
    @OneToMany( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST ,
                            CascadeType.REFRESH})
    @JoinColumn(name = "parent_menu_item_id")
    private List<SimilarItem> similarItems;


    public  MenuItem(){

    }

    public MenuItem(String itemName, double itemPrice, int cookTime, Category category,
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


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public List<SimilarItem> getSimilarItems() {
        return similarItems;
    }

    public void setSimilarItems(List<SimilarItem> similarItems) {
        this.similarItems = similarItems;
    }

    public void addSimilarItem(SimilarItem item){

        if(similarItems == null){
            similarItems = new ArrayList<>();
        }
        similarItems.add(item);
    }

//    @Override
//    public String toString() {
//        return "MenuItem{" +
//                "id=" + id +
//                ", itemName='" + itemName + '\'' +
//                ", itemPrice=" + itemPrice +
//                ", cookTime=" + cookTime +
//                ", imageUrl='" + imageUrl + '\'' +
//                '}';
//    }
}
