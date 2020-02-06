package com.monmouthvalley.tandoor.shared;

import com.monmouthvalley.tandoor.dao.MenuItemRepository;
import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Component
public class Utils {


    private MenuItemRepository menuItemRepository;

    @Autowired
    public Utils(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String generateId(int length){
        return generateRandomString(length);
    }


    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        for(int i =0; i < length; i++){
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(sb);
    }

    public MenuItem validateMenuItem(int menuItemId) {

        Optional<MenuItem> result = menuItemRepository.findById(menuItemId);

        MenuItem menuItem;

        if(result.isPresent()){
            menuItem = result.get();
        }
        else {
            //meunItem not found
            throw new GenericNotFoundException("No menu item with id " + menuItemId);
        }
        return menuItem;
    }
}
