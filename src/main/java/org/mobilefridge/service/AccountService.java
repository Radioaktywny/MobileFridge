package org.mobilefridge.service;

import org.mobilefridge.objects.Account;

public interface AccountService {

    Account findByUsername(String username);

    Account create(Account account);

    Account update(Account account);

}
