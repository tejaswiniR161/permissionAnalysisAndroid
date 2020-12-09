package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzew implements zzev {
    private final Context mContext;
    private final VersionInfoParcel zzanh;

    @zziy
    static class zza {
        private final String mValue;
        private final String zzbaf;

        public zza(String str, String str2) {
            this.zzbaf = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzbaf;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zziy
    static class zzb {
        private final String zzbna;
        private final URL zzbnb;
        private final ArrayList<zza> zzbnc;
        private final String zzbnd;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzbna = str;
            this.zzbnb = url;
            if (arrayList == null) {
                this.zzbnc = new ArrayList<>();
            } else {
                this.zzbnc = arrayList;
            }
            this.zzbnd = str2;
        }

        public String zzmc() {
            return this.zzbna;
        }

        public URL zzmd() {
            return this.zzbnb;
        }

        public ArrayList<zza> zzme() {
            return this.zzbnc;
        }

        public String zzmf() {
            return this.zzbnd;
        }
    }

    @zziy
    class zzc {
        private final zzd zzbne;
        private final boolean zzbnf;
        private final String zzbng;

        public zzc(boolean z, zzd zzd, String str) {
            this.zzbnf = z;
            this.zzbne = zzd;
            this.zzbng = str;
        }

        public String getReason() {
            return this.zzbng;
        }

        public boolean isSuccess() {
            return this.zzbnf;
        }

        public zzd zzmg() {
            return this.zzbne;
        }
    }

    @zziy
    static class zzd {
        private final String zzbjs;
        private final String zzbna;
        private final int zzbnh;
        private final List<zza> zzbni;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzbna = str;
            this.zzbnh = i;
            if (list == null) {
                this.zzbni = new ArrayList();
            } else {
                this.zzbni = list;
            }
            this.zzbjs = str2;
        }

        public String getBody() {
            return this.zzbjs;
        }

        public int getResponseCode() {
            return this.zzbnh;
        }

        public String zzmc() {
            return this.zzbna;
        }

        public Iterable<zza> zzmh() {
            return this.zzbni;
        }
    }

    public zzew(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzanh = versionInfoParcel;
    }

    /* access modifiers changed from: protected */
    public zzc zza(zzb zzb2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzb2.zzmd().openConnection();
            zzu.zzfz().zza(this.mContext, this.zzanh.zzcs, false, httpURLConnection);
            Iterator<zza> it = zzb2.zzme().iterator();
            while (it.hasNext()) {
                zza next = it.next();
                httpURLConnection.addRequestProperty(next.getKey(), next.getValue());
            }
            if (!TextUtils.isEmpty(zzb2.zzmf())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzb2.zzmf().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), zza2));
                    }
                }
            }
            return new zzc(true, new zzd(zzb2.zzmc(), httpURLConnection.getResponseCode(), arrayList, zzu.zzfz().zza(new InputStreamReader(httpURLConnection.getInputStream()))), (String) null);
        } catch (Exception e) {
            return new zzc(false, (zzd) null, e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zza(zzd zzd2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd2.zzmc());
            if (zzd2.getBody() != null) {
                jSONObject.put("body", zzd2.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza next : zzd2.zzmh()) {
                jSONArray.put(new JSONObject().put("key", next.getKey()).put(FirebaseAnalytics.Param.VALUE, next.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd2.getResponseCode());
        } catch (JSONException e) {
            zzkn.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzlt zzlt, final Map<String, String> map) {
        zzkq.zza((Runnable) new Runnable() {
            public void run() {
                zzkn.zzdd("Received Http request.");
                final JSONObject zzay = zzew.this.zzay((String) map.get("http_request"));
                if (zzay == null) {
                    zzkn.m1352e("Response should not be null.");
                } else {
                    zzkr.zzcrf.post(new Runnable() {
                        public void run() {
                            zzlt.zzb("fetchHttpRequestCompleted", zzay);
                            zzkn.zzdd("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    public JSONObject zzay(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                zzc zza2 = zza(zzc(jSONObject));
                if (zza2.isSuccess()) {
                    jSONObject2.put("response", zza(zza2.zzmg()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza2.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzkn.m1352e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzb zzc(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", (String) null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzkn.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString(FirebaseAnalytics.Param.VALUE)));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
