package com.monmouthvalley.tandoor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "similar_menu_item")
public class SimilarItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @Column(name = "similar_menu_item_id")
    private int similarMenuItemId;

    /*@Column(name = "parent_menu_item_id",insertable = false, updatable = false)
    private int parentMenuItemId;*/

    @Column(name = "menu_item_id",insertable=false, updatable=false)
    @JsonIgnore
    private int menuItemId;

    /*@ManyToOne(fetch = FetchType.LAZY,
               cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH} )
    @JoinColumn(name = "similar_menu_item_id")
    @JsonIgnore
    private MenuItem menuItem;*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private MenuItem menuItem;

    public SimilarItem(){

    }

    public SimilarItem(int similarMenuItemId){
        this.similarMenuItemId = similarMenuItemId;
    }

    public SimilarItem(int similarMenuItemId, int parentMenuItemId){

        this.similarMenuItemId = similarMenuItemId;
        //this.parentMenuItemId = parentMenuItemId;
    }

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


    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }
}
