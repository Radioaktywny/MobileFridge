/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import java.util.Collection;

import org.mobilefridge.objects.Fridge;

public interface FridgeService {

    Collection<Fridge> findAll();

    Fridge findOne(Long id);

    Fridge create(Fridge fridge);

    Fridge update(Fridge fridge);

    boolean delete(Long id);


}
