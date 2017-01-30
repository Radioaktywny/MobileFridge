/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Recipe;

/**
 * Created by Marcin on 30.01.2017.
 */
public interface RecipeService {

    Recipe createRecipe(Recipe recipe, String username);
}
