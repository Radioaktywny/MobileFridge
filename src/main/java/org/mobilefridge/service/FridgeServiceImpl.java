package org.mobilefridge.service;

import org.mobilefridge.domain.objects.Fridge;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 13.10.2016.
 */
@Service
public class FridgeServiceImpl implements FridgeService {

    private static Long nextId;
    private static Map<Long, Fridge> fridgesMap;

    private static Fridge save(Fridge fridge) {
        if (fridgesMap == null) {
            fridgesMap = new HashMap<Long, Fridge>();
            nextId = new Long(1);
        }
        if (fridge.getId() != null) {
            fridgesMap.get(fridge.getId()).setName(fridge.getName());
            return fridge;
        }
        fridge.setId(nextId);
        nextId += 1;
        fridgesMap.put(fridge.getId(), fridge);
        return fridge;
    }

    private static boolean remove(Long id) {
        Fridge deletedFridge = fridgesMap.remove(id);
        if (deletedFridge == null) {
            return false;
        }
        return true;
    }

    static {
        Fridge f = new Fridge();
        f.setName("fr1");
        save(f);
        f = new Fridge();
        f.setName("f2");
        save(f);
    }

    @Override
    public Collection<Fridge> findAll() {
        Collection<Fridge> fridges = fridgesMap.values();
        return fridges;
    }

    @Override
    public Fridge findOne(Long id) {
        Fridge fridge = fridgesMap.get(id);
        return fridge;
    }

    @Override
    public Fridge create(Fridge fridge) {
        Fridge savedFridge = save(fridge);
        return savedFridge;
    }

    @Override
    public Fridge update(Fridge fridge) {
        Fridge updatedFridge = save(fridge);
        return updatedFridge;
    }

    @Override
    public boolean delete(Long id) {
        return remove(id);
    }
}
