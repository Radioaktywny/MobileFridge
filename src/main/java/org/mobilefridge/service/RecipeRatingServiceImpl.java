/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.RecipeRating;
import org.mobilefridge.repository.RecipeRatingRepository;
import org.mobilefridge.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 31.01.2017.
 */
@Service
public class RecipeRatingServiceImpl implements RecipeRatingService {

    @Autowired
    RecipeRatingRepository recipeRatingRepository;

    @Autowired
    RecipeRepository recipeRepository;


    @Override
    public RecipeRating addRecipeRating(RecipeRating rating, Long recipeId) {
        rating.setRecipe(recipeRepository.findOne(recipeId));
        return recipeRatingRepository.save(rating);
    }
}
