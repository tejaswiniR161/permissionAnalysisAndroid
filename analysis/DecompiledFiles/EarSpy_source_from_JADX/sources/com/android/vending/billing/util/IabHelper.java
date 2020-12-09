package com.android.vending.billing.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    boolean mAsyncInProgress = false;
    String mAsyncOperation = "";
    Context mContext;
    boolean mDebugLog = true;
    String mDebugTag = "SIAPv3";
    OnIabPurchaseFinishedListener mPurchaseListener;
    int mRequestCode;
    IInAppBillingService mService;
    ServiceConnection mServiceConn;
    boolean mSetupDone = false;
    String mSignatureBase64 = null;

    public interface OnConsumeFinishedListener {
        void onConsumeFinished(Purchase purchase, IabResult iabResult);
    }

    public interface OnConsumeMultiFinishedListener {
        void onConsumeMultiFinished(List<Purchase> list, List<IabResult> list2);
    }

    public interface OnIabPurchaseFinishedListener {
        void onIabPurchaseFinished(IabResult iabResult, Purchase purchase);
    }

    public interface OnIabSetupFinishedListener {
        void onIabSetupFinished(IabResult iabResult);
    }

    public interface QueryInventoryFinishedListener {
        void onQueryInventoryFinished(IabResult iabResult, Inventory inventory);
    }

    public IabHelper(Context ctx, String base64PublicKey) {
        this.mContext = ctx.getApplicationContext();
        this.mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    public void enableDebugLogging(boolean enable, String tag) {
        this.mDebugLog = enable;
        this.mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        this.mDebugLog = enable;
    }

    public void startSetup(final OnIabSetupFinishedListener listener) {
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        logDebug("Starting in-app billing setup.");
        this.mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName name) {
                IabHelper.this.logDebug("Billing service disconnected.");
                IabHelper.this.mService = null;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                IabHelper.this.logDebug("Billing service connected.");
                IabHelper.this.mService = IInAppBillingService.Stub.asInterface(service);
                String packageName = IabHelper.this.mContext.getPackageName();
                try {
                    IabHelper.this.logDebug("Checking for in-app billing 3 support.");
                    int response = IabHelper.this.mService.isBillingSupported(3, packageName, IabHelper.ITEM_TYPE_INAPP);
                    if (response == 0) {
                        IabHelper.this.logDebug("In-app billing version 3 supported for " + packageName);
                        IabHelper.this.mSetupDone = true;
                        if (listener != null) {
                            listener.onIabSetupFinished(new IabResult(0, "Setup successful."));
                        }
                    } else if (listener != null) {
                        listener.onIabSetupFinished(new IabResult(response, "Error checking for billing v3 support."));
                    }
                } catch (RemoteException e) {
                    if (listener != null) {
                        listener.onIabSetupFinished(new IabResult(IabHelper.IABHELPER_REMOTE_EXCEPTION, "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                }
            }
        };
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        List<ResolveInfo> intentServices = this.mContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (intentServices != null && !intentServices.isEmpty()) {
            this.mContext.bindService(serviceIntent, this.mServiceConn, 1);
        } else if (listener != null) {
            listener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
        }
    }

    public void dispose() {
        logDebug("Disposing.");
        this.mSetupDone = false;
        if (this.mServiceConn != null) {
            logDebug("Unbinding from service.");
            if (!(this.mContext == null || this.mService == null)) {
                this.mContext.unbindService(this.mServiceConn);
            }
            this.mServiceConn = null;
            this.mService = null;
            this.mPurchaseListener = null;
        }
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) {
        launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) {
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        try {
            logDebug("Constructing buy intent for " + sku);
            Bundle buyIntentBundle = this.mService.getBuyIntent(3, this.mContext.getPackageName(), sku, ITEM_TYPE_INAPP, extraData);
            int response = getResponseCodeFromBundle(buyIntentBundle);
            if (response != 0) {
                logError("Unable to buy item, Error response: " + getResponseDesc(response));
                IabResult result = new IabResult(response, "Unable to buy item");
                if (listener != null) {
                    listener.onIabPurchaseFinished(result, (Purchase) null);
                    return;
                }
                return;
            }
            logDebug("Launching buy intent for " + sku + ". Request code: " + requestCode);
            this.mRequestCode = requestCode;
            this.mPurchaseListener = listener;
            IntentSender intentSender = ((PendingIntent) buyIntentBundle.getParcelable(RESPONSE_BUY_INTENT)).getIntentSender();
            Intent intent = new Intent();
            Integer num = 0;
            int intValue = num.intValue();
            Integer num2 = 0;
            int intValue2 = num2.intValue();
            Integer num3 = 0;
            act.startIntentSenderForResult(intentSender, requestCode, intent, intValue, intValue2, num3.intValue());
        } catch (IntentSender.SendIntentException e) {
            logError("SendIntentException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            IabResult result2 = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
            if (listener != null) {
                listener.onIabPurchaseFinished(result2, (Purchase) null);
            }
        } catch (RemoteException e2) {
            logError("RemoteException while launching purchase flow for sku " + sku);
            e2.printStackTrace();
            IabResult result3 = new IabResult(IABHELPER_REMOTE_EXCEPTION, "Remote exception while starting purchase flow");
            if (listener != null) {
                listener.onIabPurchaseFinished(result3, (Purchase) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleActivityResult(int r13, int r14, android.content.Intent r15) {
        /*
            r12 = this;
            int r8 = r12.mRequestCode
            if (r13 == r8) goto L_0x0006
            r8 = 0
        L_0x0005:
            return r8
        L_0x0006:
            java.lang.String r8 = "handleActivityResult"
            r12.checkSetupDone(r8)
            r12.flagEndAsync()
            if (r15 != 0) goto L_0x002a
            java.lang.String r8 = "Null data in IAB activity result."
            r12.logError(r8)
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            r8 = -1002(0xfffffffffffffc16, float:NaN)
            java.lang.String r9 = "Null data in IAB result"
            r6.<init>(r8, r9)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x0028
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
        L_0x0028:
            r8 = 1
            goto L_0x0005
        L_0x002a:
            int r5 = r12.getResponseCodeFromIntent(r15)
            java.lang.String r8 = "INAPP_PURCHASE_DATA"
            java.lang.String r4 = r15.getStringExtra(r8)
            java.lang.String r8 = "INAPP_DATA_SIGNATURE"
            java.lang.String r0 = r15.getStringExtra(r8)
            r8 = -1
            if (r14 != r8) goto L_0x014d
            if (r5 != 0) goto L_0x014d
            java.lang.String r8 = "Successful resultcode from purchase activity."
            r12.logDebug(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Purchase data: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r4)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Data signature: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Extras: "
            java.lang.StringBuilder r8 = r8.append(r9)
            android.os.Bundle r9 = r15.getExtras()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            if (r4 == 0) goto L_0x008e
            if (r0 != 0) goto L_0x00c7
        L_0x008e:
            java.lang.String r8 = "BUG: either purchaseData or dataSignature is null."
            r12.logError(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Extras: "
            java.lang.StringBuilder r8 = r8.append(r9)
            android.os.Bundle r9 = r15.getExtras()
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            r8 = -1008(0xfffffffffffffc10, float:NaN)
            java.lang.String r9 = "IAB returned null purchaseData or dataSignature"
            r6.<init>(r8, r9)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x00c4
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
        L_0x00c4:
            r8 = 1
            goto L_0x0005
        L_0x00c7:
            r2 = 0
            com.android.vending.billing.util.Purchase r3 = new com.android.vending.billing.util.Purchase     // Catch:{ JSONException -> 0x012e }
            r3.<init>(r4, r0)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.getSku()     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r8 = r12.mSignatureBase64     // Catch:{ JSONException -> 0x01e9 }
            boolean r8 = com.android.vending.billing.util.Security.verifyPurchase(r8, r4, r0)     // Catch:{ JSONException -> 0x01e9 }
            if (r8 != 0) goto L_0x0115
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01e9 }
            r8.<init>()     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r9 = "Purchase signature verification FAILED for sku "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ JSONException -> 0x01e9 }
            java.lang.StringBuilder r8 = r8.append(r7)     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x01e9 }
            r12.logError(r8)     // Catch:{ JSONException -> 0x01e9 }
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult     // Catch:{ JSONException -> 0x01e9 }
            r8 = -1003(0xfffffffffffffc15, float:NaN)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01e9 }
            r9.<init>()     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r10 = "Signature verification failed for sku "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ JSONException -> 0x01e9 }
            java.lang.StringBuilder r9 = r9.append(r7)     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x01e9 }
            r6.<init>(r8, r9)     // Catch:{ JSONException -> 0x01e9 }
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener     // Catch:{ JSONException -> 0x01e9 }
            if (r8 == 0) goto L_0x0112
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener     // Catch:{ JSONException -> 0x01e9 }
            r8.onIabPurchaseFinished(r6, r3)     // Catch:{ JSONException -> 0x01e9 }
        L_0x0112:
            r8 = 1
            goto L_0x0005
        L_0x0115:
            java.lang.String r8 = "Purchase signature successfully verified."
            r12.logDebug(r8)     // Catch:{ JSONException -> 0x01e9 }
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x012b
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            com.android.vending.billing.util.IabResult r9 = new com.android.vending.billing.util.IabResult
            r10 = 0
            java.lang.String r11 = "Success"
            r9.<init>(r10, r11)
            r8.onIabPurchaseFinished(r9, r3)
        L_0x012b:
            r8 = 1
            goto L_0x0005
        L_0x012e:
            r1 = move-exception
        L_0x012f:
            java.lang.String r8 = "Failed to parse purchase data."
            r12.logError(r8)
            r1.printStackTrace()
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            r8 = -1002(0xfffffffffffffc16, float:NaN)
            java.lang.String r9 = "Failed to parse purchase data."
            r6.<init>(r8, r9)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x014a
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
        L_0x014a:
            r8 = 1
            goto L_0x0005
        L_0x014d:
            r8 = -1
            if (r14 != r8) goto L_0x017c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Result code was OK but in-app billing response was not OK: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = getResponseDesc(r5)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x012b
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            java.lang.String r8 = "Problem purchashing item."
            r6.<init>(r5, r8)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
            goto L_0x012b
        L_0x017c:
            if (r14 != 0) goto L_0x01ac
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Purchase canceled - Response: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = getResponseDesc(r5)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.logDebug(r8)
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            r8 = -1005(0xfffffffffffffc13, float:NaN)
            java.lang.String r9 = "User canceled."
            r6.<init>(r8, r9)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x012b
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
            goto L_0x012b
        L_0x01ac:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Purchase failed. Result code: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = java.lang.Integer.toString(r14)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = ". Response: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = getResponseDesc(r5)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.logError(r8)
            com.android.vending.billing.util.IabResult r6 = new com.android.vending.billing.util.IabResult
            r8 = -1006(0xfffffffffffffc12, float:NaN)
            java.lang.String r9 = "Unknown purchase response."
            r6.<init>(r8, r9)
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            if (r8 == 0) goto L_0x012b
            com.android.vending.billing.util.IabHelper$OnIabPurchaseFinishedListener r8 = r12.mPurchaseListener
            r9 = 0
            r8.onIabPurchaseFinished(r6, r9)
            goto L_0x012b
        L_0x01e9:
            r1 = move-exception
            r2 = r3
            goto L_0x012f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.vending.billing.util.IabHelper.handleActivityResult(int, int, android.content.Intent):boolean");
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreSkus) throws IabException {
        checkSetupDone("queryInventory");
        try {
            Inventory inv = new Inventory();
            int r = queryPurchases(inv);
            if (r != 0) {
                throw new IabException(r, "Error refreshing inventory (querying owned items).");
            }
            if (querySkuDetails) {
                int r2 = querySkuDetails(inv, moreSkus);
                if (r2 != 0) {
                    throw new IabException(r2, "Error refreshing inventory (querying prices of items).");
                }
            }
            return inv;
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new IabException(IABHELPER_BAD_RESPONSE, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void queryInventoryAsync(boolean querySkuDetails, List<String> moreSkus, QueryInventoryFinishedListener listener) {
        final Handler handler = new Handler();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        Log.d("EarSpy", "started queryInventoryAsync");
        final boolean z = querySkuDetails;
        final List<String> list = moreSkus;
        final QueryInventoryFinishedListener queryInventoryFinishedListener = listener;
        new Thread(new Runnable() {
            public void run() {
                IabResult result = new IabResult(0, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    inv = IabHelper.this.queryInventory(z, list);
                } catch (IabException ex) {
                    result = ex.getResult();
                }
                IabHelper.this.flagEndAsync();
                final IabResult result_f = result;
                final Inventory inv_f = inv;
                handler.post(new Runnable() {
                    public void run() {
                        queryInventoryFinishedListener.onQueryInventoryFinished(result_f, inv_f);
                    }
                });
            }
        }).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) {
        queryInventoryAsync(true, (List<String>) null, listener);
    }

    public void queryInventoryAsync(boolean querySkuDetails, QueryInventoryFinishedListener listener) {
        queryInventoryAsync(querySkuDetails, (List<String>) null, listener);
    }

    /* access modifiers changed from: package-private */
    public void consume(Purchase itemInfo) throws IabException {
        checkSetupDone("consume");
        try {
            String token = itemInfo.getToken();
            String sku = itemInfo.getSku();
            if (token == null || token.equals("")) {
                logError("Can't consume " + sku + ". No token.");
                throw new IabException((int) IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: " + sku + " " + itemInfo);
            }
            logDebug("Consuming sku: " + sku + ", token: " + token);
            int response = this.mService.consumePurchase(3, this.mContext.getPackageName(), token);
            if (response == 0) {
                logDebug("Successfully consumed sku: " + sku);
            } else {
                logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                throw new IabException(response, "Error consuming sku " + sku);
            }
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while consuming. PurchaseInfo: " + itemInfo, e);
        }
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener listener) {
        checkSetupDone("consume");
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase);
        consumeAsyncInternal(purchases, listener, (OnConsumeMultiFinishedListener) null);
    }

    public void consumeAsync(List<Purchase> purchases, OnConsumeMultiFinishedListener listener) {
        checkSetupDone("consume");
        consumeAsyncInternal(purchases, (OnConsumeFinishedListener) null, listener);
    }

    public static String getResponseDesc(int code) {
        String[] iab_msgs = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] iabhelper_msgs = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error".split("/");
        if (code <= -1000) {
            int index = -1000 - code;
            if (index < 0 || index >= iabhelper_msgs.length) {
                return String.valueOf(code) + ":Unknown IAB Helper Error";
            }
            return iabhelper_msgs[index];
        } else if (code < 0 || code >= iab_msgs.length) {
            return String.valueOf(code) + ":Unknown";
        } else {
            return iab_msgs[code];
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSetupDone(String operation) {
        if (!this.mSetupDone) {
            logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    /* access modifiers changed from: package-private */
    public int getResponseCodeFromBundle(Bundle b) {
        Object o = b.get(RESPONSE_CODE);
        if (o == null) {
            logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (o instanceof Integer) {
            return ((Integer) o).intValue();
        } else {
            if (o instanceof Long) {
                return (int) ((Long) o).longValue();
            }
            logError("Unexpected type for bundle response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    public int getResponseCodeFromIntent(Intent i) {
        Object o = i.getExtras().get(RESPONSE_CODE);
        if (o == null) {
            logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (o instanceof Integer) {
            return ((Integer) o).intValue();
        } else {
            if (o instanceof Long) {
                return (int) ((Long) o).longValue();
            }
            logError("Unexpected type for intent response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    public void flagStartAsync(String operation) {
        if (this.mAsyncInProgress) {
            throw new IllegalStateException("Can't start async operation (" + operation + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
        }
        this.mAsyncOperation = operation;
        this.mAsyncInProgress = true;
        logDebug("Starting async operation: " + operation);
    }

    /* access modifiers changed from: package-private */
    public void flagEndAsync() {
        logDebug("Ending async operation: " + this.mAsyncOperation);
        this.mAsyncOperation = "";
        this.mAsyncInProgress = false;
    }

    /* access modifiers changed from: package-private */
    public int queryPurchases(Inventory inv) throws JSONException, RemoteException {
        logDebug("Querying owned items...");
        logDebug("Package name: " + this.mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;
        do {
            logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = this.mService.getPurchases(3, this.mContext.getPackageName(), ITEM_TYPE_INAPP, continueToken);
            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != 0) {
                logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            } else if (!ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST) || !ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST) || !ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
                logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return IABHELPER_BAD_RESPONSE;
            } else {
                ArrayList<String> ownedSkus = ownedItems.getStringArrayList(RESPONSE_INAPP_ITEM_LIST);
                ArrayList<String> purchaseDataList = ownedItems.getStringArrayList(RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> signatureList = ownedItems.getStringArrayList(RESPONSE_INAPP_SIGNATURE_LIST);
                for (int i = 0; i < purchaseDataList.size(); i++) {
                    String purchaseData = purchaseDataList.get(i);
                    String signature = signatureList.get(i);
                    String sku = ownedSkus.get(i);
                    if (Security.verifyPurchase(this.mSignatureBase64, purchaseData, signature)) {
                        logDebug("Sku is owned: " + sku);
                        Purchase purchase = new Purchase(purchaseData, signature);
                        if (TextUtils.isEmpty(purchase.getToken())) {
                            logWarn("BUG: empty/null token!");
                            logDebug("Purchase data: " + purchaseData);
                        }
                        inv.addPurchase(purchase);
                    } else {
                        logWarn("Purchase signature verification **FAILED**. Not adding item.");
                        logDebug("   Purchase data: " + purchaseData);
                        logDebug("   Signature: " + signature);
                        verificationFailed = true;
                    }
                }
                continueToken = ownedItems.getString(INAPP_CONTINUATION_TOKEN);
                logDebug("Continuation token: " + continueToken);
            }
        } while (!TextUtils.isEmpty(continueToken));
        return verificationFailed ? IABHELPER_VERIFICATION_FAILED : 0;
    }

    /* access modifiers changed from: package-private */
    public int querySkuDetails(Inventory inv, List<String> moreSkus) throws RemoteException, JSONException {
        logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList<>();
        skuList.addAll(inv.getAllOwnedSkus());
        if (moreSkus != null) {
            skuList.addAll(moreSkus);
        }
        if (skuList.size() == 0) {
            logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuList);
        Bundle skuDetails = this.mService.getSkuDetails(3, this.mContext.getPackageName(), ITEM_TYPE_INAPP, querySkus);
        if (!skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
            int response = getResponseCodeFromBundle(skuDetails);
            if (response != 0) {
                logDebug("getSkuDetails() failed: " + getResponseDesc(response));
                return response;
            }
            logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return IABHELPER_BAD_RESPONSE;
        }
        Iterator i$ = skuDetails.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST).iterator();
        while (i$.hasNext()) {
            SkuDetails d = new SkuDetails(i$.next());
            logDebug("Got sku details: " + d);
            inv.addSkuDetails(d);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void consumeAsyncInternal(List<Purchase> purchases, OnConsumeFinishedListener singleListener, OnConsumeMultiFinishedListener multiListener) {
        final Handler handler = new Handler();
        flagStartAsync("consume");
        final List<Purchase> list = purchases;
        final OnConsumeFinishedListener onConsumeFinishedListener = singleListener;
        final OnConsumeMultiFinishedListener onConsumeMultiFinishedListener = multiListener;
        new Thread(new Runnable() {
            public void run() {
                final List<IabResult> results = new ArrayList<>();
                for (Purchase purchase : list) {
                    try {
                        IabHelper.this.consume(purchase);
                        results.add(new IabResult(0, "Successful consume of sku " + purchase.getSku()));
                    } catch (IabException ex) {
                        results.add(ex.getResult());
                    }
                }
                IabHelper.this.flagEndAsync();
                if (onConsumeFinishedListener != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            onConsumeFinishedListener.onConsumeFinished((Purchase) list.get(0), (IabResult) results.get(0));
                        }
                    });
                }
                if (onConsumeMultiFinishedListener != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            onConsumeMultiFinishedListener.onConsumeMultiFinished(list, results);
                        }
                    });
                }
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void logDebug(String msg) {
        if (this.mDebugLog) {
            Log.d(this.mDebugTag, msg);
        }
    }

    /* access modifiers changed from: package-private */
    public void logError(String msg) {
        Log.e(this.mDebugTag, "In-app billing error: " + msg);
    }

    /* access modifiers changed from: package-private */
    public void logWarn(String msg) {
        Log.w(this.mDebugTag, "In-app billing warning: " + msg);
    }
}
