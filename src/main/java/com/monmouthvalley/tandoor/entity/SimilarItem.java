package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;

@Entity
@Table(name = "similar_menu_item")
public class SimilarItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "similar_menu_item_id")
    private int similarMenuItemId;

    @Column(name = "parent_menu_item_id")
    private int parentMenuItemId;


    /*@Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private String itemPrice;
*/

    public SimilarItem(){

    }

    public SimilarItem(int similarMenuItemId){

        this.similarMenuItemId = similarMenuItemId;
    }

    /*public SimilarItem(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSimilarMenuItemId() {
        return similarMenuItemId;
    }

    public void setSimilarMenuItemId(int similarMenuItemId) {
        this.similarMenuItemId = similarMenuItemId;
    }

    /* public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }*/
}
