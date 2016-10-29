package org.mobilefridge.service;

import org.mobilefridge.objects.Account;
import org.mobilefridge.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 28.10.2016.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account findByUsername(String username) {
        Account account= accountRepository.findByUsername(username);
        return account;
    }

    @Override
    public Account create(Account account) {
        if(account.getId()!=null)
        {
            return null;
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account savedFridge = accountRepository.save(account);
        return savedFridge;
    }

    @Override
    public Account update(Account account) {
        return null;
    }
}
