package com.example.abedeid.almos7f;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abed Eid on 22/07/2016.
 */
public class Sura_Adapter extends BaseAdapter {
    List<Suras> souras;
    Context context;
    private DisplayMetrics metrics;
    public Sura_Adapter(List<Suras> souras, Context context) {
        this.souras = souras;
        this.context = context;

    }

    @Override
    public int getCount() {
        return souras.size();
    }

    @Override
    public Object getItem(int position) {
        return souras.get(position).getId();
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
        String s = souras.get(position).getName();

        holder.txt.setText(s);

        return poster;
    }
}

class Holder {


    TextView txt;

    public Holder(View v) {
        this.txt = (TextView) v.findViewById(R.id.lang_name);
    }
}