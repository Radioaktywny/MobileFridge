/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import org.mobilefridge.objects.Fridge;
import org.mobilefridge.objects.Product;
import org.mobilefridge.service.FridgeService;
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
import java.util.Set;

/**
 * Created by Marcin on 11.12.2016.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    FridgeService fridgeService;

    @RequestMapping(value = "/api/get_all_products/{fridge_id}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Product>> getFridges(@PathVariable("fridge_id") Long fridge_id) {
        Collection<Product> products = productService.findByFridgeId(fridge_id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/add_product/{fridge_id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> add_product(@RequestBody Product product, @PathVariable("fridge_id") Long fridge_id) {
        return new ResponseEntity<Product>(productService.create(product, fridge_id),
                productService.create(product, fridge_id) == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
//        Collection<Product> products = productService.findByFridgeId(fridge_id);
        //TODO musi istniec lodowka trzzbea zakodzic sprawdzanie cyz lodowka istnbieeje
//        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/delete_product/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Fridge> deleteFridge(@PathVariable("id") Long id) {
        return productService.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(value = "/api/get_products/user_id/{userName}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Product>> get_produts(@PathVariable("userName") String userName) {
        return new ResponseEntity<Set<Product>>(fridgeService.getProductListByUser(userName), HttpStatus.OK);
    }

}

