package com.microphone.earspy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioTrack;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.android.vending.billing.util.IabHelper;
import com.android.vending.billing.util.IabResult;
import com.facebook.ads.AdError;
import com.microphone.earspy.inappbilling.Log;
import com.microphone.earspy.inappbilling.PurchaseActivity;
import java.util.Random;

public class SplashScreen extends PurchaseActivity implements IabHelper.OnIabSetupFinishedListener {
    static final String APP_TAG = "Microphone_EarSpy";
    private static final String NO_EQUALIZERS = "No_Equalizers";
    private static final int SPLASH_DURATION = 3000;
    private static final boolean isLicenseVerifyingEnabled = false;
    private static final boolean licenseCheckForGooglePlayStore = false;
    private static final int mFormat = 2;
    private static final int mSampleRate = 44100;
    private boolean mIsBackButtonPressed = false;
    private SharedPreferences mSharedPreferences = null;
    private String[] taglines;

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.splash_screen);
        this.taglines = getResources().getStringArray(C1206R.array.taglines);
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        int random = new Random().nextInt() % 5;
        if (random < 0) {
            random *= -1;
        }
        try {
            ((TextView) findViewById(C1206R.C1208id.tagline)).setText(this.taglines[random]);
        } catch (Exception e) {
        }
        ((TextView) findViewById(C1206R.C1208id.link)).setText("www.overpass.co.uk");
        if (!this.mSharedPreferences.contains(NO_EQUALIZERS)) {
            try {
                Equalizer equalizer = new Equalizer(0, new AudioTrack(3, mSampleRate, 4, 2, AudioTrack.getMinBufferSize(mSampleRate, 4, 2), 1).getAudioSessionId());
                SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
                mEditor.putInt(NO_EQUALIZERS, equalizer.getNumberOfBands());
                for (short i = 0; i < equalizer.getNumberOfBands(); i = (short) (i + 1)) {
                    int freq = equalizer.getCenterFreq(i) / AdError.NETWORK_ERROR_CODE;
                    mEditor.putInt("freq" + i, freq);
                }
                mEditor.commit();
                EasyTracker.getInstance().activityStart(this);
                EasyTracker.getTracker().trackEvent("Equalizer", " Number of Equalizer:" + equalizer.getNumberOfBands(), " Number of Equalizer", 200);
                EasyTracker.getTracker().sendEvent("Equalizer", " Number of Equalizer:" + equalizer.getNumberOfBands(), " Number of Equalizer", 200);
                EasyTracker.getInstance().activityStop(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashScreen.this.moveToNextScreen();
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    public void moveToNextScreen() {
        if (!this.mIsBackButtonPressed) {
            startMainScreen();
            finish();
        }
    }

    private void startMainScreen() {
        startActivity(new Intent(this, MicrophoneActivity.class));
    }

    private void startLicenseCheckScreen() {
        startActivity(new Intent(this, LicenseCheckActivity.class));
    }

    private void startSamsungLicenseCheckScreen() {
        startActivity(new Intent(this, SamsungLicenseCheckActivity.class));
    }

    public void onBackPressed() {
        this.mIsBackButtonPressed = true;
        super.onBackPressed();
    }

    public void onDestroy() {
        Log.m1505d("splash destroyed");
        super.onDestroy();
    }

    public void onIabSetupFinished(IabResult result) {
        if (result.isSuccess()) {
            Log.m1505d("In-app Billing set up splash" + result);
            dealWithIabSetupSuccess();
            updateInventory();
            return;
        }
        Log.m1505d("Problem setting up In-app Billing: " + result);
        dealWithIabSetupFailure();
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupSuccess() {
        try {
            restoreItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupFailure() {
        try {
            popBurntToast("Sorry In App Billing isn't available on your device");
        } catch (Exception e) {
        }
    }
}
