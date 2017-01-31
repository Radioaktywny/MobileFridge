/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Marcin on 30.01.2017.
 */

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String picture;

    private String componentsOfRecipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    @OneToMany(mappedBy = "recipe")
    @JsonManagedReference
    private Set<RecipeRating> ratingList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setComponentsOfRecipe(String componentsOfRecipe) {
        this.componentsOfRecipe = componentsOfRecipe;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getComponentsOfRecipe() {
        return componentsOfRecipe;
    }


    public Set<RecipeRating> getRatingList() {
        return ratingList;
    }

}