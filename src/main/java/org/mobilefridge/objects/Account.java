/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String role;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Fridge fridge;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private AccountSettings accountSettings;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private Set<Recipe> recipeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public AccountSettings getAccountSettings() {
        return accountSettings;
    }

    public void setAccountSettings(AccountSettings accountSettings) {
        this.accountSettings = accountSettings;
    }

    public Set<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(Set<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
