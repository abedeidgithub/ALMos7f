package com.example.abedeid.almos7f;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Abed Eid on 19/07/2016.
 */
public interface ApiInterface {
    @GET("mp3quran.json")
    Call<Result> getBasic();

    @GET
    Call<Sura_Res> getSuras(@Url String value);



}
