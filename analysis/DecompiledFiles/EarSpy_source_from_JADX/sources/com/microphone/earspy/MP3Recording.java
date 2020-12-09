package com.microphone.earspy;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.microphone.earspy.constant.Constant;
import java.io.File;
import java.util.Date;
import org.freemp3droid.Converter;

public class MP3Recording extends AppCompatActivity {
    private static final int bitRate = 192;
    public static String mp3Filename = null;
    private static final int sampleRate = 44100;

    /* renamed from: a */
    Activity f2318a;
    String convertFile = null;
    WavListing ctx;
    /* access modifiers changed from: private */
    public Converter mBoundConvService = null;
    /* access modifiers changed from: private */
    public ServiceConnection mConvertConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (MP3Recording.this.convertFile != null) {
                Converter unused = MP3Recording.this.mBoundConvService = ((Converter.LocalBinder) service).getService();
                MP3Recording.this.progressDialog = MP3Recording.this.initConvertingDialog();
                MP3Recording.this.progressDialog.show();
                MP3Recording.this.mBoundConvService.startConverting(MP3Recording.this, MP3Recording.this.convertFile, MP3Recording.sampleRate, MP3Recording.bitRate);
            }
        }

        public void onServiceDisconnected(ComponentName name) {
        }
    };
    /* access modifiers changed from: private */
    public Dialog mMP3_Dialog;
    public ProgressDialog progressDialog = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f2318a = this;
        initMp3Dialog();
    }

    /* access modifiers changed from: package-private */
    public void showDialog() {
        Date date = new Date();
        ((EditText) this.mMP3_Dialog.findViewById(C1206R.C1208id.file_name)).setText("EAR SPY_" + date.getDate() + getResources().getStringArray(C1206R.array.Months)[date.getMonth()] + (date.getYear() + 1900) + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds());
        this.mMP3_Dialog.show();
    }

    /* access modifiers changed from: package-private */
    public void showDialog(WavListing ctx2) {
        this.ctx = ctx2;
        Date date = new Date();
        ((EditText) this.mMP3_Dialog.findViewById(C1206R.C1208id.file_name)).setText("EarSpy_" + date.getDate() + getResources().getStringArray(C1206R.array.Months)[date.getMonth()] + (date.getYear() + 1900) + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds());
        this.mMP3_Dialog.show();
    }

    /* access modifiers changed from: protected */
    public void initMp3Dialog() {
        this.mMP3_Dialog = new Dialog(this);
        this.mMP3_Dialog.requestWindowFeature(1);
        this.mMP3_Dialog.setContentView(C1206R.layout.mp3_dialog);
        ((TextView) this.mMP3_Dialog.findViewById(C1206R.C1208id.path)).append(" " + Environment.getExternalStorageDirectory().getPath() + "/" + Constant.AUDIO_RECORDER_FOLDER + "/");
        ((Button) this.mMP3_Dialog.findViewById(C1206R.C1208id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MP3Recording.this.mMP3_Dialog.cancel();
            }
        });
        ((Button) this.mMP3_Dialog.findViewById(C1206R.C1208id.save)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newFname = ((EditText) MP3Recording.this.mMP3_Dialog.findViewById(C1206R.C1208id.file_name)).getText().toString().trim();
                MP3Recording.mp3Filename = newFname;
                if (!MP3Recording.isValidName(MP3Recording.this.getFilename(newFname)) || newFname.length() == 0) {
                    Toast.makeText(MP3Recording.this.getApplicationContext(), MP3Recording.this.getString(C1206R.string.toast_valid_filename), 0).show();
                    return;
                }
                ((InputMethodManager) MP3Recording.this.getSystemService("input_method")).hideSoftInputFromWindow(((EditText) MP3Recording.this.mMP3_Dialog.findViewById(C1206R.C1208id.file_name)).getWindowToken(), 0);
                Intent convIntent = new Intent(MP3Recording.this, Converter.class);
                MP3Recording.this.startService(convIntent);
                MP3Recording.this.bindService(convIntent, MP3Recording.this.mConvertConnection, 1);
                MP3Recording.this.mMP3_Dialog.cancel();
            }
        });
    }

    /* access modifiers changed from: private */
    public String getFilename(String str) {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), MicrophoneActivity.AUDIO_RECORDER_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + "/" + str + ".wav";
    }

    public static boolean isValidName(String text) {
        try {
            File file = new File(text);
            file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
            return true;
        } catch (Exception ex) {
            System.out.println("error:" + ex.toString());
            return false;
        }
    }

    public ProgressDialog initConvertingDialog() {
        String message = getString(C1206R.string.prog_msg);
        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setProgressStyle(1);
        pDialog.setProgress(0);
        pDialog.setTitle(getString(C1206R.string.prog_title));
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
        pDialog.setMax(100);
        return pDialog;
    }

    public void killConversion() {
        if (this.mBoundConvService != null) {
            this.mBoundConvService.killedByUser = true;
            this.mBoundConvService.killConvert();
        }
    }

    public void onConversionComplete() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
        Toast.makeText(getApplication(), getString(C1206R.string.toast_record_file_saved), 0).show();
        File file = new File(this.convertFile);
        if (file.exists()) {
            file.delete();
        }
        unbindService(this.mConvertConnection);
        if (this.ctx != null) {
            this.ctx.onGeneratingMP3();
        }
    }
}
