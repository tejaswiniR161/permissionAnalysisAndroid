package com.microphone.earspy.inappbilling;

import android.app.Activity;
import android.content.Intent;
import com.microphone.earspy.InAppPurchaseActivity;
import com.microphone.earspy.MicrophoneActivity;

public class Navigator {
    public static final int REQUEST_PASSPORT_PURCHASE = 2012;
    private final Activity activity;

    public Navigator(Activity activity2) {
        this.activity = activity2;
    }

    public void toMainActivity() {
        this.activity.startActivity(new Intent(this.activity, MicrophoneActivity.class));
    }

    public void toPurchasePassportActivityForResult() {
        this.activity.startActivityForResult(new Intent(this.activity, InAppPurchaseActivity.class), REQUEST_PASSPORT_PURCHASE);
    }
}
