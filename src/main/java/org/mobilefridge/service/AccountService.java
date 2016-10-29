package org.mobilefridge.service;

import org.mobilefridge.objects.Account;

/**
 * Created by Marcin on 28.10.2016.
 */

public interface AccountService {

    Account findByUsername(String username);

    Account create(Account account);

    Account update(Account account);

}