package org.freemp3droid;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import com.microphone.earspy.WavListing;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Converter_Wav extends Service {
    int NOTI_CONVERTING = 1;
    int NOTI_CONV_FINISHED = 2;
    public AudioInnerConverter aic;
    String convertFile;
    BackgroundConverter converter;
    WavListing ctx;
    public boolean killedByUser;
    private final IBinder mBinder = new LocalBinder();
    NotificationManager mNotificationManager;
    String mp3File;
    String progf;
    int quality;
    String recFormat;
    int sampleRate;
    long tempSize;

    /* access modifiers changed from: private */
    public static native void convertMP3(String str, String str2, String str3, int i, int i2);

    private static native void kill();

    public void onCreate() {
        super.onCreate();
    }

    static {
        System.loadLibrary("Lame");
    }

    public void killConvert() {
        this.killedByUser = true;
        kill();
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public Converter_Wav getService() {
            return Converter_Wav.this;
        }
    }

    public void startConverting(WavListing ctx2, String convertFile2, int sampleRate2, int quality2) {
        this.ctx = ctx2;
        this.convertFile = convertFile2;
        this.sampleRate = sampleRate2;
        this.quality = quality2;
        this.mNotificationManager = (NotificationManager) ctx2.getSystemService("notification");
        this.killedByUser = false;
        this.progf = Util.createPath("prog", ".txt", ctx2);
        this.mp3File = Util.createMP3File(convertFile2, ctx2);
        this.converter = new BackgroundConverter();
        this.converter.execute(new String[0]);
    }

    public class BackgroundConverter extends AsyncTask<String, String, String> {
        public BackgroundConverter() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            Converter_Wav.this.tempSize = new File(Converter_Wav.this.convertFile).length();
            Converter_Wav.this.aic = new AudioInnerConverter();
            Converter_Wav.this.aic.execute(new String[0]);
            while (Converter_Wav.this.aic.getStatus() != AsyncTask.Status.FINISHED) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(new String[]{Converter_Wav.this.progf});
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if (!Converter_Wav.this.killedByUser) {
                Converter_Wav.this.cleanProgTxt();
                new File(Converter_Wav.this.progf).delete();
                Converter_Wav.this.converter = null;
                Converter_Wav.this.ctx.onConversionComplete();
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            File pf = new File(values[0]);
            if (pf.exists()) {
                byte[] pfb = new byte[((int) pf.length())];
                try {
                    new FileInputStream(values[0]).read(pfb);
                    if (pfb.length > 0) {
                        int progress = (int) (100.0d * (Double.parseDouble(new String(pfb)) / ((double) Converter_Wav.this.tempSize)));
                        if (Converter_Wav.this.ctx.progressDialog != null) {
                            Converter_Wav.this.ctx.progressDialog.setProgress(progress);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class AudioInnerConverter extends AsyncTask<String, String, String> {
        public AudioInnerConverter() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            Converter_Wav.convertMP3(Converter_Wav.this.convertFile, Converter_Wav.this.mp3File, Converter_Wav.this.progf, Converter_Wav.this.sampleRate, Converter_Wav.this.quality);
            return null;
        }
    }

    public void cleanProgTxt() {
        String progFile = Util.createPath("prog", ".txt", this.ctx);
        for (File f : new File(progFile.substring(0, progFile.lastIndexOf("/"))).listFiles()) {
            if (f.getName().contains("prog")) {
                f.delete();
            }
        }
    }
}
