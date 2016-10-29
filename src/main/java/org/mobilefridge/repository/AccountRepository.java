package org.mobilefridge.repository;

import org.mobilefridge.objects.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 28.10.2016.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByUsername(String username);

}
