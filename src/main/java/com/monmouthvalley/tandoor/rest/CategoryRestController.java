package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Category;
import com.monmouthvalley.tandoor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
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
}
