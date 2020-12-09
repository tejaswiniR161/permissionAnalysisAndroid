package com.microphone.earspy.widget;

import android.annotation.SuppressLint;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import com.microphone.earspy.C1206R;
import com.microphone.earspy.MicrophoneActivity;
import com.microphone.earspy.MicrophoneService;

public class WidgetService extends Service implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String APP_TAG = "Microphone_EarSpy";
    public static final String TAG = "APP_WIDGET";
    public static long refTimeMS;
    private BackgroundThread background;
    Context context = this;
    SharedPreferences.Editor editor;
    /* access modifiers changed from: private */
    public boolean mActive = false;
    private final BroadcastReceiver mBluetoothHeadsetBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") && intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 0) {
                WidgetService.this.stopApp();
            }
        }
    };
    /* access modifiers changed from: private */
    public SharedPreferences mSharedPreferences = null;
    private final BroadcastReceiver mWiredHeadsetBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean isConnected = true;
            if (intent.getIntExtra("state", 0) != 1) {
                isConnected = false;
            }
            if (!isConnected && WidgetService.this.mActive) {
                WidgetService.this.stopApp();
            }
        }
    };
    public Intent savedIntent;

    public void onCreate() {
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.mActive = this.mSharedPreferences.getBoolean("active", false);
        super.onCreate();
        chkIfHeadphonesConnected();
    }

    @SuppressLint({"InlinedApi"})
    private void chkIfHeadphonesConnected() {
        if (Build.VERSION.SDK_INT >= 11) {
            registerReceiver(this.mBluetoothHeadsetBroadcastReceiver, new IntentFilter("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"));
        }
        registerReceiver(this.mWiredHeadsetBroadcastReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    /* access modifiers changed from: private */
    public void stopApp() {
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        e.putBoolean("active", !this.mActive);
        e.commit();
        stopSelf();
    }

    public void onDestroy() {
        unregisterReceiver(this.mWiredHeadsetBroadcastReceiver);
        if (Build.VERSION.SDK_INT >= 11) {
            unregisterReceiver(this.mBluetoothHeadsetBroadcastReceiver);
        }
        super.onDestroy();
        this.background.interrupt();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.i("APP_WIDGET", "Starting the App Widget update service");
        this.savedIntent = intent;
        doThreadStart();
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void doThreadStart() {
        this.background = new BackgroundThread();
        this.background.start();
    }

    private class BackgroundThread extends Thread {
        private BackgroundThread() {
        }

        public void run() {
            boolean z = false;
            Log.i("APP_WIDGET", "  Begin background thread");
            boolean unused = WidgetService.this.mActive = WidgetService.this.mSharedPreferences.getBoolean("active", false);
            SharedPreferences.Editor e = WidgetService.this.mSharedPreferences.edit();
            if (!WidgetService.this.mActive) {
                z = true;
            }
            e.putBoolean("active", z);
            e.commit();
            WidgetService.this.stopSelf();
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        boolean bActive;
        if (key.equals("active") && (bActive = sharedPreferences.getBoolean("active", false)) != this.mActive) {
            if (bActive) {
                startService(new Intent(this, MicrophoneService.class));
                MicrophoneActivity.IsActive = true;
            } else if (MicrophoneActivity.IsRecording) {
                Intent callIntent = new Intent("android.intent.action.CALL");
                callIntent.setFlags(268435456);
                callIntent.setClass(getApplicationContext(), MicrophoneActivity.class);
                startActivity(callIntent);
            } else {
                stopService(new Intent(this, MicrophoneService.class));
                MicrophoneActivity.IsActive = false;
            }
            this.mActive = bActive;
            updateWidgetCenterCircle();
        }
    }

    private void updateWidgetCenterCircle() {
        RemoteViews remoteView = new RemoteViews(getApplicationContext().getPackageName(), C1206R.layout.widget_layout);
        remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView5, this.mActive ? C1206R.C1207drawable.widget_black_5 : C1206R.C1207drawable.widget_red_5);
        if (!this.mActive) {
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView1, C1206R.C1207drawable.widget_black_1);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView2, C1206R.C1207drawable.widget_black_2);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView3, C1206R.C1207drawable.widget_black_3);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView4, C1206R.C1207drawable.widget_black_4);
        }
        AppWidgetManager.getInstance(getApplicationContext()).updateAppWidget(new ComponentName(this, WidgetProvider.class), remoteView);
    }
}
