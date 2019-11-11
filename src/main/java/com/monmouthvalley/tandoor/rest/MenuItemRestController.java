package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Category;
import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;
import com.monmouthvalley.tandoor.service.CategoryService;
import com.monmouthvalley.tandoor.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemRestController {

    private MenuItemService menuItemService;

    private CategoryService categoryService;


    @Autowired
    public MenuItemRestController(MenuItemService theMenuItemService, CategoryService theCategoryService){
        menuItemService = theMenuItemService;
        categoryService = theCategoryService;

    }

    // expose api/menuitems and get all menu items
    @GetMapping("/menuitems")
    public List<MenuItem> findAll(){
        return  menuItemService.findAll();
    }

    @GetMapping("/menuitems/{itemId}")
    public MenuItem getItem(@PathVariable int itemId){

        MenuItem item  = menuItemService.findById(itemId);


        if(item == null){
            throw new RuntimeException("Item with the id " + itemId + " not found");
        }
        return item;
    }

    @PostMapping("/menuitems")
    public MenuItem addItem(@RequestBody MenuItem item, @RequestParam int categoryId){
        //In case they pass an id in JSON...set id to 0
        //this is to force a save of new item...instead of update
        Category category = categoryService.findById(categoryId);

        if(category == null){
            throw new RuntimeException("No category found with the id " + categoryId);
        }
        item.setId(0);
        item.setDateCreated(new Date());

        item.setCategory(category);

        category.addMenuItem(item);

        menuItemService.save(item);

        return item;

    }

    // Saving with categoryService returns menuitem with id of 0 in the json response
    //but the correct value is entered in the database

    /*@PostMapping("/categories/{categoryId}/menuitems")
    public MenuItem addItemByCategory(@RequestBody MenuItem menuItem, @PathVariable int categoryId){

        Category category = categoryService.findById(categoryId);

        if(category == null){
            throw new RuntimeException("No category found with the id " + categoryId);
        }
        menuItem.setId(0);
        menuItem.setDateCreated(new Date());
        menuItem.setCategory(category);

        category.addMenuItem(menuItem);

        categoryService.save(category);

        return menuItem;

    }*/

    @PostMapping("/menuitems/{itemId}/similaritem")
    public SimilarItem addSimilarItem(@RequestBody SimilarItem similarItem){

        //MenuItem item = menuItemService.findById(itemId);
        menuItemService.save(similarItem);

       return similarItem;
    }

    @PutMapping("/menuitems")
    public MenuItem updateItem(@RequestBody MenuItem item){

        menuItemService.save(item);

        return item;
    }

    @DeleteMapping("/menuitems/{itemId}")
    public String deleteItem(@PathVariable int itemId){

        MenuItem item = menuItemService.findById(itemId);

        if(item == null){
            throw new RuntimeException("Item with the id " + itemId + " not found");
        }

        menuItemService.deleteById(itemId);

        return "Deleted MenuItem with id " + itemId;
    }
}
