package org.freemp3droid.filechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.microphone.earspy.C1206R;
import java.util.List;

public class FileArrayAdapter extends ArrayAdapter<Option> {

    /* renamed from: c */
    private Context f2340c;

    /* renamed from: id */
    private int f2341id;
    private List<Option> items;

    public FileArrayAdapter(Context context, int textViewResourceId, List<Option> objects) {
        super(context, textViewResourceId, objects);
        this.f2340c = context;
        this.f2341id = textViewResourceId;
        this.items = objects;
    }

    public Option getItem(int i) {
        return this.items.get(i);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = ((LayoutInflater) this.f2340c.getSystemService("layout_inflater")).inflate(this.f2341id, (ViewGroup) null);
        }
        Option o = this.items.get(position);
        if (o != null) {
            TextView t1 = (TextView) v.findViewById(C1206R.C1208id.TextView01);
            TextView t2 = (TextView) v.findViewById(C1206R.C1208id.TextView02);
            if (t1 != null) {
                t1.setText(o.getName());
            }
            if (t2 != null) {
                t2.setText(o.getData());
            }
        }
        return v;
    }
}
