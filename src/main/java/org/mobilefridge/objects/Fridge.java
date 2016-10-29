package org.mobilefridge.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by Marcin on 13.10.2016.
 */
@Entity
public class Fridge {

    @Id
    @GeneratedValue
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
