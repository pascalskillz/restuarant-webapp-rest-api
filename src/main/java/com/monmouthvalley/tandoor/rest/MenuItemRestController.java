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

    @PostMapping("/menuitems/{parentItemId}/similaritem")
    public SimilarItem addSimilarItem(@RequestBody SimilarItem similarItem,
                                      @PathVariable int parentItemId){

        //Get parentItem for validation
        MenuItem parentItem = menuItemService.findById(parentItemId);

        //Get the similarItem for validation. Similar item should already exist in the db
        int similarMenuItemId = similarItem.getSimilarMenuItemId();

        MenuItem theSimilarItem = menuItemService.findById(similarMenuItemId);

         //similarItem = menuItemService.findById(similarMenuItemId);

        if(parentItem == null ){
            throw new RuntimeException("No item found with the id " + parentItem);
        }
        if(theSimilarItem == null ){
            throw new RuntimeException("No item found with the id " + similarMenuItemId);
        }

        //set the similar item parent item
        similarItem.setParentMenuItemId(parentItemId);

        //add this item to the parentItem similarItems's list
        parentItem.addSimilarItem(similarItem);

        //save parent item. Cascades down and saves the similaritem too
        menuItemService.save(parentItem);

       return similarItem;
    }

   /* @DeleteMapping("/menuitems/{parentItemId}/similaritem/{similarMenuItemId}")
    public String removeSimilarItem(@PathVariable int parentItemId, @PathVariable int similarMenuItemId){


        MenuItem parentItem = menuItemService.findById(parentItemId);

        //SimilarItem similarItem = menuItemService.findSimilarItem(similarMenuItemId);

        parentItem.removeSimilarItem(similarMenuItemId);

        menuItemService.deleteSimilarItemById(similarItem.getId());

        return "Removed menu item with id " + similarMenuItemId + " from similarItem list of item with id " + parentItemId;

    }*/

   @GetMapping("/menuitems/{parentItemId}/similaritem/{similarMenuItemId}")
   public SimilarItem getSimilarItem(@PathVariable int similarMenuItemId, @PathVariable int parentItemId){

       return menuItemService.findSimilarItem(similarMenuItemId,parentItemId);
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
