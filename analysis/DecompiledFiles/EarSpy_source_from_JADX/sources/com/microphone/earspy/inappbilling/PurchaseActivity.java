package com.microphone.earspy.inappbilling;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.vending.billing.util.IabHelper;
import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Inventory;
import com.android.vending.billing.util.Purchase;
import com.microphone.earspy.C1206R;
import com.microphone.earspy.EasyTracker;
import java.util.ArrayList;
import java.util.List;

public abstract class PurchaseActivity extends BlundellActivity implements IabHelper.OnIabSetupFinishedListener, IabHelper.OnIabPurchaseFinishedListener {
    public static final String PREF_IS_INVENTORY_CHECKED = "PREF_IS_INVENTORY_CHECKED";
    public static Inventory mInventory;
    private IabHelper billingHelper;
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.m1505d("Query inventory finished.");
            if (result.isFailure()) {
                try {
                    EasyTracker.getTracker().trackEvent("IAP restore", "IAP restore", "failed: " + result.getMessage(), 200);
                    EasyTracker.getTracker().sendEvent("IAP restore", "IAP restore", "failed: " + result.getMessage(), 200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.m1505d("Query inventory was successful.");
                Purchase extendedEqualizerPurchase = inventory.getPurchase(Passport.PKG_ID_EXTENDED_EQU);
                if (extendedEqualizerPurchase != null && PurchaseActivity.this.verifyDeveloperPayload(extendedEqualizerPurchase)) {
                    SharedPreferences.Editor mEditor = PurchaseActivity.this.mSharedPreferences.edit();
                    mEditor.putBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", true);
                    mEditor.commit();
                    try {
                        EasyTracker.getTracker().trackEvent("IAP restore", "IAP restore", "success: Equalizers", 200);
                        EasyTracker.getTracker().sendEvent("IAP restore", "IAP restore", "success: Equalizers", 200);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Purchase homeWidgetPurchase = inventory.getPurchase(Passport.PKG_ID_HOME_SCREEN_WIDGET);
                    if (homeWidgetPurchase != null && PurchaseActivity.this.verifyDeveloperPayload(homeWidgetPurchase)) {
                        SharedPreferences.Editor mEditor2 = PurchaseActivity.this.mSharedPreferences.edit();
                        mEditor2.putBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", true);
                        mEditor2.commit();
                        try {
                            EasyTracker.getTracker().trackEvent("IAP restore", "IAP restore", "success: Home screen widget", 200);
                            EasyTracker.getTracker().sendEvent("IAP restore", "IAP restore", "success: Home screen widget", 200);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    Purchase mp3RecordingPurchase = inventory.getPurchase(Passport.PKG_ID_MP3_RECORDING);
                    if (mp3RecordingPurchase != null && PurchaseActivity.this.verifyDeveloperPayload(mp3RecordingPurchase)) {
                        SharedPreferences.Editor mEditor3 = PurchaseActivity.this.mSharedPreferences.edit();
                        mEditor3.putBoolean(Passport.PKG_ID_MP3_RECORDING + "2", true);
                        mEditor3.commit();
                        try {
                            EasyTracker.getTracker().trackEvent("IAP restore", "IAP restore", "success: MP3 Recording", 200);
                            EasyTracker.getTracker().sendEvent("IAP restore", "IAP restore", "success: MP3 Recording", 200);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    Purchase removeAdsPurchase = inventory.getPurchase(Passport.PKG_ID_REMOVE_ADS);
                    if (removeAdsPurchase != null && PurchaseActivity.this.verifyDeveloperPayload(removeAdsPurchase)) {
                        SharedPreferences.Editor mEditor4 = PurchaseActivity.this.mSharedPreferences.edit();
                        mEditor4.putBoolean(Passport.PKG_ID_REMOVE_ADS + "3", true);
                        mEditor4.commit();
                        try {
                            EasyTracker.getTracker().trackEvent("IAP restore", "IAP restore", "success: Remove Ads", 200);
                            EasyTracker.getTracker().sendEvent("IAP restore", "IAP restore", "success: Remove Ads", 200);
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    PurchaseActivity.this.saveData();
                    Log.m1505d("Initial inventory query finished; enabling main UI.");
                } catch (Exception e6) {
                }
            }
        }
    };
    SharedPreferences mSharedPreferences;

    /* access modifiers changed from: protected */
    public abstract void dealWithIabSetupFailure();

    /* access modifiers changed from: protected */
    public abstract void dealWithIabSetupSuccess();

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            EasyTracker.getInstance().activityStart(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            EasyTracker.getInstance().activityStop(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.activity_purchase);
        setResult(0);
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.billingHelper = new IabHelper(this, AppProperties.BASE_64_KEY);
        this.billingHelper.startSetup(this);
    }

    /* access modifiers changed from: private */
    public void saveData() {
        SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
        mEditor.putBoolean(PREF_IS_INVENTORY_CHECKED, true);
        mEditor.commit();
    }

    /* access modifiers changed from: package-private */
    public boolean verifyDeveloperPayload(Purchase p) {
        return true;
    }

    public void updateInventory() {
        if (mInventory == null) {
            List<String> inAppIds = new ArrayList<>();
            inAppIds.add(Passport.PKG_ID_EXTENDED_EQU);
            inAppIds.add(Passport.PKG_ID_HOME_SCREEN_WIDGET);
            inAppIds.add(Passport.PKG_ID_MP3_RECORDING);
            inAppIds.add(Passport.PKG_ID_REMOVE_ADS);
            try {
                mInventory = this.billingHelper.queryInventory(true, inAppIds);
            } catch (Exception e) {
                mInventory = null;
            }
        }
    }

    public void onIabSetupFinished(IabResult result) {
        if (result.isSuccess()) {
            Log.m1505d("In-app Billing set up" + result);
            dealWithIabSetupSuccess();
            updateInventory();
            return;
        }
        Log.m1505d("Problem setting up In-app Billing: " + result);
        dealWithIabSetupFailure();
    }

    /* access modifiers changed from: protected */
    public void restoreItems() {
        if (!this.mSharedPreferences.getBoolean(PREF_IS_INVENTORY_CHECKED, false)) {
            Log.m1505d("Setup successful. Querying inventory.");
            this.billingHelper.queryInventoryAsync(this.mGotInventoryListener);
        }
    }

    /* access modifiers changed from: protected */
    public void purchaseItem(String sku) {
        this.billingHelper.launchPurchaseFlow(this, sku, 123, this);
    }

    public String getPrice(String sku) {
        if (mInventory == null) {
            return getResources().getString(C1206R.string.buy);
        }
        try {
            return mInventory.getSkuDetails(sku).getPrice();
        } catch (Exception e) {
            return getResources().getString(C1206R.string.buy);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.billingHelper.handleActivityResult(requestCode, resultCode, data);
    }

    public void onIabPurchaseFinished(IabResult result, Purchase info) {
        if (result.isFailure()) {
            dealWithPurchaseFailed(result);
        } else if (Passport.SKU.equals(info.getSku())) {
            dealWithPurchaseSuccess(result, info);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void dealWithPurchaseFailed(IabResult result) {
        Log.m1505d("Error purchasing: " + result);
    }

    /* access modifiers changed from: protected */
    public void dealWithPurchaseSuccess(IabResult result, Purchase info) {
        Log.m1505d("Item purchased: " + result);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        disposeBillingHelper();
        super.onDestroy();
    }

    private void disposeBillingHelper() {
        if (this.billingHelper != null) {
            this.billingHelper.dispose();
        }
        this.billingHelper = null;
    }
}
