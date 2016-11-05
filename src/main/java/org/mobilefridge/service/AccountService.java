/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.Account;

public interface AccountService {

    Account findByUsername(String username);

    Account create(Account account);

    Account update(Account account);

}
