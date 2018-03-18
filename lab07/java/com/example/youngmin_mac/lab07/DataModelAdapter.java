package com.example.youngmin_mac.lab07;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngmin-mac on 2018. 3. 17..
 */

public class DataModelAdapter extends ArrayAdapter<DataModel> {

    private Context mContext;
    private List<DataModel> dataList = new ArrayList<>();

    public DataModelAdapter(Context context, List<DataModel> list) {
        super(context, 0 , list);
        mContext = context;
        dataList = list;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            listItem = vi.inflate(R.layout.lv_row, null);
        }

        DataModel d = dataList.get(position);
        TextView name = listItem.findViewById(R.id.textView2);
        name.setText(d.getLine()[0]);

        return listItem;
    }
}