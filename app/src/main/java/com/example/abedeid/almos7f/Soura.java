package com.example.abedeid.almos7f;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Soura extends AppCompatActivity {
    Boolean Flage = true;
    ListView listView;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soura);

        listView = (ListView) findViewById(R.id.listView_2);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Sura_Res> Suras = api.getSuras(value);
        Suras.enqueue(new Callback<Sura_Res>() {
            @Override
            public void onResponse(Call<Sura_Res> call, Response<Sura_Res> response) {
                List<Suras> suras_name = response.body().getSuras_Name();
                final Sura_Adapter adapter = new Sura_Adapter(suras_name, getBaseContext());


                listView.setAdapter(adapter);
                // TODO Animation
                AnimationSet set = new AnimationSet(true);

                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                set.addAnimation(animation);

                animation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0.0f,Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, -1.0f,Animation.RELATIVE_TO_SELF, 0.0f
                );
                animation.setDuration(100);
                set.addAnimation(animation);
                LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
                listView.setLayoutAnimation(controller);
                // TODO end

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int i = (int) adapter.getItem(position);

                        String name;
                        if (i < 10) {
                            name = "00" + i;
                        } else if (i < 100) {
                            name = "0" + i;
                        } else {
                            name = i + "";
                        }
                        String URL = "http://server11.mp3quran.net/shatri/" + name + ".mp3";

                        if (Flage == true) {
                            Flage = false;

                            try {
                                mp = new MediaPlayer();
                                mp.setDataSource(URL);
                                mp.prepare();
                                mp.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            mp.release();
                            mp = null;
                            try {
                                mp = new MediaPlayer();
                                mp.setDataSource(URL);
                                mp.prepare();
                                mp.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }


                });
            }

            @Override
            public void onFailure(Call<Sura_Res> call, Throwable t) {

            }
        });

    }
}
