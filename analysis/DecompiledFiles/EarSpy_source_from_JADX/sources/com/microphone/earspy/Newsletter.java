package com.microphone.earspy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.microphone.earspy.constant.Constant;
import com.microphone.earspy.inappbilling.Passport;
import java.util.ArrayList;
import java.util.Random;

public class Newsletter extends Activity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public Context context = null;
    /* access modifiers changed from: private */
    public EditText emailEditText = null;
    private String[] feature_description = null;
    private int feature_index = 0;
    private String[] feature_title;
    private SharedPreferences mSharedPreferences = null;
    /* access modifiers changed from: private */
    public EditText nameEditText = null;
    private Button subscribeButton = null;
    private Button unlockButton = null;
    private EditText unlockEditText = null;

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.our_newsletter);
        getWindow().setSoftInputMode(3);
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        fillupArray();
        setFeatureInfo();
        this.subscribeButton = (Button) findViewById(C1206R.C1208id.btnSubscibe);
        this.unlockButton = (Button) findViewById(C1206R.C1208id.btnUnlock);
        this.subscribeButton.setOnClickListener(this);
        this.unlockButton.setOnClickListener(this);
        this.nameEditText = (EditText) findViewById(C1206R.C1208id.name_editText);
        this.emailEditText = (EditText) findViewById(C1206R.C1208id.email_editText);
        this.unlockEditText = (EditText) findViewById(C1206R.C1208id.code);
        this.context = this;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C1206R.C1208id.btnSubscibe /*2131361984*/:
                if (!checkValidityForEmail() || !checkValidityForName()) {
                    Toast.makeText(getApplicationContext(), getResources().getString(C1206R.string.validation_msg), 0).show();
                    return;
                }
                final ProgressDialog progressDialog = ProgressDialog.show(this.context, getResources().getText(C1206R.string.newsletter_dialog_title), getResources().getText(C1206R.string.newsletter_dialog_detail), true, false);
                new Thread(new Runnable() {
                    public void run() {
                        Newsletter.this.addToList(Newsletter.this.emailEditText.getText().toString(), Newsletter.this.nameEditText.getText().toString(), progressDialog);
                    }
                }).start();
                return;
            case C1206R.C1208id.btnUnlock /*2131361986*/:
                if (checkValidityForUnlockCode()) {
                    String featureName = makeFeatureUnlock();
                    EasyTracker.getTracker().trackEvent("Unlock Feature", " Feature unlocked", featureName, 200);
                    EasyTracker.getTracker().sendEvent("Unlock Feature", " Feature unlocked", featureName, 200);
                    this.unlockEditText.setText("");
                    if (featureName != null) {
                        Toast.makeText(getApplicationContext(), "Feature Unlocked: " + featureName, 1).show();
                        return;
                    }
                    return;
                }
                Toast.makeText(getApplicationContext(), getResources().getString(C1206R.string.validation_msg), 0).show();
                return;
            default:
                return;
        }
    }

    private boolean checkValidityForName() {
        if (this.nameEditText.getText().toString().trim().length() < 3) {
            return false;
        }
        return true;
    }

    private boolean checkValidityForEmail() {
        if (!this.emailEditText.getText().toString().contains("@") || !this.emailEditText.getText().toString().contains(".")) {
            return false;
        }
        return true;
    }

    private boolean checkValidityForUnlockCode() {
        if (this.unlockEditText.getText().toString().trim().length() < 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void addToList(String emailAddy, String name, ProgressDialog progressDialog) {
    }

    private void showResult(final String message) {
        runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(Newsletter.this.context);
                builder.setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }

    private void fillupArray() {
        this.feature_title = new String[4];
        this.feature_description = new String[4];
        Resources res = getResources();
        this.feature_title[0] = res.getString(C1206R.string.extended_equalizer);
        String[] strArr = this.feature_description;
        String string = getResources().getString(C1206R.string.extended_equalizer_description);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSharedPreferences.getInt("No_Equalizers", 5));
        objArr[1] = Build.VERSION.SDK_INT >= 16 ? " , AcousticEchoCanceler, AutomaticGainControl, NoiseSuppressor" : "";
        strArr[0] = String.format(string, objArr);
        this.feature_title[1] = res.getString(C1206R.string.home_screen_widget);
        this.feature_description[1] = res.getString(C1206R.string.home_screen_widget_description);
        this.feature_title[2] = res.getString(C1206R.string.mp3_recording);
        this.feature_description[2] = res.getString(C1206R.string.mp3_recording_description);
        this.feature_title[3] = res.getString(C1206R.string.remove_ads);
        this.feature_description[3] = res.getString(C1206R.string.remove_ads_description);
    }

    private void setFeatureInfo() {
        ArrayList<Integer> arrList = new ArrayList<>();
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
            arrList.add(0);
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", false)) {
            arrList.add(1);
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
            arrList.add(2);
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_REMOVE_ADS + "3", false)) {
            arrList.add(3);
        }
        try {
            this.feature_index = arrList.get(new Random().nextInt(arrList.size())).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        ((TextView) findViewById(C1206R.C1208id.feature_title)).setText(this.feature_title[this.feature_index]);
        ((TextView) findViewById(C1206R.C1208id.feature_desc)).setText(this.feature_description[this.feature_index]);
    }

    private String makeFeatureUnlock() {
        if (this.feature_index == 0) {
            SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
            mEditor.putBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", true);
            mEditor.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor.commit();
            return "Extended Equalizer";
        } else if (this.feature_index == 1) {
            SharedPreferences.Editor mEditor2 = this.mSharedPreferences.edit();
            mEditor2.putBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", true);
            mEditor2.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor2.commit();
            return "Home Screen Widget";
        } else if (this.feature_index == 2) {
            SharedPreferences.Editor mEditor3 = this.mSharedPreferences.edit();
            mEditor3.putBoolean(Passport.PKG_ID_MP3_RECORDING + "2", true);
            mEditor3.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor3.commit();
            return "MP3 Recording";
        } else if (this.feature_index != 3) {
            return null;
        } else {
            SharedPreferences.Editor mEditor4 = this.mSharedPreferences.edit();
            mEditor4.putBoolean(Passport.PKG_ID_REMOVE_ADS + "3", true);
            mEditor4.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor4.commit();
            return "Remove Ads";
        }
    }
}
