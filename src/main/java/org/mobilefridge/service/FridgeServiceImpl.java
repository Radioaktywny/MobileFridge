package org.mobilefridge.service;

import java.util.Collection;

import org.mobilefridge.objects.Fridge;
import org.mobilefridge.repository.FridgeReposotiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeServiceImpl implements FridgeService {

    private final FridgeReposotiry fridgeReposotiry;

    @Autowired
    public FridgeServiceImpl(FridgeReposotiry fridgeReposotiry) {
        this.fridgeReposotiry = fridgeReposotiry;
    }

    @Override
    public Collection<Fridge> findAll() {
        return fridgeReposotiry.findAll();
    }

    @Override
    public Fridge findOne(Long id) {
        return fridgeReposotiry.findOne(id);
    }

    @Override
    public Fridge create(Fridge fridge) {
        if (fridge.getId() != null) {
            //cannot create greeting with specified id
            return null;
        }
        return fridgeReposotiry.save(fridge);
    }

    @Override
    public Fridge update(Fridge fridge) {
        Fridge fridgePersisted = findOne(fridge.getId());
        if (fridgePersisted != null) {
            //Cannot update fridge with specified id
            return null;
        }
        return fridgeReposotiry.save(fridge);
    }

    @Override
    public boolean delete(Long id) {
        if (findOne(id) == null) {
            return false;
        }
        fridgeReposotiry.delete(id);
        return true;
    }
}
