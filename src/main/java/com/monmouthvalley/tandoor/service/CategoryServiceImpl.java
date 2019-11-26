package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.CategoryRepository;
import com.monmouthvalley.tandoor.entity.Category;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository theCategoryRepository){
        categoryRepository = theCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {

       Optional<Category> result = categoryRepository.findById(id);

        Category category;

        if(result.isPresent()){
            category = result.get();
        }
        else {
            //Category not found
            throw new GenericNotFoundException("No Category with id " + id);

        }
        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
