/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Recipe;
import org.mobilefridge.objects.RecipeRating;
import org.mobilefridge.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcin on 30.01.2017.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    RecipeRatingService recipeRatingService;

    @Override
    public Recipe createRecipe(Recipe recipe, String username) {
        recipe.setAccount(accountService.findByUsername(username));
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe rec : recipes) {
            Integer ratingValue = 0;
            for (RecipeRating rating : rec.getRatingList().stream().collect(Collectors.toList())) {
                ratingValue += rating.getRating();
            }
            if (Math.toIntExact(rec.getRatingList().stream().count()) > 0) {
                ratingValue = ratingValue / Math.toIntExact(rec.getRatingList().stream().count());
                rec.setRating(ratingValue);
            } else {
                rec.setRating(0);
            }
        }
        return recipes;
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) {
        Recipe recipeToSave = recipeRepository.findOne(id);
        recipeToSave.setPicture(recipe.getPicture());
        return recipeRepository.save(recipeToSave);
    }
}
