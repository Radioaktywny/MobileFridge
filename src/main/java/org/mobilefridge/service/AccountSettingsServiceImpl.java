/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Account;
import org.mobilefridge.objects.AccountSettings;
import org.mobilefridge.repository.AccountSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSettingsServiceImpl implements AccountSettingsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountSettingsRepository accountSettingsRepository;

    @Override
    public AccountSettings findOne(Long id) {
        return accountSettingsRepository.findOne(id);
    }

    @Override
    public AccountSettings findByAccountName(String accountName) {
        Account account = accountService.findByUsername(accountName);
        return account.getAccountSettings();
    }

    @Override
    public AccountSettings create(AccountSettings accountSettings) {
        return create(accountSettings);
    }

    @Override
    public AccountSettings update(AccountSettings accountSettings) {
        return update(accountSettings);
    }
}
