package org.mobilefridge.domain.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Marcin on 13.10.2016.
 */
@Entity
public class Product {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int weight;

    private Long fridgeId;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Long getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(Long fridgeId) {
        this.fridgeId = fridgeId;
    }


}
