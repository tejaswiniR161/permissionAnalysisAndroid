package org.freemp3droid.filechooser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.microphone.earspy.C1206R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileChooser extends ListActivity {
    private FileArrayAdapter adapter;
    private File currentDir;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.currentDir = new File("/sdcard/");
        fill(this.currentDir);
    }

    private void fill(File f) {
        File[] dirs = f.listFiles();
        setTitle("Current Dir: " + f.getName());
        List<Option> dir = new ArrayList<>();
        List<Option> fls = new ArrayList<>();
        try {
            for (File ff : dirs) {
                if (ff.isDirectory()) {
                    dir.add(new Option(ff.getName(), "Folder", ff.getAbsolutePath()));
                } else {
                    fls.add(new Option(ff.getName(), "File Size: " + ff.length(), ff.getAbsolutePath()));
                }
            }
        } catch (Exception e) {
        }
        Collections.sort(dir);
        Collections.sort(fls);
        dir.addAll(fls);
        if (!f.getName().equalsIgnoreCase("sdcard")) {
            dir.add(0, new Option("..", "Parent Directory", f.getParent()));
        }
        this.adapter = new FileArrayAdapter(this, C1206R.layout.file_view, dir);
        setListAdapter(this.adapter);
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Option o = this.adapter.getItem(position);
        if (o.getData().equalsIgnoreCase("folder") || o.getData().equalsIgnoreCase("parent directory")) {
            this.currentDir = new File(o.getPath());
            fill(this.currentDir);
            return;
        }
        onFileClick(o);
    }

    private void onFileClick(Option o) {
        Intent retIntent = new Intent();
        System.out.println("path:" + o.getPath());
        retIntent.putExtra("chosenFile", o.getPath());
        setResult(-1, retIntent);
        finish();
    }
}
