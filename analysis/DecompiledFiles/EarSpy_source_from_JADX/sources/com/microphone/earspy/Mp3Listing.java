package com.microphone.earspy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.microphone.earspy.inappbilling.Passport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class Mp3Listing extends Activity {

    /* renamed from: a */
    Activity f2320a;
    /* access modifiers changed from: private */
    public LazyAdapter adapter = null;
    /* access modifiers changed from: private */
    public ListView list = null;
    /* access modifiers changed from: private */
    public final Runnable returnRes = new Runnable() {
        public void run() {
            Mp3Listing.this.view_switcher.setDisplayedChild(1);
            if (Mp3Listing.this.strFilename.size() > 0) {
                LazyAdapter unused = Mp3Listing.this.adapter = new LazyAdapter(Mp3Listing.this.f2320a, Mp3Listing.this.strFilename, Mp3Listing.this.strDuration, Mp3Listing.this.strTime);
                Mp3Listing.this.list.setAdapter(Mp3Listing.this.adapter);
                return;
            }
            TextView unused2 = Mp3Listing.this.txtNo = (TextView) Mp3Listing.this.findViewById(C1206R.C1208id.txtNo);
            Mp3Listing.this.txtNo.setVisibility(0);
            Mp3Listing.this.list.setVisibility(4);
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
    /* access modifiers changed from: private */
    public Runnable viewOrders = null;
    /* access modifiers changed from: private */
    public ViewSwitcher view_switcher = null;

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.mp3_list);
        ((TextView) findViewById(C1206R.C1208id.txt_title)).setText(getResources().getString(C1206R.string.mp3_gallery));
        SharedPreferences mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.txtNo = (TextView) findViewById(C1206R.C1208id.txtNo);
        this.view_switcher = (ViewSwitcher) findViewById(C1206R.C1208id.view_switcher);
        this.list = (ListView) findViewById(C1206R.C1208id.list);
        if (!mSharedPreferences.getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
            this.view_switcher.setDisplayedChild(1);
            this.list.setVisibility(8);
            this.txtNo.setVisibility(0);
            this.txtNo.setText(getResources().getString(C1206R.string.purchase_mp3_recording));
            return;
        }
        this.f2320a = this;
        this.viewOrders = new Runnable() {
            public void run() {
                Mp3Listing.this.getFilenameList();
                Mp3Listing.this.runOnUiThread(Mp3Listing.this.returnRes);
            }
        };
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                Mp3Listing.this.showOptionDialog((String) Mp3Listing.this.strFilename.get(position));
                return false;
            }
        });
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                File mp3file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + MicrophoneActivity.AUDIO_RECORDER_FOLDER + "/" + ((String) Mp3Listing.this.strFilename.get(position)));
                if (mp3file != null) {
                    Mp3Listing.this.playMP3File(mp3file);
                }
            }
        });
        this.strFilename = new ArrayList<>();
        this.strTime = new ArrayList<>();
        this.strDuration = new ArrayList<>();
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
                if (f.isFile() && (dot = f.getAbsolutePath().lastIndexOf(".")) != -1 && f.getAbsolutePath().substring(dot + 1).equals("mp3") && Build.VERSION.SDK_INT >= 10) {
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

    /* access modifiers changed from: private */
    public void showOptionDialog(final String filename) {
        final File mp3file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + MicrophoneActivity.AUDIO_RECORDER_FOLDER + "/" + filename);
        CharSequence[] items = {getString(C1206R.string.play), getString(C1206R.string.share), getString(C1206R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(filename);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int position) {
                switch (position) {
                    case 0:
                        Mp3Listing.this.playMP3File(mp3file);
                        return;
                    case 1:
                        EasyTracker.getTracker().trackEvent("MP3 Gallery", "MP3 Options", "Share mp3 file", 200);
                        EasyTracker.getTracker().sendEvent("MP3 Gallery", "MP3 Options", "Share mp3 file", 200);
                        Mp3Listing.this.shareMP3File(mp3file);
                        return;
                    case 2:
                        EasyTracker.getTracker().trackEvent("MP3 Gallery", "MP3 Options", "Delete mp3 file", 200);
                        EasyTracker.getTracker().sendEvent("MP3 Gallery", "MP3 Options", "Delete mp3 file", 200);
                        Mp3Listing.this.deleteMP3File(mp3file, filename);
                        return;
                    default:
                        return;
                }
            }
        });
        AlertDialog alert = builder.create();
        if (mp3file != null) {
            alert.show();
        }
    }

    /* access modifiers changed from: private */
    public void playMP3File(File mp3file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(mp3file), "audio/mp3");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void shareMP3File(File mp3file) {
        Intent share = new Intent("android.intent.action.SEND");
        share.setType("audio/*");
        share.putExtra("android.intent.extra.STREAM", Uri.fromFile(mp3file));
        try {
            startActivity(Intent.createChooser(share, getString(C1206R.string.share_via)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void deleteMP3File(final File mp3file, String filename) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(filename).setMessage(getString(C1206R.string.confirm_delete_msg)).setPositiveButton(getString(C1206R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (mp3file.delete()) {
                    Mp3Listing.this.view_switcher.setDisplayedChild(0);
                    new Thread((ThreadGroup) null, Mp3Listing.this.viewOrders, "Background").start();
                    Toast.makeText(Mp3Listing.this.getApplicationContext(), Mp3Listing.this.getString(C1206R.string.toast_file_deleted), 0).show();
                }
            }
        }).setNegativeButton(getString(C1206R.string.f2337no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }
}
