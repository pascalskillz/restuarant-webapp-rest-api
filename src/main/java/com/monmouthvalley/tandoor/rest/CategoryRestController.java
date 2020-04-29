package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Category;
import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://tandoor.netlify.com", "http://tandoor.s3-website-us-east-1.amazonaws.com"})
public class CategoryRestController {


    private CategoryService categoryService;


    @Autowired
    public CategoryRestController(CategoryService theCategoryService){
        categoryService = theCategoryService;

    }

    @GetMapping("/categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public Category addCategory(@Valid @RequestBody Category category){

        if(category == null){
            throw new RuntimeException("invalid category name provided");
        }
        category.setId(0);

        categoryService.save(category);

        return category;
    }

    @GetMapping("/categories/{categoryId}")
    public Category category(@PathVariable int categoryId){

        Category category = categoryService.findById(categoryId);

        if(category == null){
            throw new RuntimeException("No category found with the id " + categoryId);
        }

        return category;
    }

    @GetMapping("/categories/{categoryId}/menuitems")
    public Page<MenuItem> getCategoryMenuItems(@PathVariable int categoryId, Pageable pageable) {

        Category category = categoryService.findById(categoryId);

        if(category == null){
            throw new RuntimeException("No category found with the id " + categoryId);
        }
        List<MenuItem> menuItems = category.getMenuItems();

        int start = (int) pageable.getOffset();

        int end = (start + pageable.getPageSize()) > menuItems.size() ? menuItems.size() : (start + pageable.getPageSize());
        Page<MenuItem> pages = new PageImpl<>(menuItems.subList(start, end), pageable, menuItems.size());

        return pages;
    }
}
