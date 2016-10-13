package org.mobilefridge.api;

import org.mobilefridge.model.Fridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 13.10.2016.
 */
@RestController
public class GettingFridgeController {

    private static BigInteger nextId;
    private static Map<BigInteger, Fridge> fridgesMap;

    private static Fridge save(Fridge fridge) {
        if (fridgesMap == null) {
            fridgesMap = new HashMap<BigInteger, Fridge>();
            nextId = BigInteger.ONE;
        }
        fridge.setId(nextId);
        nextId = nextId.add(BigInteger.ONE);
        fridgesMap.put(fridge.getId(), fridge);
        return fridge;
    }

    static {
       Fridge f= new Fridge();
        f.setName("fr1");
        save(f);
        f=new Fridge();
        f.setName("f2");
        save(f);
    }

    @RequestMapping(value = "/api/getting_fridges",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Fridge>> getFridges() {

        Collection<Fridge> fridges= fridgesMap.values();

        return new ResponseEntity<Collection<Fridge>>(fridges, HttpStatus.OK);

    }
}
