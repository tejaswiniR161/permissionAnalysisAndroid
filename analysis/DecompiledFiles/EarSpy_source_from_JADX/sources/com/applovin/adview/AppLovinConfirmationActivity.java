package com.applovin.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

public class AppLovinConfirmationActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        builder.setTitle(intent.getStringExtra("dialog_title"));
        builder.setMessage(intent.getStringExtra("dialog_body"));
        builder.setCancelable(false);
        builder.setPositiveButton(intent.getStringExtra("dialog_button_text"), new C0233a(this));
        builder.show();
    }
}
