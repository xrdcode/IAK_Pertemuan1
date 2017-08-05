package com.xrdcode.pertemuan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xrdcode.pertemuan1.R;

/**
 * Created by reysd on 05/08/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    String data[];
    LayoutInflater layoutInflater;

    public CustomAdapter(Context mContext, String data[]) {
        this.data = data;
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView weather = (TextView) convertView.findViewById(R.id.weather);
        TextView temp = (TextView) convertView.findViewById(R.id.temp);
        String[] arr = data[position].split("-");
        date.setText(arr[0]);
        weather.setText(arr[1]);
        temp.setText(arr[2]);
        return convertView;
    }
}
