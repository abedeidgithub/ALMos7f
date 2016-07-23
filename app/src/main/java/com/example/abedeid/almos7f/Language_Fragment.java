package com.example.abedeid.almos7f;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Language_Fragment extends Fragment {
    ListView language_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_language_, container, false);
        language_list = (ListView) root.findViewById(R.id.listView);
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> apiBasic = api.getBasic();
        apiBasic.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                List<Language> languages = response.body().getMp3quran();
                final Adapter adapter = new Adapter(languages, getContext());
                language_list.setAdapter(adapter);
                language_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(),Soura.class);
                        intent.putExtra("key", adapter.getItem(position));
                        getActivity().startActivity(intent);

                        Toast.makeText(getActivity(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;

    }


}
