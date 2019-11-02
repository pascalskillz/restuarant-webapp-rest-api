package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Category;
import com.monmouthvalley.tandoor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/categories")
//    public void addCategory
}
