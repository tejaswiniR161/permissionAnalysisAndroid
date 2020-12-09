package com.microphone.earspy.inappbilling;

import android.content.Context;
import android.widget.Toast;

public class Toaster {
    private final Context context;

    public Toaster(Context context2) {
        this.context = context2;
    }

    public void popBurntToast(String msg) {
        makeToast(msg, 1).show();
    }

    public void popToast(String msg) {
        makeToast(msg, 0).show();
    }

    private Toast makeToast(String msg, int length) {
        return Toast.makeText(this.context, msg, length);
    }
}
