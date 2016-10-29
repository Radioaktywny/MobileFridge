package org.mobilefridge.service;

import org.mobilefridge.objects.AccountSettings;

/**
 * Created by Marcin on 28.10.2016.
 */
public interface AccountSettingsService {
    //TODO trzeba zadecydowac czy szukac np po id uzytkownika wtedy nie potrzebujemy id do servisu
    AccountSettings findOne(Long id);

    AccountSettings create(AccountSettings accountSettings);

    AccountSettings update(AccountSettings accountSettings);
}
