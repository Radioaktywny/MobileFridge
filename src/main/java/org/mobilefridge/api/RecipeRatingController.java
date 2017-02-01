/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import org.mobilefridge.objects.Recipe;
import org.mobilefridge.objects.RecipeRating;
import org.mobilefridge.service.RecipeRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcin on 31.01.2017.
 */
@Controller
public class RecipeRatingController {

    @Autowired
    RecipeRatingService recipeRatingService;

    @RequestMapping(value = "/api/add_rating/{recipe_id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addRecipe(@RequestBody RecipeRating rating, @PathVariable("recipe_id") Long recipeId) {
        return new ResponseEntity<>(recipeRatingService.addRecipeRating(rating,recipeId), HttpStatus.CREATED);
    }
}
