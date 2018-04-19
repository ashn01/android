package com.example.youngmin_mac.assignment4;

/**
 * Created by youngmin-mac on 2018. 4. 8..
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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
        TextView city = listItem.findViewById(R.id.city);
        TextView name = listItem.findViewById(R.id.name);
        city.setText(d.getCity());
        name.setText(d.getName());

        return listItem;
    }
}
