package com.microphone.earspy;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class About_Us extends Activity {
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    private static final String URL = "https://market.android.com/details?id=com.microphone.earspy";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.about_us);
        try {
            ((TextView) findViewById(C1206R.C1208id.version_number)).setText("Version " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ((TextView) findViewById(C1206R.C1208id.link)).setText("www.overpass.co.uk");
        ((TextView) findViewById(C1206R.C1208id.credits)).setText(String.format(getResources().getString(C1206R.string.credits_detail), new Object[]{"Eric Wroolie", "Bhargav Modi(SP Technolab)"}));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }
}
