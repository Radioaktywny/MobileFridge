package org.mobilefridge.api;

import org.mobilefridge.domain.objects.Fridge;
import org.mobilefridge.service.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Marcin on 13.10.2016.
 */
@RestController
public class FridgeController {

    @Autowired
    private FridgeService fridgeService;

    @RequestMapping(value = "/api/get_all_fridges",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Fridge>> getFridges() {
        Collection<Fridge> fridges = fridgeService.findAll();
        return new ResponseEntity<Collection<Fridge>>(fridges, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get_fridge/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> getFridge(@PathVariable("id") Long id) {
        Fridge fridge = fridgeService.findOne(id);
        return new ResponseEntity<Fridge>(fridge, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/add_fridge",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> createFridge(@RequestBody Fridge fridge) {
        Fridge savedFridge = fridgeService.create(fridge);
        return new ResponseEntity<Fridge>(fridge, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/update_fridge/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> updateFridge(@RequestBody Fridge fridge) {
        Fridge updatedFridge = fridgeService.update(fridge);
        return new ResponseEntity<Fridge>(updatedFridge, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/update_fridge/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Fridge> deleteFridge(@PathVariable("id") Long id) {
        return fridgeService.delete(id) ? new ResponseEntity<Fridge>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<Fridge>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
