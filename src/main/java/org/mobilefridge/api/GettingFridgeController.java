package org.mobilefridge.api;

import org.mobilefridge.model.domain.objects.Fridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(fridge.getId()!=null){
            fridgesMap.get(fridge.getId()).setName(fridge.getName());
            return fridge;
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

    @RequestMapping(value = "/api/get_all_fridges",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Fridge>> getFridges() {

        Collection<Fridge> fridges= fridgesMap.values();

        return new ResponseEntity<Collection<Fridge>>(fridges, HttpStatus.OK);

    }
    @RequestMapping(value = "/api/get_fridge/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> getFridge(@PathVariable("id") BigInteger id ) {


        Fridge fridge= fridgesMap.get(id);

        return new ResponseEntity<Fridge>(fridge, HttpStatus.OK);

    }
    @RequestMapping(value = "/api/add_fridge/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Fridge> getFridge(@RequestBody Fridge fridge ) {

        Fridge savedFridge = save(fridge);
        return new ResponseEntity<Fridge>(fridge, HttpStatus.CREATED);

    }

}
