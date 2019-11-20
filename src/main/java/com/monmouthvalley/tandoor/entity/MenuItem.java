package com.monmouthvalley.tandoor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "created_at")
    private Date dateCreated;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

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

    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @Column(name = "special")
    private boolean isSpecial;

    @Column(name = "vegan")
    private boolean isVegan;

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

    public MenuItem(String itemName, BigDecimal itemPrice, int cookTime, Category category, int categoryId,
                    boolean isSpecial, boolean isVegan, String description, String imageUrl) {

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cookTime = cookTime;
        this.category = category;
        this.categoryId = categoryId;
        this.isSpecial = isSpecial;
        this.isVegan = isVegan;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public MenuItem(String itemName, BigDecimal itemPrice, int cookTime, String imageUrl) {
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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
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

    public int getCategoryId() {
        return categoryId;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
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

    public void removeSimilarItem(SimilarItem item){

        this.similarItems.remove(item);
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
