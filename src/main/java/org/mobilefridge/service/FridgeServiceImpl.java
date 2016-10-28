package org.mobilefridge.service;

import org.mobilefridge.domain.objects.Fridge;
import org.mobilefridge.repository.FridgeReposotiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Marcin on 13.10.2016.
 */
@Service
public class FridgeServiceImpl implements FridgeService {

    @Autowired
    private FridgeReposotiry fridgeReposotiry;

    @Override
    public Collection<Fridge> findAll() {
        Collection<Fridge> fridges = fridgeReposotiry.findAll();
        return fridges;
    }

    @Override
    public Fridge findOne(Long id) {
        Fridge fridge = fridgeReposotiry.findOne(id);
        return fridge;
    }

    @Override
    public Fridge create(Fridge fridge) {
        if(fridge.getId()!=null){
            //cannot create greeting with specified id
            return null;
        }
        Fridge savedFridge = fridgeReposotiry.save(fridge);
        return savedFridge;
    }

    @Override
    public Fridge update(Fridge fridge) {
        Fridge fridgePersisted=findOne(fridge.getId());
        if(fridgePersisted!=null){
            //Cannot update fridge with specified id
            return null;
        }
        Fridge updatedFridge = fridgeReposotiry.save(fridge);
        return updatedFridge;
    }

    @Override
    public boolean delete(Long id) {
        if(findOne(id)==null){
            return false;
        }
        fridgeReposotiry.delete(id);
        return true;
    }
}
