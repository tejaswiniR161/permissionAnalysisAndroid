package com.microphone.earspy;

import android.os.Bundle;
import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Purchase;
import com.microphone.earspy.inappbilling.Passport;
import com.microphone.earspy.inappbilling.PurchaseActivity;

public class InAppPurchaseActivity extends PurchaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(0);
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupFailure() {
        popBurntToast("Sorry In-App Item is not available at this current time");
        finish();
    }

    /* access modifiers changed from: protected */
    public void dealWithIabSetupSuccess() {
        purchaseItem(Passport.SKU);
    }

    /* access modifiers changed from: protected */
    public void dealWithPurchaseSuccess(IabResult result, Purchase info) {
        super.dealWithPurchaseSuccess(result, info);
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: protected */
    public void dealWithPurchaseFailed(IabResult result) {
        super.dealWithPurchaseFailed(result);
        setResult(0);
        finish();
    }
}
