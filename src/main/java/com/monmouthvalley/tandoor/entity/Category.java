package com.monmouthvalley.tandoor.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "category_name")
    private String categoryName;

    //menuItems is mapped to category
    //mappedBy = "category" refers to the category field
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
                cascade= CascadeType.ALL)
    private List<MenuItem> menuItems;


    public Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = null;
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

    public void deleteMenuItem(MenuItem item){
        menuItems.remove(item);
        item.setCategory(null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
