package com.microphone.earspy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.microphone.earspy.constant.Constant;
import com.microphone.earspy.constant.Utility;
import com.microphone.earspy.inappbilling.Passport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

public class Unlock_Feature extends Activity {
    Runnable ViewOrder = null;
    EditText editCode;
    private String[] feature_description = null;
    private int feature_index = 0;
    private String[] feature_title;
    String json_data = null;
    private SharedPreferences mSharedPreferences = null;
    ProgressDialog progressDialog;
    Runnable returnRes = new Runnable() {
        public void run() {
            Unlock_Feature.this.progressDialog.cancel();
            if (Unlock_Feature.this.json_data != null) {
                try {
                    JSONObject jo = new JSONObject(Unlock_Feature.this.json_data);
                    if (jo.getString("status").equals("failure")) {
                        Toast.makeText(Unlock_Feature.this.getApplicationContext(), jo.getString("message"), 0).show();
                    } else if (jo.getString("status").equals("success")) {
                        String featureName = Unlock_Feature.this.makeFeatureUnlock();
                        EasyTracker.getTracker().trackEvent("Unlock Feature", " Feature unlocked", featureName, 200);
                        EasyTracker.getTracker().sendEvent("Unlock Feature", " Feature unlocked", featureName, 200);
                        Unlock_Feature.this.editCode.setText("");
                        if (featureName != null) {
                            Toast.makeText(Unlock_Feature.this.getApplicationContext(), "Feature Unlocked: " + featureName, 1).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.unlock_feature);
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        getWindow().setSoftInputMode(3);
        fillupArray();
        setFeatureInfo();
        ((TextView) findViewById(C1206R.C1208id.link)).setText(String.format(getResources().getString(C1206R.string.unlock_link), new Object[]{"http://www.overpass.co.uk/tweet4earspy/"}));
        this.editCode = (EditText) findViewById(C1206R.C1208id.code);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage(getResources().getString(C1206R.string.please_wait));
        this.ViewOrder = new Runnable() {
            public void run() {
                try {
                    Unlock_Feature.this.json_data = Utility.getData(Constant.URL_UNLOCK + Unlock_Feature.this.editCode.getText().toString().trim());
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Unlock_Feature.this.runOnUiThread(Unlock_Feature.this.returnRes);
            }
        };
        ((Button) findViewById(C1206R.C1208id.btnUnlock)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EasyTracker.getTracker().trackEvent("Unlock Feature", " Unlock button clicked", " Buy", 200);
                EasyTracker.getTracker().sendEvent("Unlock Feature", " Unlock button clicked", " Buy", 200);
                ((InputMethodManager) Unlock_Feature.this.getSystemService("input_method")).hideSoftInputFromWindow(Unlock_Feature.this.editCode.getWindowToken(), 0);
                if (Unlock_Feature.this.editCode.getText().toString().trim().length() > 1) {
                    Unlock_Feature.this.progressDialog.show();
                    new Thread(Unlock_Feature.this.ViewOrder).start();
                    return;
                }
                Toast.makeText(Unlock_Feature.this.getApplicationContext(), Unlock_Feature.this.getResources().getString(C1206R.string.enter_code), 0).show();
            }
        });
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
        try {
            this.feature_index = arrList.get(new Random().nextInt(arrList.size())).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        ((TextView) findViewById(C1206R.C1208id.feature_title)).setText(this.feature_title[this.feature_index]);
        ((TextView) findViewById(C1206R.C1208id.feature_desc)).setText(this.feature_description[this.feature_index]);
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

    /* access modifiers changed from: private */
    public String makeFeatureUnlock() {
        if (this.feature_index == 0) {
            Log.d("Microphone_EarSpy", "PKG_ID_EXTENDED_EQU purchased.");
            SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
            mEditor.putBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", true);
            mEditor.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor.commit();
            return "Extended Equalizer";
        } else if (this.feature_index == 1) {
            Log.d("Microphone_EarSpy", "PKG_ID_HOME_SCREEN_WIDGET purchased.");
            SharedPreferences.Editor mEditor2 = this.mSharedPreferences.edit();
            mEditor2.putBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", true);
            mEditor2.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor2.commit();
            return "Home Screen Widget";
        } else if (this.feature_index == 2) {
            Log.d("Microphone_EarSpy", "PKG_ID_MP3_RECORDING purchased.");
            SharedPreferences.Editor mEditor3 = this.mSharedPreferences.edit();
            mEditor3.putBoolean(Passport.PKG_ID_MP3_RECORDING + "2", true);
            mEditor3.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor3.commit();
            return "MP3 Recording";
        } else if (this.feature_index != 3) {
            return null;
        } else {
            Log.d("Microphone_EarSpy", "PKG_ID_REMOVE_ADS purchased.");
            SharedPreferences.Editor mEditor4 = this.mSharedPreferences.edit();
            mEditor4.putBoolean(Passport.PKG_ID_REMOVE_ADS + "3", true);
            mEditor4.putBoolean(Constant.PREF_TWEET_USED, true);
            mEditor4.commit();
            return "Remove Ads";
        }
    }
}
