package org.mobilefridge.service;

import org.mobilefridge.objects.Product;

/**
 * Created by Marcin on 28.10.2016.
 */
public interface ProductService {

    Product findOne(Long id);

    Product create(Product product);

    Product update(Product product);
}
