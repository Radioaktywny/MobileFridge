/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.api;

import org.mobilefridge.objects.AccountSettings;
import org.mobilefridge.objects.Fridge;
import org.mobilefridge.service.AccountSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcin on 11.12.2016.
 */
@Controller
public class AccountSettingsController {

    @Autowired
    AccountSettingsService accountSettingsService;

    @RequestMapping(value = "/api/get_account_settings/{username}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountSettings> getAccountSettings(@PathVariable("username") String username) {
        AccountSettings accountSettings = accountSettingsService.findByAccountName(username);
        return new ResponseEntity<>(accountSettings, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/save_account_settings/{username}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountSettings> saveAccountSettings(@RequestBody AccountSettings accountSettings,
                                                               @PathVariable("username") String username) {

        AccountSettings accountSettingsReturned = accountSettingsService.update(accountSettings, username);
        return new ResponseEntity<>(accountSettingsReturned, HttpStatus.CREATED);
    }


}
