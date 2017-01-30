/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.json.JSONObject;
import org.mobilefridge.logic.ProduktyZsieci;
import org.mobilefridge.objects.Fridge;
import org.mobilefridge.objects.Product;
import org.mobilefridge.repository.FridgeReposotiry;
import org.mobilefridge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FridgeReposotiry fridgeReposotiry;

    @Override
    public Product findOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product create(Product product, Long fridge_id) {
        if(fridgeReposotiry.getOne(fridge_id) != null)
        {

                    if(product.getGtin() != null) {
                        //mogla by być weryfikacja tego
                        JSONObject json = ProduktyZsieci.getJsonFromProduktyZsieci(product.getGtin());
                        product.setIconBig(json.getString("IconBig"));
                        product.setIconSmall(json.getString("IconSmall"));
                        product.setWeight(json.getString("weight"));
                        product.setWeightUnit(json.getString("weightUnit"));
                        product.setName(json.getString("name"));
                        product.setAddingTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                    }
                    product.setFridge(fridgeReposotiry.getOne(fridge_id));
        }
        else return null;
        return  productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.getOne(product.getId());
    }

    @Override
    public Collection<Product> findByFridgeId(Long fridge_id) {
        Fridge fridge = fridgeReposotiry.findOne(fridge_id);
        return fridge.getProductList();
    }

    @Override
    public boolean delete(Long id) {
        if (findOne(id) == null) {
            return false;
        }
        productRepository.delete(id);
        return true;
    }
}
