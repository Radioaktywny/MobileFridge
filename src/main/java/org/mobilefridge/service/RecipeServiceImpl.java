/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Recipe;
import org.mobilefridge.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 30.01.2017.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    AccountService accountService;

    @Override
    public Recipe createRecipe(Recipe recipe, String username) {
        recipe.setAccount(accountService.findByUsername(username));
        return recipeRepository.save(recipe);
    }
}
