package com.example.ben.greendaodemo.Adapter;

import android.content.Context;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ben.greendaodemo.R;

import java.util.List;

import de.greenrobot.dao.query.Query;
import greendao.student;

/**
 * Created by ben on 2017/3/31.
 */

public class MainListViewAdapter extends BaseAdapter {
    private LayoutInflater _inflater;
    private List<student> _list;

    public MainListViewAdapter(Context context, List<student> list) {
        _inflater = LayoutInflater.from(context);
        _list = list;
    }

    @Override
    public int getCount() {
        return _list.size();
    }

    @Override
    public Object getItem(int position) {
        return _list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _list.indexOf(_list.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = _inflater.inflate(android.R.layout.activity_list_item, null);
            viewHolder = new ViewHolder((TextView) convertView.findViewById(R.id.listViewItemName),
                    (TextView) convertView.findViewById(R.id.listViewItemPoint),
                    (TextView) convertView.findViewById(R.id.listViewItemKinds));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(_list.get(position).getName());
        viewHolder.txtKinds.setText(_list.get(position).getKinds());
        viewHolder.txtPoint.setText(_list.get(position).getPoint());

        return convertView;
    }


    private class ViewHolder {
        TextView txtName, txtPoint, txtKinds;

        public ViewHolder(TextView txtName, TextView txtPoint, TextView txtKinds) {
            this.txtName = txtName;
            this.txtPoint = txtPoint;
            this.txtKinds = txtKinds;
        }
    }
}
