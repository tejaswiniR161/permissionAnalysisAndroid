package com.applovin.impl.sdk;

import android.content.Intent;
import android.net.Uri;
import com.android.vending.billing.util.IabHelper;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f284a;

    /* renamed from: b */
    private final List f285b;

    public EventServiceImpl(AppLovinSdk appLovinSdk) {
        this.f284a = (AppLovinSdkImpl) appLovinSdk;
        this.f285b = Arrays.asList(((String) ((AppLovinSdkImpl) appLovinSdk).mo5363a(C0343bw.f529bi)).split(","));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Uri m227a(C0339bs bsVar, C0397s sVar) {
        C0396r dataCollector = this.f284a.getDataCollector();
        C0399u a = dataCollector.mo5690a();
        C0398t b = dataCollector.mo5692b();
        boolean contains = this.f285b.contains(bsVar.mo5527a());
        Uri.Builder appendQueryParameter = Uri.parse((String) this.f284a.mo5363a(C0343bw.f528bh)).buildUpon().appendQueryParameter("event", contains ? bsVar.mo5527a() : "postinstall").appendQueryParameter("ts", Long.toString(bsVar.mo5529c())).appendQueryParameter("platform", "Android").appendQueryParameter("model", a.f691a).appendQueryParameter("package_name", b.f689c).appendQueryParameter("sdk_key", this.f284a.getSdkKey()).appendQueryParameter("idfa", sVar.f686b).appendQueryParameter("dnt", Boolean.toString(sVar.f685a)).appendQueryParameter("ia", Long.toString(b.f690d)).appendQueryParameter("api_did", (String) this.f284a.mo5363a(C0343bw.f545c)).appendQueryParameter("brand", a.f693c).appendQueryParameter("model", a.f691a).appendQueryParameter("revision", a.f694d).appendQueryParameter("sdk_version", AppLovinSdk.VERSION).appendQueryParameter("os", a.f692b);
        if (!contains) {
            appendQueryParameter = appendQueryParameter.appendQueryParameter("sub_event", bsVar.mo5527a());
        }
        return appendQueryParameter.build();
    }

    /* renamed from: a */
    private Map m229a(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (!(key instanceof String) || !(value instanceof String)) {
                    this.f284a.getLogger().mo5671w("EventServiceImpl", "Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered " + key.getClass().getCanonicalName() + "/" + value.getClass().getCanonicalName() + "; will use toString() value instead, which may be unexpected...");
                    hashMap.put(key.toString(), value.toString());
                } else {
                    hashMap.put((String) key, (String) value);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m230a(C0339bs bsVar) {
        if (((Boolean) this.f284a.mo5363a(C0343bw.f530bj)).booleanValue()) {
            this.f284a.getLogger().mo5665d("EventServiceImpl", "Tracking event: " + bsVar);
            m231a((C0357cj) new C0400v(this, bsVar));
        }
    }

    /* renamed from: a */
    private void m231a(C0357cj cjVar) {
        this.f284a.mo5362a().mo5636a((C0342bv) new C0356ci(this.f284a, cjVar), C0365cr.BACKGROUND);
    }

    public void trackCheckout(String str, Map map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map map) {
        m230a(new C0339bs(str, m229a(map), System.currentTimeMillis(), C0382dh.m588b(UUID.randomUUID().toString())));
    }

    public void trackInAppPurchase(Intent intent, Map map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra(IabHelper.RESPONSE_INAPP_SIGNATURE));
        } catch (Exception e) {
            this.f284a.getLogger().userError("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", e);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, hashMap);
    }
}
