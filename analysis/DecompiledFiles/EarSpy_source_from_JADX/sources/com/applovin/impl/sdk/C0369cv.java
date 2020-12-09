package com.applovin.impl.sdk;

import com.applovin.impl.adview.C0288v;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cv */
class C0369cv extends C0342bv implements C0381dg {

    /* renamed from: a */
    private final Collection f624a;

    /* renamed from: b */
    private final JSONObject f625b;

    /* renamed from: c */
    private final AppLovinAdLoadListener f626c;

    /* renamed from: d */
    private final C0403y f627d;

    /* renamed from: i */
    private boolean f628i;

    /* renamed from: j */
    private C0347c f629j = new C0347c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);

    C0369cv(JSONObject jSONObject, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("RenderAd", appLovinSdkImpl);
        this.f625b = jSONObject;
        this.f626c = appLovinAdLoadListener;
        this.f624a = m535d();
        this.f627d = appLovinSdkImpl.getFileManager();
    }

    /* renamed from: a */
    private float m528a(String str, AppLovinAdType appLovinAdType, int i) {
        if (appLovinAdType.equals(AppLovinAdType.INCENTIVIZED)) {
            return 0.5f;
        }
        return (!appLovinAdType.equals(AppLovinAdType.REGULAR) || str == null || i != -1) ? 0.0f : 0.5f;
    }

    /* renamed from: a */
    private C0288v m529a(int i) {
        return i == 1 ? C0288v.WhiteXOnTransparentGrey : C0288v.WhiteXOnOpaqueBlack;
    }

    /* renamed from: a */
    private C0288v m530a(String str) {
        return str != null ? C0288v.WhiteXOnTransparentGrey : C0288v.WhiteXOnOpaqueBlack;
    }

    /* renamed from: a */
    private String m531a(String str, String str2) {
        File a = this.f627d.mo5695a(str2.replace("/", "_"), this.f438f.getApplicationContext(), true);
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.f439g.mo5665d(this.f437e, "Loaded " + str2 + " from cache: file://" + a.getAbsolutePath());
            return "file://" + a.getAbsolutePath();
        }
        if (this.f627d.mo5703a(a, str + str2)) {
            return "file://" + a.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: a */
    private void m532a(JSONObject jSONObject) {
        int i;
        int i2;
        float a;
        C0288v a2;
        String str;
        String str2;
        String string = jSONObject.getString("html");
        AppLovinAdSize fromString = jSONObject.has("size") ? AppLovinAdSize.fromString(jSONObject.getString("size")) : AppLovinAdSize.BANNER;
        String str3 = null;
        if (string == null || string.length() <= 0) {
            this.f439g.mo5666e(this.f437e, "No HTML received for requested ad");
            mo5643c();
            return;
        }
        String b = m533b(string);
        AppLovinAdImpl.AdTarget valueOf = jSONObject.has("ad_target") ? AppLovinAdImpl.AdTarget.valueOf(jSONObject.getString("ad_target").toUpperCase(Locale.ENGLISH)) : AppLovinAdImpl.AdTarget.DEFAULT;
        AppLovinAdType fromString2 = jSONObject.has("ad_type") ? AppLovinAdType.fromString(jSONObject.getString("ad_type").toUpperCase(Locale.ENGLISH)) : AppLovinAdType.REGULAR;
        this.f629j = new C0347c(fromString, fromString2);
        if (jSONObject.has("video")) {
            String string2 = jSONObject.getString("video");
            if (string2 == null || string2.isEmpty()) {
                str2 = null;
            } else {
                try {
                    str3 = this.f627d.mo5696a(this.f440h, string2);
                    this.f628i = true;
                    str2 = str3;
                } catch (Exception e) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                mo5643c();
                return;
            }
            str3 = str2;
        }
        long j = -1;
        if (jSONObject.has("ad_id")) {
            j = jSONObject.getLong("ad_id");
        }
        if (jSONObject.has("countdown_length")) {
            try {
                i = jSONObject.getInt("countdown_length");
            } catch (JSONException e2) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (jSONObject.has("close_delay")) {
            try {
                i2 = jSONObject.getInt("close_delay");
            } catch (JSONException e3) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (jSONObject.has("close_delay_graphic")) {
            try {
                a = (float) jSONObject.getInt("close_delay_graphic");
            } catch (JSONException e4) {
                a = m528a(str3, fromString2, i2);
            }
        } else {
            a = m528a(str3, fromString2, i2);
        }
        if (jSONObject.has("close_style")) {
            try {
                a2 = m529a(jSONObject.getInt("close_style"));
            } catch (JSONException e5) {
                a2 = m530a(str3);
            }
        } else {
            a2 = m530a(str3);
        }
        if (jSONObject.has("clcodes")) {
            try {
                str = ((JSONArray) jSONObject.get("clcodes")).getString(0);
            } catch (JSONException e6) {
                str = "";
            }
        } else {
            str = "";
        }
        String str4 = "";
        if (jSONObject.has("video_end_url")) {
            try {
                str4 = jSONObject.getString("video_end_url");
            } catch (Exception e7) {
            }
        }
        String str5 = "";
        if (jSONObject.has("mute_image")) {
            try {
                str5 = this.f438f.getFileManager().mo5697a(this.f440h, jSONObject.getString("mute_image"), false);
            } catch (Exception e8) {
            }
        }
        String str6 = "";
        if (jSONObject.has("unmute_image")) {
            try {
                str6 = this.f438f.getFileManager().mo5697a(this.f440h, jSONObject.getString("unmute_image"), false);
            } catch (Exception e9) {
            }
        }
        String str7 = "";
        if (jSONObject.has("click_tracking_url")) {
            try {
                str7 = jSONObject.getString("click_tracking_url");
            } catch (Exception e10) {
            }
        }
        mo5642a((AppLovinAd) new AppLovinAdImpl.Builder().setHtml(b).setSize(fromString).setType(fromString2).setVideoFilename(str3).setTarget(valueOf).setCloseStyle(a2).setVideoCloseDelay((float) i2).setPoststitialCloseDelay(a).setCountdownLength(i).setCurrentAdIdNumber(j).setClCode(str).setCompletionUrl(str4).setSupplementalClickTrackingUrl(str7).setMuteImageFilename(str5).setUnmuteImageFilename(str6).build());
    }

    /* renamed from: b */
    private String m533b(String str) {
        return ((Boolean) this.f438f.mo5363a(C0343bw.f448H)).booleanValue() ? m534c(str) : str;
    }

    /* renamed from: c */
    private String m534c(String str) {
        StringBuilder sb = new StringBuilder(str);
        String[] split = ((String) this.f438f.mo5363a(C0343bw.f449I)).split(",");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str2 = split[i];
            int i2 = 0;
            int i3 = 0;
            while (i3 < sb.length() && (i3 = sb.indexOf(str2, i2)) != -1) {
                int length2 = sb.length();
                i2 = i3;
                while (!this.f624a.contains(Character.valueOf(sb.charAt(i2))) && i2 < length2) {
                    i2++;
                }
                if (i2 <= i3 || i2 == length2) {
                    this.f439g.mo5665d(this.f437e, "Unable to cache resource; ad HTML is invalid.");
                } else {
                    String a = m531a(str2, sb.substring(str2.length() + i3, i2));
                    if (a != null) {
                        sb.replace(i3, i2, a);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    private Collection m535d() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f438f.mo5363a(C0343bw.f509ap)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5642a(AppLovinAd appLovinAd) {
        this.f438f.getLogger().mo5665d(mo5537a(), "Rendered new ad:" + appLovinAd);
        if (this.f626c != null) {
            this.f626c.adReceived(appLovinAd);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5643c() {
        try {
            if (this.f626c == null) {
                return;
            }
            if (this.f626c instanceof C0401w) {
                ((C0401w) this.f626c).mo5462a(this.f629j, -6);
            } else {
                this.f626c.failedToReceiveAd(-6);
            }
        } catch (Throwable th) {
            this.f439g.mo5667e(this.f437e, "Unable process a failure to receive an ad", th);
        }
    }

    /* renamed from: e */
    public String mo5629e() {
        return "tRA";
    }

    /* renamed from: f */
    public boolean mo5630f() {
        return this.f628i;
    }

    public void run() {
        this.f439g.mo5665d(this.f437e, "Rendering ad...");
        try {
            m532a(this.f625b);
        } catch (JSONException e) {
            this.f439g.mo5667e(this.f437e, "Unable to parse ad service response", e);
            mo5643c();
        } catch (IllegalArgumentException e2) {
            this.f439g.mo5667e(this.f437e, "Ad response is not valid", e2);
            mo5643c();
        } catch (Exception e3) {
            this.f439g.mo5667e(this.f437e, "Unable to render ad", e3);
            mo5643c();
        }
    }
}
