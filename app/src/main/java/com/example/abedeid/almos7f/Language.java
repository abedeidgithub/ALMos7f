package com.example.abedeid.almos7f;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 19/07/2016.
 */
public class Language {
    @SerializedName("language")
    private String language;
    @SerializedName("json")
    private String json;
    @SerializedName("sura_name")
    private String sura_name;

    public Language(String language) {
        this.language = language;


    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getSura_name() {
        return sura_name;
    }

    public void setSura_name(String sura_name) {
        this.sura_name = sura_name;
    }
}
