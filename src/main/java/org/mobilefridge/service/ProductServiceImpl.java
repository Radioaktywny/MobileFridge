/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Fridge;
import org.mobilefridge.objects.Product;
import org.mobilefridge.repository.FridgeReposotiry;
import org.mobilefridge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FridgeReposotiry fridgeReposotiry;

    @Override
    public Product findOne(Long id) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Collection<Product> findByFridgeId(Long fridge_id) {
        Fridge fridge= fridgeReposotiry.findOne(fridge_id);
        return fridge.getProductList();
    }
}
