package com.microphone.earspy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microphone.earspy.inappbilling.Log;
import com.microphone.earspy.inappbilling.MainMenu;
import com.microphone.earspy.inappbilling.Passport;
import com.microphone.earspy.inappbilling.PurchaseActivity;
import com.microphone.earspy.widget.WidgetProvider;
import com.microphone.earspy.widget.WidgetService;
import java.util.ArrayList;

public class Add_Feature extends PurchaseActivity implements MainMenu {
    private static final String APP_TAG = "Microphone_EarSpy";
    private int[] btnIds = {C1206R.C1208id.btnExtendedEqu, C1206R.C1208id.btnHomeWidget, C1206R.C1208id.btnMp3Recording, C1206R.C1208id.btnRemove, C1206R.C1208id.btnPro};
    private ArrayList<String> inAppIds;
    private FirebaseAnalytics mFirebaseAnalytics;
    private SharedPreferences mSharedPreferences = null;
    private Button[] purchaseButtons;

    /* access modifiers changed from: protected */
    public void onStart() {
        Bundle params = new Bundle();
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "screen");
        params.putString(FirebaseAnalytics.Param.ITEM_NAME, "screen name");
        this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.add_features);
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.purchaseButtons = new Button[this.btnIds.length];
        this.inAppIds = new ArrayList<>();
        this.inAppIds.add(Passport.PKG_ID_EXTENDED_EQU);
        this.inAppIds.add(Passport.PKG_ID_HOME_SCREEN_WIDGET);
        this.inAppIds.add(Passport.PKG_ID_MP3_RECORDING);
        this.inAppIds.add(Passport.PKG_ID_REMOVE_ADS);
        for (int i = 0; i < this.btnIds.length; i++) {
            this.purchaseButtons[i] = (Button) findViewById(this.btnIds[i]);
        }
        this.purchaseButtons[0].setText(this.mSharedPreferences.getBoolean(new StringBuilder().append(this.inAppIds.get(0)).append("0").toString(), false) ? getResources().getString(C1206R.string.installed) : getPrice(this.inAppIds.get(0)));
        this.purchaseButtons[1].setText(this.mSharedPreferences.getBoolean(new StringBuilder().append(this.inAppIds.get(1)).append("1").toString(), false) ? getResources().getString(C1206R.string.installed) : getPrice(this.inAppIds.get(1)));
        this.purchaseButtons[2].setText(this.mSharedPreferences.getBoolean(new StringBuilder().append(this.inAppIds.get(2)).append("2").toString(), false) ? getResources().getString(C1206R.string.installed) : getPrice(this.inAppIds.get(2)));
        this.purchaseButtons[3].setText(this.mSharedPreferences.getBoolean(new StringBuilder().append(this.inAppIds.get(3)).append("3").toString(), false) ? getResources().getString(C1206R.string.installed) : getPrice(this.inAppIds.get(3)));
        this.purchaseButtons[4].setText(appInstalledOrNot("com.microphone.earspy.pro") ? getResources().getString(C1206R.string.installed) : getResources().getString(C1206R.string.buy));
        String string = getResources().getString(C1206R.string.extended_equalizer_description);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSharedPreferences.getInt("No_Equalizers", 5));
        if (Build.VERSION.SDK_INT >= 16) {
            str = " , AcousticEchoCanceler, AutomaticGainControl, NoiseSuppressor";
        } else {
            str = "";
        }
        objArr[1] = str;
        ((TextView) findViewById(C1206R.C1208id.txt_equalizer)).setText(String.format(string, objArr));
    }

    public void onPurchaseItemClick(View v) {
        navigate().toPurchasePassportActivityForResult();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (2012 != requestCode) {
            return;
        }
        if (-1 == resultCode) {
            dealWithSuccessfulPurchase();
        } else {
            dealWithFailedPurchase();
        }
    }

    private void dealWithSuccessfulPurchase() {
        Log.m1505d("EXTENDED_EQUALIZER purchased");
        SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
        mEditor.putBoolean(this.inAppIds.get(Passport.SKU_ID) + "" + Passport.SKU_ID, true);
        mEditor.commit();
        Log.m1505d(this.inAppIds.get(Passport.SKU_ID) + "" + Passport.SKU_ID);
        popToast("Purchased Successfully");
        this.purchaseButtons[Passport.SKU_ID].setText(getResources().getString(C1206R.string.installed));
        if (Passport.SKU_ID == 0) {
            Bundle params = new Bundle();
            params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "purchase");
            params.putString(FirebaseAnalytics.Param.ITEM_NAME, "Extended Equalizer");
            this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params);
        }
        if (Passport.SKU_ID == 2) {
            Bundle params2 = new Bundle();
            params2.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "purchase");
            params2.putString(FirebaseAnalytics.Param.ITEM_NAME, "MP3 Recording");
            this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params2);
        }
        if (Passport.SKU_ID == 3) {
            Bundle params3 = new Bundle();
            params3.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "purchase");
            params3.putString(FirebaseAnalytics.Param.ITEM_NAME, "Remove Ads");
            this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params3);
        }
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", false)) {
            Bundle params4 = new Bundle();
            params4.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "purchase");
            params4.putString(FirebaseAnalytics.Param.ITEM_NAME, "Home Screen Widget");
            this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params4);
            PackageManager pm = getPackageManager();
            pm.setComponentEnabledSetting(new ComponentName(this, WidgetProvider.class), 1, 1);
            pm.setComponentEnabledSetting(new ComponentName(this, WidgetService.class), 1, 1);
        }
    }

    private void dealWithFailedPurchase() {
        Log.m1505d("In-App Item purchase failed");
        EasyTracker.getTracker().trackEvent("Add Features", "In App Purchase failed or Cancelled", " But it.", 200);
        EasyTracker.getTracker().sendEvent("Add Features", "In App Purchase failed or Cancelled", " But it.", 200);
        popToast("Failed to purchase In-App Item");
    }

    public void onClickExtendedEqualizer(View view) {
        if (!this.mSharedPreferences.getBoolean(this.inAppIds.get(0) + "0", false)) {
            EasyTracker.getTracker().trackEvent("Add Features", "On click Extended Equalizer", " But it.", 200);
            EasyTracker.getTracker().sendEvent("Add Features", "On click Extended Equalizer", " But it.", 200);
            Passport.SKU = this.inAppIds.get(0);
            Passport.SKU_ID = 0;
            navigate().toPurchasePassportActivityForResult();
        }
    }

    public void onClickHomeScreenWidget(View view) {
        if (!this.mSharedPreferences.getBoolean(this.inAppIds.get(1) + "1", false)) {
            EasyTracker.getTracker().trackEvent("Add Features", "On click Home Screen Widget", " But it.", 200);
            EasyTracker.getTracker().sendEvent("Add Features", "On click Home Screen Widget", " But it.", 200);
            Passport.SKU = this.inAppIds.get(1);
            Passport.SKU_ID = 1;
            navigate().toPurchasePassportActivityForResult();
        }
    }

    public void onmClickMp3Recording(View view) {
        if (!this.mSharedPreferences.getBoolean(this.inAppIds.get(2) + "2", false)) {
            EasyTracker.getTracker().trackEvent("Add Features", "On click mp3 Recording", " But it.", 200);
            EasyTracker.getTracker().sendEvent("Add Features", "On click mp3 Recording", " But it.", 200);
            Passport.SKU = this.inAppIds.get(2);
            Passport.SKU_ID = 2;
            navigate().toPurchasePassportActivityForResult();
        }
    }

    public void onClickRemoveAds(View view) {
        if (!this.mSharedPreferences.getBoolean(this.inAppIds.get(3) + "3", false)) {
            EasyTracker.getTracker().trackEvent("Add Features", " On click Remove Ads", " But it.", 200);
            EasyTracker.getTracker().sendEvent("Add Features", " On click Remove Ads", " But it.", 200);
            Passport.SKU = this.inAppIds.get(3);
            Passport.SKU_ID = 3;
            navigate().toPurchasePassportActivityForResult();
        }
    }

    public void onClickPurchasePro(View view) {
        Bundle params = new Bundle();
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "purchase");
        params.putString(FirebaseAnalytics.Param.ITEM_NAME, "Pro Version");
        this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params);
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.microphone.earspy.pro");
        if (LaunchIntent != null) {
            startActivity(LaunchIntent);
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + "com.microphone.earspy.pro")));
        }
    }

    private boolean appInstalledOrNot(String uri) {
        try {
            getPackageManager().getPackageInfo(uri, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupSuccess() {
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupFailure() {
    }
}
