package com.example.abedeid.almos7f;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 19/07/2016.
 */
public class Result {


    @SerializedName("mp3quran")
    private List<Language> mp3quran;

    public List<Language> getMp3quran() {
        return mp3quran;
    }

    public void setMp3quran(List<Language> mp3quran) {
        this.mp3quran = mp3quran;
    }
}
