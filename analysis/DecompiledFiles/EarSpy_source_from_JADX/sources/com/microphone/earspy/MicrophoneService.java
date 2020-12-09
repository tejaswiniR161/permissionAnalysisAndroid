package com.microphone.earspy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.LoudnessEnhancer;
import android.media.audiofx.NoiseSuppressor;
import android.media.audiofx.Virtualizer;
import android.media.audiofx.Visualizer;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import com.microphone.earspy.VerticalSeekBar;
import com.microphone.earspy.constant.Constant;
import com.microphone.earspy.inappbilling.Passport;
import com.microphone.earspy.widget.WidgetProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MicrophoneService extends Service implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String APP_TAG = "Microphone_EarSpy";
    private static final String AUDIO_RECORDER_FOLDER = "EAR SPY";
    private static final String AUDIO_RECORDER_TEMP_FILE = "record_temp.raw";
    private static final int RECORDER_BPP = 16;
    static BassBoost mBassBoost = null;
    private static final int mFormat = 2;
    private static final int mSampleRate = 44100;
    static Virtualizer mVirtualizer = null;
    AppWidgetManager appWidgetManager;
    private int audioSessionId;
    ComponentName compName;
    int curCircleNo = 0;
    int[] drawIdsHighlighted = {C1206R.C1207drawable.widget_red_1, C1206R.C1207drawable.widget_red_2, C1206R.C1207drawable.widget_red_3, C1206R.C1207drawable.widget_red_4};
    int[] drawIdsNormal = {C1206R.C1207drawable.widget_black_1, C1206R.C1207drawable.widget_black_2, C1206R.C1207drawable.widget_black_3, C1206R.C1207drawable.widget_black_4};
    private int[] idsWidgetBtn = {C1206R.C1208id.WidgetImageView1, C1206R.C1208id.WidgetImageView2, C1206R.C1208id.WidgetImageView3, C1206R.C1208id.WidgetImageView4};
    /* access modifiers changed from: private */
    public boolean mActive = false;
    /* access modifiers changed from: private */
    public AudioRecord mAudioInput = null;
    /* access modifiers changed from: private */
    public AudioTrack mAudioOutput = null;
    /* access modifiers changed from: private */
    public MicrophoneReceiver mBroadcastReceiver = null;
    /* access modifiers changed from: private */
    public Equalizer mEqualizer = null;
    /* access modifiers changed from: private */
    public int mInBufferSize = 0;
    private LoudnessEnhancer mLoudnessEnhancer = null;
    /* access modifiers changed from: private */
    public NotificationManager mNotificationManager = null;
    /* access modifiers changed from: private */
    public SharedPreferences mSharedPreferences = null;
    private Visualizer mVisualizer = null;
    int preCircleNo = 0;
    RemoteViews remoteView;
    int[] seekBarValues;

    private class MicrophoneReceiver extends BroadcastReceiver {
        private MicrophoneReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                SharedPreferences.Editor e = MicrophoneService.this.mSharedPreferences.edit();
                e.putBoolean("active", false);
                e.apply();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate() {
        Log.d("Microphone_EarSpy", "Creating mic service");
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mBroadcastReceiver = new MicrophoneReceiver();
        registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        this.remoteView = new RemoteViews(getApplicationContext().getPackageName(), C1206R.layout.widget_layout);
        this.compName = new ComponentName(this, WidgetProvider.class);
        this.appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
        this.mInBufferSize = AudioRecord.getMinBufferSize(mSampleRate, 16, 2);
        int mOutBufferSize = AudioTrack.getMinBufferSize(mSampleRate, 4, 2);
        if (this.mInBufferSize <= 0) {
            this.mInBufferSize = 8320;
        }
        this.mAudioInput = new AudioRecord(5, mSampleRate, 16, 2, this.mInBufferSize);
        this.mAudioOutput = new AudioTrack(3, mSampleRate, 4, 2, mOutBufferSize, 1);
        this.audioSessionId = this.mAudioOutput.getAudioSessionId();
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                this.mLoudnessEnhancer = new LoudnessEnhancer(this.audioSessionId);
                this.mLoudnessEnhancer.setTargetGain(100);
                this.mLoudnessEnhancer.setEnabled(true);
            } catch (Exception ex) {
                Log.d("Microphone_EarSpy", ex.getMessage());
            }
        }
        try {
            setupEqualizerFxAndUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            setupVisualizerFxAndUI();
            this.mVisualizer.setEnabled(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mActive = this.mSharedPreferences.getBoolean("active", false);
        if (this.mActive) {
            record();
        }
    }

    public void onDestroy() {
        Log.d("Microphone_EarSpy", "Stopping mic service");
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        e.putBoolean("active", false);
        e.apply();
        this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        if (this.mAudioOutput != null) {
            if (this.mAudioOutput.getState() == 1) {
                this.mAudioOutput.stop();
                this.mAudioOutput.release();
            }
            this.mAudioOutput = null;
        }
        if (this.mAudioInput != null) {
            try {
                this.mAudioInput.stop();
                this.mAudioInput.release();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            this.mAudioInput = null;
        }
        if (this.mLoudnessEnhancer != null) {
            try {
                this.mLoudnessEnhancer.setEnabled(false);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            this.mLoudnessEnhancer = null;
        }
        super.onDestroy();
        try {
            unregisterReceiver(this.mBroadcastReceiver);
        } catch (IllegalArgumentException e2) {
            Log.d("Microphone_EarSpy", "Unable to unregister");
        }
    }

    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("Microphone_EarSpy", "Service sent intent");
        if (intent != null && intent.getAction() != null) {
            Log.d("Microphone_EarSpy", "Action is  " + intent.getAction());
            if (intent.getAction().equals(getBaseContext().getPackageName() + ".STOP")) {
                Log.d("Microphone_EarSpy", "Cancelling recording via notification click");
                SharedPreferences.Editor e = this.mSharedPreferences.edit();
                e.putBoolean("active", false);
                e.apply();
                if (MicrophoneActivity.wavFileName != null) {
                    File file = new File(MicrophoneActivity.wavFileName);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                boolean IsResume = this.mSharedPreferences.getBoolean("Is_Activity_Resume", false);
                if (MicrophoneActivity.IsRecording || IsResume) {
                    Intent callIntent = new Intent("android.intent.action.CALL");
                    callIntent.setFlags(268435456);
                    callIntent.setClass(getApplicationContext(), MicrophoneActivity.class);
                    startActivity(callIntent);
                }
            }
        }
    }

    private void setupEqualizerFxAndUI() {
        boolean z;
        this.mEqualizer = new Equalizer(0, this.audioSessionId);
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
            try {
                mBassBoost = new BassBoost(0, this.audioSessionId);
                mVirtualizer = new Virtualizer(0, this.audioSessionId);
            } catch (Exception e) {
                System.out.println("Error..." + e);
            }
            int bass_vol = this.mSharedPreferences.getInt(Constant.PREF_BASS_VOL, 3);
            int vr_vol = this.mSharedPreferences.getInt(Constant.PREF_VR_VOL, 3);
            mBassBoost.setEnabled(bass_vol > 0);
            mBassBoost.setStrength((short) (bass_vol * 200));
            mVirtualizer.setEnabled(vr_vol > 0);
            mVirtualizer.setStrength((short) (vr_vol * 200));
            if (Build.VERSION.SDK_INT >= 16) {
                MicrophoneActivity.noiseSuppressor = NoiseSuppressor.create(this.mAudioInput.getAudioSessionId());
                MicrophoneActivity.automaticGainControl = AutomaticGainControl.create(this.mAudioInput.getAudioSessionId());
                MicrophoneActivity.acousticEchoCanceler = AcousticEchoCanceler.create(this.mAudioInput.getAudioSessionId());
                try {
                    if (MicrophoneActivity.noiseSuppressor != null) {
                        MicrophoneActivity.noiseSuppressor.setEnabled(this.mSharedPreferences.getBoolean(Constant.PREF_NS, true));
                    }
                    if (MicrophoneActivity.automaticGainControl != null) {
                        MicrophoneActivity.automaticGainControl.setEnabled(this.mSharedPreferences.getBoolean(Constant.PREF_AGC, true));
                    }
                    if (MicrophoneActivity.acousticEchoCanceler != null) {
                        AcousticEchoCanceler acousticEchoCanceler = MicrophoneActivity.acousticEchoCanceler;
                        if (this.mSharedPreferences.getBoolean(Constant.PREF_AEC, true)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        acousticEchoCanceler.setEnabled(z);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.mEqualizer.setEnabled(true);
        int bands = this.mEqualizer.getNumberOfBands();
        final short minEQLevel = this.mEqualizer.getBandLevelRange()[0];
        short maxEQLevel = this.mEqualizer.getBandLevelRange()[1];
        if (this.mSharedPreferences.getInt("maxEQLevel", -1) == -1) {
            SharedPreferences.Editor editor = this.mSharedPreferences.edit();
            editor.putInt("minEQLevel", minEQLevel);
            editor.putInt("maxEQLevel", maxEQLevel);
            editor.commit();
        }
        this.seekBarValues = new int[bands];
        short i = 0;
        while (i < bands) {
            short band = i;
            try {
                VerticalSeekBar bar = MicrophoneActivity.vSeekBar[i];
                bar.setMax(maxEQLevel - minEQLevel);
                this.seekBarValues[i] = this.mSharedPreferences.getInt("seekBarValues" + i, (maxEQLevel - minEQLevel) / 2);
                bar.setProgress(this.seekBarValues[i]);
                this.mEqualizer.setBandLevel(band, (short) (this.seekBarValues[i] + minEQLevel));
                bar.setTag(Short.valueOf(i));
                bar.setOnSeekBarChangeListener(new VerticalSeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(VerticalSeekBar seekBar, int progress, boolean fromUser) {
                        short sBand = ((Short) seekBar.getTag()).shortValue();
                        if (MicrophoneService.this.mActive) {
                            try {
                                MicrophoneService.this.mEqualizer.setBandLevel(sBand, (short) (minEQLevel + progress));
                                MicrophoneService.this.seekBarValues[sBand] = progress;
                            } catch (Exception e) {
                                System.out.println("error:onProgreeChanged-" + e.toString());
                            }
                        }
                    }

                    public void onStartTrackingTouch(VerticalSeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(VerticalSeekBar seekBar) {
                    }
                });
                i = (short) (i + 1);
            } catch (Exception e3) {
                System.out.println("error:VerticalSeekBar-" + e3.toString());
                return;
            }
        }
    }

    private void setupVisualizerFxAndUI() {
        this.mVisualizer = new Visualizer(this.mAudioOutput.getAudioSessionId());
        this.mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
        this.mVisualizer.setDataCaptureListener(new Visualizer.OnDataCaptureListener() {
            public void onWaveFormDataCapture(Visualizer visualizer, byte[] bytes, int samplingRate) {
                MicrophoneService.this.updateWidgetCircles();
                if (MicrophoneActivity.mVisualizerView != null) {
                    MicrophoneActivity.mVisualizerView.updateVisualizer(bytes);
                }
            }

            public void onFftDataCapture(Visualizer visualizer, byte[] bytes, int samplingRate) {
            }
        }, Visualizer.getMaxCaptureRate() / 2, true, false);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("active")) {
            boolean bActive = sharedPreferences.getBoolean("active", false);
            Log.d("Microphone_EarSpy", "Mic state changing (from " + this.mActive + " to " + bActive + ")");
            if (bActive != this.mActive) {
                this.mActive = bActive;
                if (this.mActive) {
                    record();
                } else if (this.mVisualizer != null) {
                    this.mVisualizer.setEnabled(false);
                }
                if (!this.mActive) {
                    this.mNotificationManager.cancel(0);
                    SharedPreferences.Editor editor = this.mSharedPreferences.edit();
                    if (MicrophoneActivity.vSeekBar != null) {
                        for (int k = 0; k < MicrophoneActivity.vSeekBar.length; k++) {
                            editor.putInt("seekBarValues" + k, MicrophoneActivity.vSeekBar[k].getProgress());
                        }
                        editor.apply();
                    }
                }
                updateWidgetCircles();
            }
        }
    }

    public void record() {
        new Thread() {
            public void run() {
                CharSequence titleText;
                Context context = MicrophoneService.this.getApplicationContext();
                if (!MicrophoneActivity.IsRecording) {
                    titleText = MicrophoneService.this.getString(C1206R.string.mic_active);
                } else {
                    titleText = MicrophoneService.this.getString(C1206R.string.mic_active_recording);
                }
                CharSequence statusText = MicrophoneService.this.getString(C1206R.string.cancel_mic);
                long when = System.currentTimeMillis();
                Intent cancelIntent = new Intent();
                cancelIntent.setAction(MicrophoneService.this.getBaseContext().getPackageName() + ".STOP");
                Log.d("Microphone_EarSpy", "Creating " + MicrophoneService.this.getBaseContext().getPackageName() + ".STOP");
                cancelIntent.setFlags(cancelIntent.getFlags() | 16);
                PendingIntent pendingCancelIntent = PendingIntent.getService(context, 0, cancelIntent, 0);
                Notification notification = new Notification(C1206R.C1207drawable.earspy_icon_small, titleText, when);
                notification.setLatestEventInfo(context, titleText, statusText, pendingCancelIntent);
                MicrophoneService.this.mNotificationManager.notify(0, notification);
                Log.d("Microphone_EarSpy", "Entered record loop");
                recordLoop();
                Log.d("Microphone_EarSpy", "Record loop finished");
            }

            /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A[Catch:{ Exception -> 0x01d3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x0187 A[Catch:{ Exception -> 0x011c }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void recordLoop() {
                /*
                    r14 = this;
                    r10 = 1
                    r13 = 0
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this
                    android.media.AudioTrack r9 = r9.mAudioOutput
                    if (r9 != 0) goto L_0x0026
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "No Audio Output"
                    android.util.Log.d(r9, r10)
                L_0x0011:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this
                    android.app.NotificationManager r9 = r9.mNotificationManager
                    r9.cancel(r13)
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ IllegalArgumentException -> 0x01dc }
                    com.microphone.earspy.MicrophoneService r10 = com.microphone.earspy.MicrophoneService.this     // Catch:{ IllegalArgumentException -> 0x01dc }
                    com.microphone.earspy.MicrophoneService$MicrophoneReceiver r10 = r10.mBroadcastReceiver     // Catch:{ IllegalArgumentException -> 0x01dc }
                    r9.unregisterReceiver(r10)     // Catch:{ IllegalArgumentException -> 0x01dc }
                L_0x0025:
                    return
                L_0x0026:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this
                    android.media.AudioRecord r9 = r9.mAudioInput
                    if (r9 != 0) goto L_0x0036
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "No Audio Input"
                    android.util.Log.d(r9, r10)
                    goto L_0x0011
                L_0x0036:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this
                    android.media.AudioTrack r9 = r9.mAudioOutput
                    int r9 = r9.getState()
                    if (r9 != r10) goto L_0x004e
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this
                    android.media.AudioRecord r9 = r9.mAudioInput
                    int r9 = r9.getState()
                    if (r9 == r10) goto L_0x0056
                L_0x004e:
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Can't start. Race condition?"
                    android.util.Log.d(r9, r10)
                    goto L_0x0011
                L_0x0056:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00df }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x00df }
                    r9.play()     // Catch:{ Exception -> 0x00df }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00f3 }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x00f3 }
                    r9.startRecording()     // Catch:{ Exception -> 0x00f3 }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r4 = r9.getTempFilename()     // Catch:{ Exception -> 0x00e9 }
                    r7 = 0
                    java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0106 }
                    r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0106 }
                L_0x0074:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x011c }
                    java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r9)     // Catch:{ Exception -> 0x011c }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x011c }
                    byte[] r0 = new byte[r9]     // Catch:{ Exception -> 0x011c }
                    boolean r9 = com.microphone.earspy.MicrophoneActivity.IsRecording     // Catch:{ Exception -> 0x011c }
                    if (r9 == 0) goto L_0x017f
                    if (r8 != 0) goto L_0x01fb
                    java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x010d }
                    r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x010d }
                L_0x0091:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x01d3 }
                    boolean r9 = r9.mActive     // Catch:{ Exception -> 0x01d3 }
                    if (r9 == 0) goto L_0x01ca
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x01d3 }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x01d3 }
                    com.microphone.earspy.MicrophoneService r10 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x01d3 }
                    int r10 = r10.mInBufferSize     // Catch:{ Exception -> 0x01d3 }
                    int r6 = r9.read(r1, r10)     // Catch:{ Exception -> 0x01d3 }
                    r1.get(r0)     // Catch:{ Exception -> 0x01d3 }
                    r1.rewind()     // Catch:{ Exception -> 0x01d3 }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x01d3 }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x01d3 }
                    r10 = 0
                    r9.write(r0, r10, r6)     // Catch:{ Exception -> 0x01d3 }
                    r9 = 0
                    r7.write(r0, r9, r6)     // Catch:{ Exception -> 0x01d3 }
                    r5 = 0
                L_0x00be:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x01d3 }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x01d3 }
                    int r9 = r9 / 2
                    if (r5 >= r9) goto L_0x0091
                    int r9 = r5 * 2
                    byte r9 = r0[r9]     // Catch:{ Exception -> 0x01d3 }
                    int r10 = r5 * 2
                    int r10 = r10 + 1
                    byte r10 = r0[r10]     // Catch:{ Exception -> 0x01d3 }
                    int r10 = r10 << 8
                    r9 = r9 | r10
                    short r2 = (short) r9     // Catch:{ Exception -> 0x01d3 }
                    short r9 = com.microphone.earspy.MicrophoneActivity.cAmplitude     // Catch:{ Exception -> 0x01d3 }
                    if (r2 <= r9) goto L_0x00dc
                    com.microphone.earspy.MicrophoneActivity.cAmplitude = r2     // Catch:{ Exception -> 0x01d3 }
                L_0x00dc:
                    int r5 = r5 + 1
                    goto L_0x00be
                L_0x00df:
                    r3 = move-exception
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Failed to start playback"
                    android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x00e9 }
                    goto L_0x0025
                L_0x00e9:
                    r3 = move-exception
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Error somewhere in record loop."
                    android.util.Log.d(r9, r10)
                    goto L_0x0011
                L_0x00f3:
                    r3 = move-exception
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Failed to start recording"
                    android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x00e9 }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00e9 }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x00e9 }
                    r9.stop()     // Catch:{ Exception -> 0x00e9 }
                    goto L_0x0025
                L_0x0106:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x00e9 }
                    r8 = r7
                    goto L_0x0074
                L_0x010d:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x011c }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x011c }
                    r9.stop()     // Catch:{ Exception -> 0x011c }
                    goto L_0x0025
                L_0x011c:
                    r3 = move-exception
                    r7 = r8
                L_0x011e:
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Error while recording, aborting."
                    android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x00e9 }
                L_0x0125:
                    r7.close()     // Catch:{ Exception -> 0x01d6 }
                L_0x0128:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x0146 }
                    com.microphone.earspy.MicrophoneService r10 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x0146 }
                    java.lang.String r10 = r10.getTempFilename()     // Catch:{ Exception -> 0x0146 }
                    com.microphone.earspy.MicrophoneService r11 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x0146 }
                    android.content.SharedPreferences r11 = r11.mSharedPreferences     // Catch:{ Exception -> 0x0146 }
                    java.lang.String r12 = "wav_filename"
                    java.lang.String r11 = r11.getString(r12, r4)     // Catch:{ Exception -> 0x0146 }
                    r9.copyWaveFile(r10, r11)     // Catch:{ Exception -> 0x0146 }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x0146 }
                    r9.deleteTempFile()     // Catch:{ Exception -> 0x0146 }
                    goto L_0x0011
                L_0x0146:
                    r3 = move-exception
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
                    r10.<init>()     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r11 = "Can't stop playback"
                    java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x00e9 }
                    java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00e9 }
                    android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x00e9 }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00e9 }
                    com.microphone.earspy.MicrophoneService r10 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r10 = r10.getTempFilename()     // Catch:{ Exception -> 0x00e9 }
                    com.microphone.earspy.MicrophoneService r11 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x00e9 }
                    android.content.SharedPreferences r11 = r11.mSharedPreferences     // Catch:{ Exception -> 0x00e9 }
                    java.lang.String r12 = "wav_filename"
                    java.lang.String r11 = r11.getString(r12, r4)     // Catch:{ Exception -> 0x00e9 }
                    r9.copyWaveFile(r10, r11)     // Catch:{ Exception -> 0x00e9 }
                    r7.close()     // Catch:{ Exception -> 0x00e9 }
                    goto L_0x0011
                L_0x017f:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    boolean r9 = r9.mActive     // Catch:{ Exception -> 0x011c }
                    if (r9 == 0) goto L_0x01c9
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x011c }
                    com.microphone.earspy.MicrophoneService r10 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    int r10 = r10.mInBufferSize     // Catch:{ Exception -> 0x011c }
                    int r6 = r9.read(r1, r10)     // Catch:{ Exception -> 0x011c }
                    r1.get(r0)     // Catch:{ Exception -> 0x011c }
                    r1.rewind()     // Catch:{ Exception -> 0x011c }
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x011c }
                    r10 = 0
                    r9.write(r0, r10, r6)     // Catch:{ Exception -> 0x011c }
                    r5 = 0
                L_0x01a8:
                    com.microphone.earspy.MicrophoneService r9 = com.microphone.earspy.MicrophoneService.this     // Catch:{ Exception -> 0x011c }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x011c }
                    int r9 = r9 / 2
                    if (r5 >= r9) goto L_0x017f
                    int r9 = r5 * 2
                    byte r9 = r0[r9]     // Catch:{ Exception -> 0x011c }
                    int r10 = r5 * 2
                    int r10 = r10 + 1
                    byte r10 = r0[r10]     // Catch:{ Exception -> 0x011c }
                    int r10 = r10 << 8
                    r9 = r9 | r10
                    short r2 = (short) r9     // Catch:{ Exception -> 0x011c }
                    short r9 = com.microphone.earspy.MicrophoneActivity.cAmplitude     // Catch:{ Exception -> 0x011c }
                    if (r2 <= r9) goto L_0x01c6
                    com.microphone.earspy.MicrophoneActivity.cAmplitude = r2     // Catch:{ Exception -> 0x011c }
                L_0x01c6:
                    int r5 = r5 + 1
                    goto L_0x01a8
                L_0x01c9:
                    r7 = r8
                L_0x01ca:
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.String r10 = "Finished recording"
                    android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x01d3 }
                    goto L_0x0125
                L_0x01d3:
                    r3 = move-exception
                    goto L_0x011e
                L_0x01d6:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x00e9 }
                    goto L_0x0128
                L_0x01dc:
                    r3 = move-exception
                    java.lang.String r9 = "Microphone_EarSpy"
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r11 = "Receiver wasn't registered: "
                    java.lang.StringBuilder r10 = r10.append(r11)
                    java.lang.String r11 = r3.toString()
                    java.lang.StringBuilder r10 = r10.append(r11)
                    java.lang.String r10 = r10.toString()
                    android.util.Log.e(r9, r10)
                    goto L_0x0025
                L_0x01fb:
                    r7 = r8
                    goto L_0x0091
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microphone.earspy.MicrophoneService.C11933.recordLoop():void");
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void deleteTempFile() {
        new File(getTempFilename()).delete();
    }

    /* access modifiers changed from: private */
    public void updateWidgetCircles() {
        this.curCircleNo = 0;
        if (MicrophoneActivity.cAmplitude > VisualizerView.AMPLITUDE_CIRCLE_TWO) {
            this.curCircleNo = 1;
        } else if (MicrophoneActivity.cAmplitude > VisualizerView.AMPLITUDE_CIRCLE_THREE) {
            this.curCircleNo = 2;
        } else if (MicrophoneActivity.cAmplitude > VisualizerView.AMPLITUDE_CIRCLE_FOUR) {
            this.curCircleNo = 3;
        } else {
            this.curCircleNo = 4;
        }
        MicrophoneActivity.cAmplitude = 0;
        RemoteViews remoteView2 = new RemoteViews(getApplicationContext().getPackageName(), C1206R.layout.widget_layout);
        ComponentName compName2 = new ComponentName(this, WidgetProvider.class);
        AppWidgetManager appWidgetMngr = AppWidgetManager.getInstance(getApplicationContext());
        if (MicrophoneActivity.IsActive) {
            if (this.preCircleNo != this.curCircleNo) {
                remoteView2.setImageViewResource(this.idsWidgetBtn[this.curCircleNo - 1], this.drawIdsHighlighted[this.curCircleNo - 1]);
                if (this.preCircleNo > 0) {
                    remoteView2.setImageViewResource(this.idsWidgetBtn[this.preCircleNo - 1], this.drawIdsNormal[this.preCircleNo - 1]);
                }
            }
            this.preCircleNo = this.curCircleNo;
        }
        try {
            appWidgetMngr.updateAppWidget(compName2, remoteView2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public String getTempFilename() {
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "EAR SPY");
        if (!file.exists()) {
            file.mkdirs();
        }
        File tempFile = new File(filepath, AUDIO_RECORDER_TEMP_FILE);
        if (tempFile.exists()) {
            tempFile.delete();
        }
        return file.getAbsolutePath() + "/" + AUDIO_RECORDER_TEMP_FILE;
    }

    /* access modifiers changed from: private */
    public void copyWaveFile(String inFilename, String outFilename) {
        long j = 0 + 44;
        long byteRate = (long) 176400;
        byte[] data = new byte[this.mInBufferSize];
        try {
            FileInputStream fileInputStream = new FileInputStream(inFilename);
            FileOutputStream out = new FileOutputStream(outFilename);
            long totalAudioLen = fileInputStream.getChannel().size();
            long totalDataLen = totalAudioLen + 44;
            if (totalDataLen < 100) {
                File file = new File(outFilename);
                if (file.exists()) {
                    file.delete();
                }
            }
            WriteWaveFileHeader(out, totalAudioLen, totalDataLen, 44100, 2, byteRate);
            while (fileInputStream.read(data) != -1) {
                out.write(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        MicrophoneActivity.wavFileName = outFilename;
    }

    private void WriteWaveFileHeader(FileOutputStream out, long totalAudioLen, long totalDataLen, long longSampleRate, int channels, long byteRate) throws IOException {
        out.write(new byte[]{82, 73, 70, 70, (byte) ((int) (255 & totalDataLen)), (byte) ((int) ((totalDataLen >> 8) & 255)), (byte) ((int) ((totalDataLen >> 16) & 255)), (byte) ((int) ((totalDataLen >> 24) & 255)), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) channels, 0, (byte) ((int) (255 & longSampleRate)), (byte) ((int) ((longSampleRate >> 8) & 255)), (byte) ((int) ((longSampleRate >> 16) & 255)), (byte) ((int) ((longSampleRate >> 24) & 255)), (byte) ((int) (255 & byteRate)), (byte) ((int) ((byteRate >> 8) & 255)), (byte) ((int) ((byteRate >> 16) & 255)), (byte) ((int) ((byteRate >> 24) & 255)), 4, 0, 16, 0, 100, 97, 116, 97, (byte) ((int) (255 & totalAudioLen)), (byte) ((int) ((totalAudioLen >> 8) & 255)), (byte) ((int) ((totalAudioLen >> 16) & 255)), (byte) ((int) ((totalAudioLen >> 24) & 255))}, 0, 44);
    }
}
