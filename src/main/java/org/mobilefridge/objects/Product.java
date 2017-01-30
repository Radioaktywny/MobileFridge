/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String weight;

    private String gtin;

    private String IconSmall;

    private String IconBig;

    private String weightUnit;

    private String addingTime;



    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fridge_Id")
    @JsonBackReference
    private Fridge fridge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }


    public String toString()
    {
    if(getFridge() !=null)
        return "Id :" + getId()+" Name :" + getName() +" Weight :" + getWeight() +" fridge_Id" + getFridge().getId();
    return "Id :" + getId()+" Name :" + getName() +" Weight :" + getWeight();
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getIconSmall() {
        return IconSmall;
    }

    public void setIconSmall(String iconSmall) {
        IconSmall = iconSmall;
    }

    public String getIconBig() {
        return IconBig;
    }

    public void setIconBig(String iconBig) {
        IconBig = iconBig;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(String addingTime) {
        this.addingTime = addingTime;
    }
}
