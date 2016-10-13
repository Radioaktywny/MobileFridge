package org.mobilefridge.model;

import java.math.BigInteger;

/**
 * Created by Marcin on 13.10.2016.
 */
public class Fridge {

    private BigInteger id;
    private String name;

    public Fridge() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
