package org.mobilefridge.repository;

import org.mobilefridge.domain.objects.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 28.10.2016.
 */
@Repository
public interface FridgeReposotiry extends JpaRepository<Fridge,Long>{
}
