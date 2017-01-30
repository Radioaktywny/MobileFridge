/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import org.mobilefridge.objects.Recipe;
import org.mobilefridge.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Marcin on 30.01.2017.
 */
@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @RequestMapping(value = "/api/add_recipe/user_id/{userName}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addRecipe(@RequestBody Recipe recipe, @PathVariable("userName") String userName) {
        return new ResponseEntity<>(recipeService.createRecipe(recipe,userName), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/get_recipes",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recipe>> getRecipes() {
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }


}
