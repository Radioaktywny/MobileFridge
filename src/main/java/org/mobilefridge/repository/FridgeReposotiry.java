package org.mobilefridge.repository;

import org.mobilefridge.objects.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeReposotiry extends JpaRepository<Fridge, Long> {
}
