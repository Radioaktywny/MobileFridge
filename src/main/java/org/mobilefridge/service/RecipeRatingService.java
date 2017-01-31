/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.RecipeRating;

/**
 * Created by Marcin on 31.01.2017.
 */
public interface RecipeRatingService {
    RecipeRating addRecipeRating(RecipeRating rating, Long recipeId);
}
