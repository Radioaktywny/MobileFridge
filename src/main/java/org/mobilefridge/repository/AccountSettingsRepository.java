package org.mobilefridge.repository;

import org.mobilefridge.objects.AccountSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSettingsRepository extends JpaRepository<AccountSettings, Long> {
}
