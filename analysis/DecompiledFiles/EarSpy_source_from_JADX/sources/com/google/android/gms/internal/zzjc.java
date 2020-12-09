package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzjl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzjc {
    private static final SimpleDateFormat zzcjy = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144 A[Catch:{ JSONException -> 0x022d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r46, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r47, java.lang.String r48) {
        /*
            org.json.JSONObject r28 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022d }
            r0 = r28
            r1 = r48
            r0.<init>(r1)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "ad_base_url"
            r5 = 0
            r0 = r28
            java.lang.String r6 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "ad_url"
            r5 = 0
            r0 = r28
            java.lang.String r7 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "ad_size"
            r5 = 0
            r0 = r28
            java.lang.String r19 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "ad_slot_size"
            r0 = r28
            r1 = r19
            java.lang.String r43 = r0.optString(r4, r1)     // Catch:{ JSONException -> 0x022d }
            if (r47 == 0) goto L_0x00cf
            r0 = r47
            int r4 = r0.zzcga     // Catch:{ JSONException -> 0x022d }
            if (r4 == 0) goto L_0x00cf
            r27 = 1
        L_0x0038:
            java.lang.String r4 = "ad_json"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            if (r5 != 0) goto L_0x004c
            java.lang.String r4 = "ad_html"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
        L_0x004c:
            if (r5 != 0) goto L_0x0057
            java.lang.String r4 = "body"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
        L_0x0057:
            r20 = -1
            java.lang.String r4 = "debug_dialog"
            r8 = 0
            r0 = r28
            java.lang.String r22 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "debug_signals"
            r8 = 0
            r0 = r28
            java.lang.String r45 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x022d }
            if (r4 == 0) goto L_0x00d3
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            double r8 = r0.getDouble(r4)     // Catch:{ JSONException -> 0x022d }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r12 = (long) r8     // Catch:{ JSONException -> 0x022d }
        L_0x0084:
            java.lang.String r4 = "orientation"
            r8 = 0
            r0 = r28
            java.lang.String r4 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x022d }
            r18 = -1
            java.lang.String r8 = "portrait"
            boolean r8 = r8.equals(r4)     // Catch:{ JSONException -> 0x022d }
            if (r8 == 0) goto L_0x00d6
            com.google.android.gms.internal.zzks r4 = com.google.android.gms.ads.internal.zzu.zzgb()     // Catch:{ JSONException -> 0x022d }
            int r18 = r4.zzun()     // Catch:{ JSONException -> 0x022d }
        L_0x009f:
            r4 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x022d }
            if (r8 == 0) goto L_0x0262
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x022d }
            if (r8 != 0) goto L_0x0262
            r0 = r47
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r0.zzaqv     // Catch:{ JSONException -> 0x022d }
            java.lang.String r6 = r4.zzcs     // Catch:{ JSONException -> 0x022d }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r47
            r5 = r46
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = com.google.android.gms.internal.zzjb.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r6 = r4.zzbyj     // Catch:{ JSONException -> 0x022d }
            java.lang.String r7 = r4.body     // Catch:{ JSONException -> 0x022d }
            long r0 = r4.zzchg     // Catch:{ JSONException -> 0x022d }
            r20 = r0
        L_0x00c6:
            if (r7 != 0) goto L_0x00e7
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x022d }
            r5 = 0
            r4.<init>(r5)     // Catch:{ JSONException -> 0x022d }
        L_0x00ce:
            return r4
        L_0x00cf:
            r27 = 0
            goto L_0x0038
        L_0x00d3:
            r12 = -1
            goto L_0x0084
        L_0x00d6:
            java.lang.String r8 = "landscape"
            boolean r4 = r8.equals(r4)     // Catch:{ JSONException -> 0x022d }
            if (r4 == 0) goto L_0x009f
            com.google.android.gms.internal.zzks r4 = com.google.android.gms.ads.internal.zzu.zzgb()     // Catch:{ JSONException -> 0x022d }
            int r18 = r4.zzum()     // Catch:{ JSONException -> 0x022d }
            goto L_0x009f
        L_0x00e7:
            java.lang.String r5 = "click_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x022d }
            if (r4 != 0) goto L_0x024d
            r8 = 0
        L_0x00f2:
            if (r5 == 0) goto L_0x00f8
            java.util.List r8 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r8)     // Catch:{ JSONException -> 0x022d }
        L_0x00f8:
            java.lang.String r5 = "impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x022d }
            if (r4 != 0) goto L_0x0251
            r9 = 0
        L_0x0103:
            if (r5 == 0) goto L_0x0109
            java.util.List r9 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r9)     // Catch:{ JSONException -> 0x022d }
        L_0x0109:
            java.lang.String r5 = "manual_impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x022d }
            if (r4 != 0) goto L_0x0255
            r15 = 0
        L_0x0114:
            if (r5 == 0) goto L_0x011a
            java.util.List r15 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r15)     // Catch:{ JSONException -> 0x022d }
        L_0x011a:
            if (r4 == 0) goto L_0x025f
            int r5 = r4.orientation     // Catch:{ JSONException -> 0x022d }
            r10 = -1
            if (r5 == r10) goto L_0x0125
            int r0 = r4.orientation     // Catch:{ JSONException -> 0x022d }
            r18 = r0
        L_0x0125:
            long r10 = r4.zzchb     // Catch:{ JSONException -> 0x022d }
            r16 = 0
            int r5 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x025f
            long r10 = r4.zzchb     // Catch:{ JSONException -> 0x022d }
        L_0x012f:
            java.lang.String r4 = "active_view"
            r0 = r28
            java.lang.String r25 = r0.optString(r4)     // Catch:{ JSONException -> 0x022d }
            r24 = 0
            java.lang.String r4 = "ad_is_javascript"
            r5 = 0
            r0 = r28
            boolean r23 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            if (r23 == 0) goto L_0x014d
            java.lang.String r4 = "ad_passback_url"
            r5 = 0
            r0 = r28
            java.lang.String r24 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
        L_0x014d:
            java.lang.String r4 = "mediation"
            r5 = 0
            r0 = r28
            boolean r12 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "custom_render_allowed"
            r5 = 0
            r0 = r28
            boolean r26 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "content_url_opted_out"
            r5 = 1
            r0 = r28
            boolean r29 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "prefetch"
            r5 = 0
            r0 = r28
            boolean r30 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "refresh_interval_milliseconds"
            r16 = -1
            r0 = r28
            r1 = r16
            long r16 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "mediation_config_cache_time_milliseconds"
            r32 = -1
            r0 = r28
            r1 = r32
            long r13 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "gws_query_id"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r31 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "height"
            java.lang.String r5 = "fluid"
            java.lang.String r32 = ""
            r0 = r28
            r1 = r32
            java.lang.String r5 = r0.optString(r5, r1)     // Catch:{ JSONException -> 0x022d }
            boolean r32 = r4.equals(r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "native_express"
            r5 = 0
            r0 = r28
            boolean r33 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "video_start_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x022d }
            r5 = 0
            java.util.List r35 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "video_complete_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x022d }
            r5 = 0
            java.util.List r36 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "rewards"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x022d }
            com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel r34 = com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel.zza(r4)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "use_displayed_impression"
            r5 = 0
            r0 = r28
            boolean r37 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "auto_protection_configuration"
            r0 = r28
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ JSONException -> 0x022d }
            com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel r38 = com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel.zzi(r4)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "set_cookie"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r40 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "remote_ping_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x022d }
            r5 = 0
            java.util.List r41 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "safe_browsing"
            r0 = r28
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ JSONException -> 0x022d }
            com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel r44 = com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel.zzk(r4)     // Catch:{ JSONException -> 0x022d }
            java.lang.String r4 = "render_in_browser"
            r0 = r47
            boolean r5 = r0.zzbsh     // Catch:{ JSONException -> 0x022d }
            r0 = r28
            boolean r42 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x022d }
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x022d }
            r0 = r47
            boolean r0 = r0.zzcgc     // Catch:{ JSONException -> 0x022d }
            r28 = r0
            r0 = r47
            boolean r0 = r0.zzcgt     // Catch:{ JSONException -> 0x022d }
            r39 = r0
            r5 = r47
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45)     // Catch:{ JSONException -> 0x022d }
            goto L_0x00ce
        L_0x022d:
            r4 = move-exception
            java.lang.String r5 = "Could not parse the inline ad response: "
            java.lang.String r4 = r4.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r6 = r4.length()
            if (r6 == 0) goto L_0x0259
            java.lang.String r4 = r5.concat(r4)
        L_0x0242:
            com.google.android.gms.internal.zzkn.zzdf(r4)
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r5 = 0
            r4.<init>(r5)
            goto L_0x00ce
        L_0x024d:
            java.util.List<java.lang.String> r8 = r4.zzbsd     // Catch:{ JSONException -> 0x022d }
            goto L_0x00f2
        L_0x0251:
            java.util.List<java.lang.String> r9 = r4.zzbse     // Catch:{ JSONException -> 0x022d }
            goto L_0x0103
        L_0x0255:
            java.util.List<java.lang.String> r15 = r4.zzche     // Catch:{ JSONException -> 0x022d }
            goto L_0x0114
        L_0x0259:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r5)
            goto L_0x0242
        L_0x025f:
            r10 = r12
            goto L_0x012f
        L_0x0262:
            r7 = r5
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjc.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    public static JSONObject zza(Context context, zziz zziz) {
        AdRequestInfoParcel adRequestInfoParcel = zziz.zzcix;
        Location location = zziz.zzawl;
        zzjh zzjh = zziz.zzciy;
        Bundle bundle = zziz.zzcgb;
        JSONObject jSONObject = zziz.zzciz;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("extra_caps", zzdi.zzbfr.get());
            if (zziz.zzcgk.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zziz.zzcgk));
            }
            if (adRequestInfoParcel.zzcft != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzcft);
            }
            zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.zzcfu);
            if (adRequestInfoParcel.zzaqz.zzaxk != null) {
                boolean z = false;
                boolean z2 = false;
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzaqz.zzaxk) {
                    if (!adSizeParcel.zzaxm && !z2) {
                        hashMap.put("format", adSizeParcel.zzaxi);
                        z2 = true;
                    }
                    if (adSizeParcel.zzaxm && !z) {
                        hashMap.put("fluid", "height");
                        z = true;
                    }
                    if (z2 && z) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", adRequestInfoParcel.zzaqz.zzaxi);
                if (adRequestInfoParcel.zzaqz.zzaxm) {
                    hashMap.put("fluid", "height");
                }
            }
            if (adRequestInfoParcel.zzaqz.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzaqz.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzaqz.zzaxk != null) {
                StringBuilder sb = new StringBuilder();
                boolean z3 = false;
                for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.zzaqz.zzaxk) {
                    if (adSizeParcel2.zzaxm) {
                        z3 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        sb.append(adSizeParcel2.width == -1 ? (int) (((float) adSizeParcel2.widthPixels) / zzjh.zzcgg) : adSizeParcel2.width);
                        sb.append("x");
                        sb.append(adSizeParcel2.height == -2 ? (int) (((float) adSizeParcel2.heightPixels) / zzjh.zzcgg) : adSizeParcel2.height);
                    }
                }
                if (z3) {
                    if (sb.length() != 0) {
                        sb.insert(0, "|");
                    }
                    sb.insert(0, "320x50");
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.zzcga != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzcga));
                hashMap.put("native_templates", adRequestInfoParcel.zzarr);
                hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzarn));
                if (!adRequestInfoParcel.zzcgl.isEmpty()) {
                    hashMap.put("native_custom_templates", adRequestInfoParcel.zzcgl);
                }
            }
            if (adRequestInfoParcel.zzaqz.zzaxn) {
                hashMap.put("ene", true);
            }
            hashMap.put("slotname", adRequestInfoParcel.zzaqt);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzcfv != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzcfv.versionCode));
            }
            hashMap.put("ms", zziz.zzcfw);
            hashMap.put("seq_num", adRequestInfoParcel.zzcfx);
            hashMap.put("session_id", adRequestInfoParcel.zzcfy);
            hashMap.put("js", adRequestInfoParcel.zzaqv.zzcs);
            zza(hashMap, zzjh, zziz.zzciv, adRequestInfoParcel.zzcgy, zziz.zzciu);
            zza((HashMap<String, Object>) hashMap, zziz.zzciw);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                zza((HashMap<String, Object>) hashMap, location);
            } else if (adRequestInfoParcel.zzcfu.versionCode >= 2 && adRequestInfoParcel.zzcfu.zzawl != null) {
                zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.zzcfu.zzawl);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzcfz);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzcgc) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzcgc));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzcgg));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzcgf));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzcge));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzjh.zzcgg));
                hashMap.put("sh", Integer.valueOf(zzjh.zzcgf));
                hashMap.put("sw", Integer.valueOf(zzjh.zzcge));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcgh)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzcgh));
                    } catch (JSONException e) {
                        zzkn.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzcgi));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzcgj);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzcgn != null) {
                hashMap.put("capability", adRequestInfoParcel.zzcgn.toBundle());
            }
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzcgo)) {
                hashMap.put("anchor", adRequestInfoParcel.zzcgo);
            }
            if (adRequestInfoParcel.versionCode >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(adRequestInfoParcel.zzcgp));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(adRequestInfoParcel.zzcgv));
            }
            if (adRequestInfoParcel.versionCode >= 14 && adRequestInfoParcel.zzcgq > 0) {
                hashMap.put("target_api", Integer.valueOf(adRequestInfoParcel.zzcgq));
            }
            if (adRequestInfoParcel.versionCode >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(adRequestInfoParcel.zzcgr == -1 ? -1 : adRequestInfoParcel.zzcgr));
            }
            if (adRequestInfoParcel.versionCode >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(adRequestInfoParcel.zzcgs));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcgw)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(adRequestInfoParcel.zzcgw));
                    } catch (JSONException e2) {
                        zzkn.zzd("Problem creating json from app settings", e2);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(adRequestInfoParcel.zzbsh));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(adRequestInfoParcel.zzcgx));
            }
            zza(hashMap);
            hashMap.put("cache_state", jSONObject);
            if (adRequestInfoParcel.versionCode >= 19) {
                hashMap.put("gct", adRequestInfoParcel.zzcgz);
            }
            if (zzkn.zzbf(2)) {
                String valueOf = String.valueOf(zzu.zzfz().zzan((Map<String, ?>) hashMap).toString(2));
                zzkn.m1493v(valueOf.length() != 0 ? "Ad Request JSON: ".concat(valueOf) : new String("Ad Request JSON: "));
            }
            return zzu.zzfz().zzan((Map<String, ?>) hashMap);
        } catch (JSONException e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            zzkn.zzdf(valueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(valueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString("cl", "134102376");
        bundle2.putString("rapid_rc", "dev");
        bundle2.putString("rapid_rollup", "HEAD");
        bundle.putBundle("build_meta", bundle2);
        bundle.putString("mf", Boolean.toString(zzdi.zzbft.get().booleanValue()));
        hashMap.put("sdk_env", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzub = zzkl.zzub();
        if (zzub != null) {
            hashMap.put("abf", zzub);
        }
        if (adRequestParcel.zzawd != -1) {
            hashMap.put("cust_age", zzcjy.format(new Date(adRequestParcel.zzawd)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzawe != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zzawe));
        }
        if (adRequestParcel.zzawf != null) {
            hashMap.put("kw", adRequestParcel.zzawf);
        }
        if (adRequestParcel.zzawh != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzawh));
        }
        if (adRequestParcel.zzawg) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzawi) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzawj)) {
                hashMap.put("ppid", adRequestParcel.zzawj);
            }
            if (adRequestParcel.zzawk != null) {
                zza(hashMap, adRequestParcel.zzawk);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzawm != null) {
            hashMap.put("url", adRequestParcel.zzawm);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzawo != null) {
                hashMap.put("custom_targeting", adRequestParcel.zzawo);
            }
            if (adRequestParcel.zzawp != null) {
                hashMap.put("category_exclusions", adRequestParcel.zzawp);
            }
            if (adRequestParcel.zzawq != null) {
                hashMap.put("request_agent", adRequestParcel.zzawq);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zzawr != null) {
            hashMap.put("request_pkg", adRequestParcel.zzawr);
        }
        if (adRequestParcel.versionCode >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zzaws));
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzazp) != 0) {
            hashMap.put("acolor", zzaw(searchAdRequestParcel.zzazp));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzaw(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzazq) == 0 || Color.alpha(searchAdRequestParcel.zzazr) == 0)) {
            hashMap.put("gradientto", zzaw(searchAdRequestParcel.zzazq));
            hashMap.put("gradientfrom", zzaw(searchAdRequestParcel.zzazr));
        }
        if (Color.alpha(searchAdRequestParcel.zzazs) != 0) {
            hashMap.put("bcolor", zzaw(searchAdRequestParcel.zzazs));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zzazt));
        switch (searchAdRequestParcel.zzazu) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (searchAdRequestParcel.zzazv) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zzazw != null) {
            hashMap.put("channel", searchAdRequestParcel.zzazw);
        }
        if (Color.alpha(searchAdRequestParcel.zzazx) != 0) {
            hashMap.put("dcolor", zzaw(searchAdRequestParcel.zzazx));
        }
        if (searchAdRequestParcel.zzazy != null) {
            hashMap.put("font", searchAdRequestParcel.zzazy);
        }
        if (Color.alpha(searchAdRequestParcel.zzazz) != 0) {
            hashMap.put("hcolor", zzaw(searchAdRequestParcel.zzazz));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzbaa));
        if (searchAdRequestParcel.zzbab != null) {
            hashMap.put("q", searchAdRequestParcel.zzbab);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzjh zzjh, zzjl.zza zza, Bundle bundle, Bundle bundle2) {
        hashMap.put("am", Integer.valueOf(zzjh.zzclr));
        hashMap.put("cog", zzac(zzjh.zzcls));
        hashMap.put("coh", zzac(zzjh.zzclt));
        if (!TextUtils.isEmpty(zzjh.zzclu)) {
            hashMap.put("carrier", zzjh.zzclu);
        }
        hashMap.put("gl", zzjh.zzclv);
        if (zzjh.zzclw) {
            hashMap.put("simulator", 1);
        }
        if (zzjh.zzclx) {
            hashMap.put("is_sidewinder", 1);
        }
        hashMap.put("ma", zzac(zzjh.zzcly));
        hashMap.put("sp", zzac(zzjh.zzclz));
        hashMap.put("hl", zzjh.zzcma);
        if (!TextUtils.isEmpty(zzjh.zzcmb)) {
            hashMap.put("mv", zzjh.zzcmb);
        }
        hashMap.put("muv", Integer.valueOf(zzjh.zzcmc));
        if (zzjh.zzcmd != -2) {
            hashMap.put("cnt", Integer.valueOf(zzjh.zzcmd));
        }
        hashMap.put("gnt", Integer.valueOf(zzjh.zzcme));
        hashMap.put("pt", Integer.valueOf(zzjh.zzcmf));
        hashMap.put("rm", Integer.valueOf(zzjh.zzcmg));
        hashMap.put("riv", Integer.valueOf(zzjh.zzcmh));
        Bundle bundle3 = new Bundle();
        bundle3.putString("build", zzjh.zzcmm);
        Bundle bundle4 = new Bundle();
        bundle4.putBoolean("is_charging", zzjh.zzcmj);
        bundle4.putDouble("battery_level", zzjh.zzcmi);
        bundle3.putBundle("battery", bundle4);
        Bundle bundle5 = new Bundle();
        bundle5.putInt("active_network_state", zzjh.zzcml);
        bundle5.putBoolean("active_network_metered", zzjh.zzcmk);
        if (zza != null) {
            Bundle bundle6 = new Bundle();
            bundle6.putInt("predicted_latency_micros", 0);
            bundle6.putLong("predicted_down_throughput_bps", 0);
            bundle6.putLong("predicted_up_throughput_bps", 0);
            bundle5.putBundle("predictions", bundle6);
        }
        bundle3.putBundle("network", bundle5);
        Bundle bundle7 = new Bundle();
        bundle7.putBoolean("is_browser_custom_tabs_capable", zzjh.zzcmn);
        bundle3.putBundle("browser", bundle7);
        if (bundle != null) {
            bundle3.putBundle("android_mem_info", zzg(bundle));
        }
        Bundle bundle8 = new Bundle();
        bundle8.putBundle("parental_controls", bundle2);
        bundle3.putBundle("play_store", bundle8);
        hashMap.put("device", bundle3);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", str);
        hashMap.put("pii", bundle);
    }

    private static Integer zzac(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String zzaw(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzblc : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.zzbyj != null) {
            jSONObject.put("ad_base_url", adResponseParcel.zzbyj);
        }
        if (adResponseParcel.zzchf != null) {
            jSONObject.put("ad_size", adResponseParcel.zzchf);
        }
        jSONObject.put("native", adResponseParcel.zzaxl);
        if (adResponseParcel.zzaxl) {
            jSONObject.put("ad_json", adResponseParcel.body);
        } else {
            jSONObject.put("ad_html", adResponseParcel.body);
        }
        if (adResponseParcel.zzchh != null) {
            jSONObject.put("debug_dialog", adResponseParcel.zzchh);
        }
        if (adResponseParcel.zzchy != null) {
            jSONObject.put("debug_signals", adResponseParcel.zzchy);
        }
        if (adResponseParcel.zzchb != -1) {
            jSONObject.put("interstitial_timeout", ((double) adResponseParcel.zzchb) / 1000.0d);
        }
        if (adResponseParcel.orientation == zzu.zzgb().zzun()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.orientation == zzu.zzgb().zzum()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.zzbsd != null) {
            jSONObject.put("click_urls", zzl(adResponseParcel.zzbsd));
        }
        if (adResponseParcel.zzbse != null) {
            jSONObject.put("impression_urls", zzl(adResponseParcel.zzbse));
        }
        if (adResponseParcel.zzche != null) {
            jSONObject.put("manual_impression_urls", zzl(adResponseParcel.zzche));
        }
        if (adResponseParcel.zzchk != null) {
            jSONObject.put("active_view", adResponseParcel.zzchk);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.zzchi);
        if (adResponseParcel.zzchj != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.zzchj);
        }
        jSONObject.put("mediation", adResponseParcel.zzchc);
        jSONObject.put("custom_render_allowed", adResponseParcel.zzchl);
        jSONObject.put("content_url_opted_out", adResponseParcel.zzchm);
        jSONObject.put("prefetch", adResponseParcel.zzchn);
        if (adResponseParcel.zzbsj != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.zzbsj);
        }
        if (adResponseParcel.zzchd != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.zzchd);
        }
        if (!TextUtils.isEmpty(adResponseParcel.zzchq)) {
            jSONObject.put("gws_query_id", adResponseParcel.zzchq);
        }
        jSONObject.put("fluid", adResponseParcel.zzaxm ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.zzaxn);
        if (adResponseParcel.zzchs != null) {
            jSONObject.put("video_start_urls", zzl(adResponseParcel.zzchs));
        }
        if (adResponseParcel.zzcht != null) {
            jSONObject.put("video_complete_urls", zzl(adResponseParcel.zzcht));
        }
        if (adResponseParcel.zzchr != null) {
            jSONObject.put("rewards", adResponseParcel.zzchr.zzsx());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.zzchu);
        jSONObject.put("auto_protection_configuration", adResponseParcel.zzchv);
        jSONObject.put("render_in_browser", adResponseParcel.zzbsh);
        return jSONObject;
    }

    private static Bundle zzg(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    @Nullable
    static JSONArray zzl(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }
}
