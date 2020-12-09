package com.microphone.earspy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.microphone.earspy.inappbilling.Passport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class WavListing extends MP3Recording {

    /* renamed from: a */
    Activity f2339a;
    /* access modifiers changed from: private */
    public LazyAdapter adapter = null;
    /* access modifiers changed from: private */
    public ListView list = null;
    /* access modifiers changed from: private */
    public final Runnable returnRes = new Runnable() {
        public void run() {
            WavListing.this.view_switcher.setDisplayedChild(1);
            if (WavListing.this.strFilename.size() > 0) {
                LazyAdapter unused = WavListing.this.adapter = new LazyAdapter(WavListing.this.f2339a, WavListing.this.strFilename, WavListing.this.strDuration, WavListing.this.strTime);
                WavListing.this.list.setAdapter(WavListing.this.adapter);
                return;
            }
            TextView unused2 = WavListing.this.txtNo = (TextView) WavListing.this.findViewById(C1206R.C1208id.txtNo);
            WavListing.this.txtNo.setVisibility(0);
            WavListing.this.list.setVisibility(4);
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<String> strDuration;
    /* access modifiers changed from: private */
    public ArrayList<String> strFilename;
    /* access modifiers changed from: private */
    public ArrayList<String> strTime;
    /* access modifiers changed from: private */
    public TextView txtNo = null;
    private Runnable viewOrders = null;
    /* access modifiers changed from: private */
    public ViewSwitcher view_switcher = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C1206R.layout.mp3_list);
        ((TextView) findViewById(C1206R.C1208id.txt_title)).setText(getResources().getString(C1206R.string.recover_files));
        this.txtNo = (TextView) findViewById(C1206R.C1208id.txtNo);
        this.view_switcher = (ViewSwitcher) findViewById(C1206R.C1208id.view_switcher);
        this.list = (ListView) findViewById(C1206R.C1208id.list);
        if (!getSharedPreferences("Microphone_EarSpy", 0).getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
            this.view_switcher.setDisplayedChild(1);
            this.list.setVisibility(8);
            this.txtNo.setVisibility(0);
            this.txtNo.setText(getResources().getString(C1206R.string.purchase_mp3_recording));
            return;
        }
        this.f2339a = this;
        initMp3Dialog();
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                WavListing.this.convertFile = Environment.getExternalStorageDirectory().getPath() + "/" + MicrophoneActivity.AUDIO_RECORDER_FOLDER + "/" + ((String) WavListing.this.strFilename.get(position));
                WavListing.this.showDialog(WavListing.this);
            }
        });
        this.strFilename = new ArrayList<>();
        this.strTime = new ArrayList<>();
        this.strDuration = new ArrayList<>();
        this.viewOrders = new Runnable() {
            public void run() {
                WavListing.this.getFilenameList();
                WavListing.this.runOnUiThread(WavListing.this.returnRes);
            }
        };
        new Thread((ThreadGroup) null, this.viewOrders, "Background").start();
    }

    /* access modifiers changed from: private */
    @TargetApi(10)
    public void getFilenameList() {
        int dot;
        this.strFilename = new ArrayList<>();
        this.strTime = new ArrayList<>();
        this.strDuration = new ArrayList<>();
        File file = new File(Environment.getExternalStorageDirectory().getPath(), MicrophoneActivity.AUDIO_RECORDER_FOLDER);
        SimpleDateFormat format_datetime = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.ENGLISH);
        SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat format_time = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        try {
            for (File f : file.listFiles()) {
                if (f.isFile() && (dot = f.getAbsolutePath().lastIndexOf(".")) != -1 && f.getAbsolutePath().substring(dot + 1).equals("wav") && Build.VERSION.SDK_INT > 10) {
                    MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
                    metaRetriever.setDataSource(f.getAbsolutePath());
                    long dur = Long.parseLong(metaRetriever.extractMetadata(9));
                    String seconds = String.valueOf((dur % 60000) / 1000);
                    String minutes = String.valueOf(dur / 60000);
                    Date lastModified = new Date(f.lastModified());
                    if (format_date.format(new Date()).compareTo(format_date.format(lastModified)) == 0) {
                        this.strTime.add(format_time.format(lastModified));
                    } else {
                        this.strTime.add(format_datetime.format(lastModified));
                    }
                    this.strFilename.add(f.getName());
                    if (seconds.length() == 1) {
                        this.strDuration.add("0" + minutes + ":0" + seconds);
                    } else {
                        this.strDuration.add("0" + minutes + ":" + seconds);
                    }
                    metaRetriever.release();
                }
            }
            Collections.reverse(this.strDuration);
            Collections.reverse(this.strFilename);
            Collections.reverse(this.strTime);
        } catch (Exception e) {
        }
    }

    public void onGeneratingMP3() {
        this.view_switcher.setDisplayedChild(0);
        new Thread((ThreadGroup) null, this.viewOrders, "Background").start();
    }
}
