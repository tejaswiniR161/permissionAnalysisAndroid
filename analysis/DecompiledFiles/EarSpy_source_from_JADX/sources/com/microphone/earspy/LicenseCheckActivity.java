package com.microphone.earspy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;
import com.microphone.earspy.constant.Constant;

public class LicenseCheckActivity extends Activity {
    private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApTph6bKy+zS7GmN4feVAQJK4v0EmfbjuRmmUkvVGz79N/LcpRzednni49KpmdMQYQQJdNzwVL4vDoGO9pF7p2FW04/mZ1afiW2rwmQAyyM2E21QnvtZLa1d9fF1tU1r3XFcgWduXJvaLt+7wotTBPbcYLtw1yeu1P+EuenODfAcQY8AERyHEyNR4C2y2tNEZyRh6ME9MLR5PHkW6RdLvOrR0mxdV+jncoL6WVQ+CefxPhtTlAPpHzvHTCisW8k6ZwEb/9bBvvCnI4f6DYDQX815k+lgbMrmnoljDtZS1l4Xm8MiE6LNJhv/Mhd7Yi0uH5NCZYTDUcMn7JZkRiUlPKQIDAQAB";
    private static final byte[] SALT = {12, 54, 75, 114, 3, 22, 116, 125, -122, 119, 5, 31, 114, 109, -84, 18, 78, 26, 108, 43};
    private LicenseChecker mChecker;
    private Handler mHandler;
    private LicenseCheckerCallback mLicenseCheckerCallback;
    /* access modifiers changed from: private */
    public ProgressDialog pDialog = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(5);
        this.pDialog = new ProgressDialog(this);
        this.pDialog.setMessage(getResources().getString(C1206R.string.application_varifying));
        this.pDialog.show();
        this.mHandler = new Handler();
        String deviceId = Settings.Secure.getString(getContentResolver(), "android_id");
        this.mLicenseCheckerCallback = new MyLicenseCheckerCallback();
        this.mChecker = new LicenseChecker(this, new ServerManagedPolicy(this, new AESObfuscator(SALT, getPackageName(), deviceId)), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApTph6bKy+zS7GmN4feVAQJK4v0EmfbjuRmmUkvVGz79N/LcpRzednni49KpmdMQYQQJdNzwVL4vDoGO9pF7p2FW04/mZ1afiW2rwmQAyyM2E21QnvtZLa1d9fF1tU1r3XFcgWduXJvaLt+7wotTBPbcYLtw1yeu1P+EuenODfAcQY8AERyHEyNR4C2y2tNEZyRh6ME9MLR5PHkW6RdLvOrR0mxdV+jncoL6WVQ+CefxPhtTlAPpHzvHTCisW8k6ZwEb/9bBvvCnI4f6DYDQX815k+lgbMrmnoljDtZS1l4Xm8MiE6LNJhv/Mhd7Yi0uH5NCZYTDUcMn7JZkRiUlPKQIDAQAB");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        doCheck();
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int id) {
        final boolean bRetry = true;
        if (id != 1) {
            bRetry = false;
        }
        return new AlertDialog.Builder(this).setTitle(C1206R.string.unlicensed_dialog_title).setMessage(bRetry ? C1206R.string.unlicensed_dialog_retry_body : C1206R.string.unlicensed_dialog_body).setPositiveButton(bRetry ? C1206R.string.retry_button : C1206R.string.buy_button, new DialogInterface.OnClickListener() {
            boolean mRetry = bRetry;

            public void onClick(DialogInterface dialog, int which) {
                if (this.mRetry) {
                    LicenseCheckActivity.this.doCheck();
                    return;
                }
                LicenseCheckActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/details?id=" + LicenseCheckActivity.this.getPackageName())));
                LicenseCheckActivity.this.finish();
            }
        }).setNegativeButton(C1206R.string.quit_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                LicenseCheckActivity.this.finish();
            }
        }).create();
    }

    /* access modifiers changed from: private */
    public void doCheck() {
        setProgressBarIndeterminateVisibility(true);
        this.mChecker.checkAccess(this.mLicenseCheckerCallback);
    }

    /* access modifiers changed from: private */
    public void displayDialog(final boolean showRetry) {
        this.mHandler.post(new Runnable() {
            public void run() {
                int i = 0;
                LicenseCheckActivity.this.setProgressBarIndeterminateVisibility(false);
                LicenseCheckActivity.this.pDialog.cancel();
                LicenseCheckActivity licenseCheckActivity = LicenseCheckActivity.this;
                if (showRetry) {
                    i = 1;
                }
                licenseCheckActivity.showDialog(i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void allowAccess() {
        this.mHandler.post(new Runnable() {
            public void run() {
                SharedPreferences.Editor editor = LicenseCheckActivity.this.getSharedPreferences("Microphone_EarSpy", 0).edit();
                editor.putBoolean(Constant.PREF_VALID_LICENSE, true);
                editor.commit();
                LicenseCheckActivity.this.moveToMainScreen();
            }
        });
    }

    /* access modifiers changed from: private */
    public void moveToMainScreen() {
        startActivity(new Intent(this, MicrophoneActivity.class));
        finish();
    }

    private class MyLicenseCheckerCallback implements LicenseCheckerCallback {
        private MyLicenseCheckerCallback() {
        }

        public void allow(int policyReason) {
            if (!LicenseCheckActivity.this.isFinishing()) {
                LicenseCheckActivity.this.allowAccess();
            }
        }

        public void dontAllow(int policyReason) {
            if (!LicenseCheckActivity.this.isFinishing()) {
                LicenseCheckActivity.this.displayDialog(policyReason == 291);
            }
        }

        public void applicationError(int errorCode) {
            if (!LicenseCheckActivity.this.isFinishing()) {
                Toast.makeText(LicenseCheckActivity.this.getApplicationContext(), String.format(LicenseCheckActivity.this.getString(C1206R.string.application_error), new Object[]{Integer.valueOf(errorCode)}), 0).show();
                LicenseCheckActivity.this.displayDialog(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mChecker.onDestroy();
    }
}
