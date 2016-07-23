package com.example.abedeid.almos7f;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 22/07/2016.
 */
public class Suras {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Suras(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
