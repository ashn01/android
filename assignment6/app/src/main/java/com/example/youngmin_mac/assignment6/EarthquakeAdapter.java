package com.example.youngmin_mac.assignment6;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by youngmin-mac on 2018. 4. 17..
 */




public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private Context mContext;
    private List<Earthquake> dataList = new ArrayList<>();

    public EarthquakeAdapter(Context context, List<Earthquake> list) {
        super(context, 0 , list);
        mContext = context;
        dataList = list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            listItem = vi.inflate(R.layout.lv_row, null);
        }

        if(position%2==0)
            listItem.setBackgroundColor(Color.GREEN);
        else
            listItem.setBackgroundColor(Color.YELLOW);
        Earthquake e = dataList.get(position);
        TextView title = listItem.findViewById(R.id.title);
        TextView time = listItem.findViewById(R.id.time);
        title.setText(e.getTitle());
        time.setText(makeDate(e.getTime()));

        return listItem;
    }

    private String makeDate(String milliseconds)
    {
        Date updatedate = new Date(Long.parseLong(milliseconds));
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy ");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(updatedate);
    }

}
