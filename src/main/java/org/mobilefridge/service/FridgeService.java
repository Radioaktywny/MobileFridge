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
