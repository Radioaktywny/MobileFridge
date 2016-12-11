/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import org.mobilefridge.objects.Fridge;
import org.mobilefridge.objects.Product;
import org.mobilefridge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Marcin on 11.12.2016.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/api/get_all_products/{fridge_id}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Product>> getFridges(@PathVariable("fridge_id") Long fridge_id) {
        Collection<Product> products = productService.findByFridgeId(fridge_id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}

