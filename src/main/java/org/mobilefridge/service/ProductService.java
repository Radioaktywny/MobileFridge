/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Product;

import java.util.Collection;

public interface ProductService {

    Product findOne(Long id);

    Product create(Product product);

    Product update(Product product);

    Collection<Product> findByFridgeId(Long fridge_id);
}
