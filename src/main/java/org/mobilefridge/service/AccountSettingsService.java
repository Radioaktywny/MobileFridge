/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.service;

import org.mobilefridge.objects.AccountSettings;

public interface AccountSettingsService {

    AccountSettings findOne(Long id);

    AccountSettings findByAccountName(String accountName);

    AccountSettings create(AccountSettings accountSettings);

    AccountSettings update(AccountSettings accountSettings, String accountName);
}
