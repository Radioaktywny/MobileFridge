package org.mobilefridge.domain.objects;

import java.math.BigInteger;

/**
 * Created by Marcin on 13.10.2016.
 */
public class Fridge {

    private Long id;
    private String name;

    public Fridge() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
