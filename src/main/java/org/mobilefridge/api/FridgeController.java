/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import java.util.Collection;

import org.mobilefridge.objects.Fridge;
import org.mobilefridge.service.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FridgeController {

    @Autowired
    private FridgeService fridgeService;

    @RequestMapping(value = "/api/get_all_fridges",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Fridge>> getFridges() {
        Collection<Fridge> fridges = fridgeService.findAll();
        return new ResponseEntity<>(fridges, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get_fridge/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> getFridge(@PathVariable("id") Long id) {
        Fridge fridge = fridgeService.findOne(id);
        return new ResponseEntity<>(fridge, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/add_fridge",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> createFridge(@RequestBody Fridge fridge) {
        fridgeService.create(fridge);
        return new ResponseEntity<>(fridge, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/update_fridge/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fridge> updateFridge(@RequestBody Fridge fridge, @PathVariable("id") String id) {
        Fridge updatedFridge = fridgeService.update(fridge);
        return new ResponseEntity<>(updatedFridge, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/delete_fridge/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Fridge> deleteFridge(@PathVariable("id") Long id) {
        return fridgeService.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
