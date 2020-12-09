package com.microphone.earspy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class LazyAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private Activity activity;
    private ArrayList<String> duration;
    private ArrayList<String> filename;
    private ArrayList<String> time;

    public static class ViewHolder {
        public ImageView image;
        public TextView txtDuration;
        public TextView txtFilename;
        public TextView txtTime;
    }

    public LazyAdapter(Activity a, ArrayList<String> d, ArrayList<String> d1, ArrayList<String> d2) {
        this.activity = a;
        this.filename = d;
        this.duration = d1;
        this.time = d2;
        inflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        try {
            return this.filename.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View vi = convertView;
        if (convertView == null) {
            vi = inflater.inflate(C1206R.layout.mp3_item, (ViewGroup) null);
            holder = new ViewHolder();
            holder.txtFilename = (TextView) vi.findViewById(C1206R.C1208id.filename);
            holder.txtTime = (TextView) vi.findViewById(C1206R.C1208id.time);
            holder.txtDuration = (TextView) vi.findViewById(C1206R.C1208id.duration);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
        holder.txtFilename.setText(this.filename.get(position));
        holder.txtTime.setText(this.time.get(position));
        try {
            holder.txtDuration.setText(this.duration.get(position));
        } catch (Exception e) {
        }
        return vi;
    }
}
