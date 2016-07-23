package com.example.abedeid.almos7f;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 22/07/2016.
 */
public class Sura_Res {
    @SerializedName("Suras_Name")
    private List<Suras> Suras_Name;

    public List<Suras> getSuras_Name() {
        return Suras_Name;
    }

    public void setSuras_Name(List<Suras> suras_Name) {
        Suras_Name = suras_Name;
    }

}
