package org.freemp3droid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.microphone.earspy.C1206R;

public class ImageAdapter extends ArrayAdapter<Integer> {
    Context ctx;
    private Integer[] items;

    public ImageAdapter(Context context, int textViewResourceId, Integer[] items2) {
        super(context, textViewResourceId, items2);
        this.ctx = context;
        this.items = items2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
        View v = convertView;
        if (v == null) {
            v = ((LayoutInflater) this.ctx.getSystemService("layout_inflater")).inflate(C1206R.layout.image_list_item, (ViewGroup) null);
        }
        Integer it = this.items[position];
        if (!(it == null || (iv = (ImageView) v.findViewById(C1206R.C1208id.image_list_image)) == null)) {
            iv.setImageDrawable(this.ctx.getResources().getDrawable(it.intValue()));
        }
        return v;
    }
}
