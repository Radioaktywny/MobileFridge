package org.mobilefridge.repository;

import org.mobilefridge.objects.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 28.10.2016.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
}
