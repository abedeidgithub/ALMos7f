package com.example.abedeid.almos7f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abed Eid on 22/07/2016.
 */
public class Adapter extends BaseAdapter {
    List<Language> languages;
    Context context;

    public Adapter(List<Language> languages, Context context) {
        this.languages = languages;
        this.context = context;
    }



    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public String getItem(int position) {
        return languages.get(position).getSura_name();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View poster = convertView;
        MyHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            poster = (TextView) inflater.inflate(R.layout.language_row, parent, false);
            holder = new MyHolder(poster);
            poster.setTag(holder);
        } else {
            holder = (MyHolder) poster.getTag();
        }
        String s = languages.get(position).getLanguage();

        holder.txt.setText(s.substring(1, s.length()));

        return poster;
    }
}

class MyHolder {


    TextView txt;

    public MyHolder(View v) {
        this.txt = (TextView) v.findViewById(R.id.lang_name);
    }
}
