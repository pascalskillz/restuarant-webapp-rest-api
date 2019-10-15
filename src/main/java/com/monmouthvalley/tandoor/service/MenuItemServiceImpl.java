package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.MenuItemRepository;
import com.monmouthvalley.tandoor.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository theMenuItemRepository){

        menuItemRepository = theMenuItemRepository;
    }

    @Override
    public List<MenuItem> findAll() {

        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem findById(int id) {

        //using optional so we don't have to specifically check for null

        Optional<MenuItem> result = menuItemRepository.findById(id);

        MenuItem item;

        if(result.isPresent()){
            item = result.get();
        }
        else {
            //meunItem not found
            throw new RuntimeException("No menu item with id " + id);

        }
        return item;
    }

    @Override
    public void save(MenuItem menuItem) {
        menuItemRepository.save(menuItem);

    }

    @Override
    public void deleteById(int id) {
        menuItemRepository.deleteById(id);
    }
}
