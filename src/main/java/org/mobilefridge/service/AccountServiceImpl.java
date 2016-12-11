/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Account;
import org.mobilefridge.objects.AccountSettings;
import org.mobilefridge.repository.AccountRepository;
import org.mobilefridge.repository.AccountSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountSettingsRepository accountSettingsRepository;
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account create(Account account) {
        if (account.getId() != null) {
            return null;
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("USER");
        AccountSettings accountSettings= new AccountSettings();
        accountSettings.setAccountId(account.getId());
        if(accountSettingsRepository.save(accountSettings)==null)
            return null;
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return null;
    }
}
