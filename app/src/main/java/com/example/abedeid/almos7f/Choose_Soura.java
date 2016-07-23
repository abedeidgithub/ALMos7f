package com.example.abedeid.almos7f;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class Choose_Soura extends Fragment {
    Boolean Flage = true;
    ListView listView;
    MediaPlayer mp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_language_, container, false);

        listView = (ListView) root.findViewById(R.id.listView_2);
//        Bundle bundle = this.getArguments();
//        String value = bundle.getString("value");
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Sura_Res> Suras = api.getSuras("http://mp3quran.net/api/_arabic_sura.json");
        Suras.enqueue(new Callback<Sura_Res>() {
            @Override
            public void onResponse(Call<Sura_Res> call, Response<Sura_Res> response) {
                List<Suras> suras_name = response.body().getSuras_Name();
                final Sura_Adapter adapter = new Sura_Adapter(suras_name, getContext());


                listView.setAdapter(adapter);
                // TODO Animation
                AnimationSet set = new AnimationSet(true);

                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                set.addAnimation(animation);

                animation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
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


        return root;
    }
}
