package com.microphone.earspy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.internal.view.SupportMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.microphone.earspy.constant.Constant;
import com.samsung.zirconia.LicenseCheckListener;
import com.samsung.zirconia.Zirconia;

public class SamsungLicenseCheckActivity extends Activity implements LicenseCheckListener {
    private static final boolean DEV_MODE = false;
    private static final int DIALOG_TYPE_DOUBLE = 1;
    private static final int DIALOG_TYPE_SINGLE = 0;
    private static final int DIALOG_TYPE_TRIPLE = 2;
    private Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public TextView mResponse;
    /* access modifiers changed from: private */
    public TextView mStatus;
    /* access modifiers changed from: private */
    public Zirconia mZirconia;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.samsung_license_verification);
        this.mResponse = (TextView) findViewById(C1206R.C1208id.responseText);
        this.mStatus = (TextView) findViewById(C1206R.C1208id.statusText);
        this.mZirconia = new Zirconia(this);
        this.mZirconia.setLicenseCheckListener(this);
        startCheck();
    }

    /* access modifiers changed from: private */
    public void startCheck() {
        this.mResponse.setText("");
        this.mResponse.setTextColor(-1);
        this.mStatus.setText("");
        this.mZirconia.checkLicense(false, false);
    }

    public void licenseCheckedAsInvalid() {
        this.mHandler.post(new Runnable() {
            public void run() {
                SamsungLicenseCheckActivity.this.mStatus.setText("");
                SamsungLicenseCheckActivity.this.mResponse.setText(C1206R.string.fail);
                SamsungLicenseCheckActivity.this.mResponse.setTextColor(SupportMenu.CATEGORY_MASK);
                try {
                    SamsungLicenseCheckActivity.this.showDialog(SamsungLicenseCheckActivity.this.mZirconia.getError());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void licenseCheckedAsValid() {
        this.mHandler.post(new Runnable() {
            public void run() {
                SharedPreferences.Editor editor = SamsungLicenseCheckActivity.this.getSharedPreferences("Microphone_EarSpy", 0).edit();
                editor.putBoolean(Constant.PREF_VALID_LICENSE, true);
                editor.commit();
                SamsungLicenseCheckActivity.this.mResponse.setText(C1206R.string.success);
                SamsungLicenseCheckActivity.this.mResponse.setTextColor(-16711936);
            }
        });
        startActivity(new Intent(this, MicrophoneActivity.class));
    }

    private Dialog setupDialog(int type, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        switch (type) {
            case 0:
                builder.setPositiveButton(C1206R.string.f2338ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.finish();
                    }
                });
                return builder.create();
            case 1:
                builder.setPositiveButton(C1206R.string.retry_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.startCheck();
                    }
                });
                builder.setNegativeButton(C1206R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.finish();
                    }
                });
                return builder.create();
            case 2:
                builder.setPositiveButton(C1206R.string.settings, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    }
                });
                builder.setNeutralButton(C1206R.string.retry_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.startCheck();
                    }
                });
                builder.setNegativeButton(C1206R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.finish();
                    }
                });
                return builder.create();
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int id) {
        switch (id) {
            case 11:
                return setupDialog(0, getString(C1206R.string.unlicensed_dialog_title), getString(C1206R.string.samsung_unlicensed_dialog_body));
            case 21:
                return setupDialog(0, getString(C1206R.string.error), getString(C1206R.string.cannot_check));
            case 22:
                return setupDialog(0, getString(C1206R.string.error), getString(C1206R.string.cannot_check));
            case 23:
                return setupDialog(1, getString(C1206R.string.invalid_value), getString(C1206R.string.invalid_value_text));
            case 31:
                return setupDialog(0, getString(C1206R.string.error), getString(C1206R.string.cannot_check));
            case 50:
                return setupDialog(0, getString(C1206R.string.error), getString(C1206R.string.cannot_check));
            case 61:
                return setupDialog(2, getString(C1206R.string.unlicensed_dialog_title), getString(C1206R.string.samsung_unlicensed_dialog_retry_body));
            case 62:
                return setupDialog(2, getString(C1206R.string.unlicensed_dialog_title), getString(C1206R.string.samsung_unlicensed_dialog_retry_body));
            case 71:
                return setupDialog(0, getString(C1206R.string.error), getString(C1206R.string.cannot_check));
            case 81:
                return setupDialog(1, getString(C1206R.string.key_creation), getString(C1206R.string.key_creation_text));
            case 82:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(C1206R.string.app_modified_text)).setTitle(getString(C1206R.string.app_modified)).setPositiveButton(getString(C1206R.string.retry_button), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SamsungLicenseCheckActivity.this.startCheck();
                    }
                }).setNeutralButton(getString(C1206R.string.license_delete), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SamsungLicenseCheckActivity.this.mZirconia.deleteLicense();
                        Toast.makeText(SamsungLicenseCheckActivity.this.getApplicationContext(), SamsungLicenseCheckActivity.this.getString(C1206R.string.license_deleted_re), 0).show();
                        SamsungLicenseCheckActivity.this.startCheck();
                    }
                }).setNegativeButton(getString(C1206R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SamsungLicenseCheckActivity.this.finish();
                    }
                });
                return builder.create();
            default:
                return null;
        }
    }
}
