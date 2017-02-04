/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Recipe;

import java.util.List;

/**
 * Created by Marcin on 30.01.2017.
 */
public interface RecipeService {

    Recipe createRecipe(Recipe recipe, String username);

    List<Recipe> getRecipes();

    Recipe updateRecipe(Recipe recipe, Long id);
}
