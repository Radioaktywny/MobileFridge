package org.mobilefridge.service;

import org.mobilefridge.domain.objects.Account;

import java.util.Collection;

/**
 * Created by Marcin on 28.10.2016.
 */

public interface AccountService {

    Account findOne(Long id);

    Account create(Account account);

    Account update(Account account);

}