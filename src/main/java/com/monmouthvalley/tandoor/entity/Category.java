package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    //menuItems is mapped to category
    //mappedBy = "category" refers to the category field
    @OneToMany(mappedBy = "category", cascade= CascadeType.ALL)
    private List<MenuItem> menuItems;


    public Category(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem item){
        if(menuItems == null){
            menuItems = new ArrayList<>();
        }
        menuItems.add(item);

        item.setCategory(this);
    }
}
