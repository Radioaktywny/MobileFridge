package org.mobilefridge.service;

import org.mobilefridge.objects.Fridge;

import java.util.Collection;

/**
 * Created by Marcin on 13.10.2016.
 */
public interface FridgeService {

    Collection<Fridge> findAll();

    Fridge findOne(Long id);

    Fridge create(Fridge fridge);

    Fridge update(Fridge fridge);

    boolean delete(Long id);


}
