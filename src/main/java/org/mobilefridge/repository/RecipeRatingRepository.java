/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.repository;

import org.mobilefridge.objects.RecipeRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 31.01.2017.
 */
@Repository
public interface RecipeRatingRepository extends JpaRepository<RecipeRating, Long> {
}
