package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzeu {
    public static final zzev zzbmb = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
        }
    };
    public static final zzev zzbmc = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzkn.zzdf("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzlt.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            zzlt.zza("openableURLs", (Map<String, ?>) hashMap);
        }
    };
    public static final zzev zzbmd = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            PackageManager packageManager = zzlt.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            String optString2 = jSONObject2.optString("u");
                            String optString3 = jSONObject2.optString("i");
                            String optString4 = jSONObject2.optString("m");
                            String optString5 = jSONObject2.optString("p");
                            String optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e) {
                                zzkn.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (JSONException e2) {
                            zzkn.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzlt.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzlt.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzlt.zzb("openableIntents", new JSONObject());
            }
        }
    };
    public static final zzev zzbme = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            Uri uri;
            String str = map.get("u");
            if (str == null) {
                zzkn.zzdf("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                zzau zzvt = zzlt.zzvt();
                if (zzvt != null && zzvt.zzc(parse)) {
                    uri = zzvt.zza(parse, zzlt.getContext(), zzlt.getView());
                    Future future = (Future) new zzlb(zzlt.getContext(), zzlt.zzvu().zzcs, uri.toString()).zzqw();
                }
            } catch (zzav e) {
                String valueOf = String.valueOf(str);
                zzkn.zzdf(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
            }
            uri = parse;
            Future future2 = (Future) new zzlb(zzlt.getContext(), zzlt.zzvu().zzcs, uri.toString()).zzqw();
        }
    };
    public static final zzev zzbmf = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            zzd zzvp = zzlt.zzvp();
            if (zzvp != null) {
                zzvp.close();
                return;
            }
            zzd zzvq = zzlt.zzvq();
            if (zzvq != null) {
                zzvq.close();
            } else {
                zzkn.zzdf("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzev zzbmg = new zzev() {
        private void zzd(zzlt zzlt) {
            zzm zzm;
            zzkn.zzde("Received support message, responding.");
            boolean z = false;
            com.google.android.gms.ads.internal.zzd zzdp = zzlt.zzdp();
            if (!(zzdp == null || (zzm = zzdp.zzame) == null)) {
                z = zzm.zzr(zzlt.getContext());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", z);
                zzlt.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void zza(zzlt zzlt, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzd(zzlt);
                return;
            }
            zzd zzvp = zzlt.zzvp();
            if (zzvp != null) {
                zzvp.zzf(zzlt, map);
            }
        }
    };
    public static final zzev zzbmh = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            zzlt.zzak("1".equals(map.get("custom_close")));
        }
    };
    public static final zzev zzbmi = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzkn.zzdf("URL missing from httpTrack GMSG.");
            } else {
                Future future = (Future) new zzlb(zzlt.getContext(), zzlt.zzvu().zzcs, str).zzqw();
            }
        }
    };
    public static final zzev zzbmj = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String valueOf = String.valueOf(map.get("string"));
            zzkn.zzde(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
        }
    };
    public static final zzev zzbmk = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            zzg zzwg = zzlt.zzwg();
            if (zzwg != null) {
                zzwg.zzlu();
            }
        }
    };
    public static final zzev zzbml = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzau zzvt = zzlt.zzvt();
                if (zzvt != null) {
                    zzvt.zzaw().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzkn.zzdf("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzev zzbmm = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (zzdi.zzbee.get().booleanValue()) {
                zzlt.zzal(!Boolean.parseBoolean(map.get("disabled")));
            }
        }
    };
    public static final zzev zzbmn = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String str = map.get("action");
            if ("pause".equals(str)) {
                zzlt.zzel();
            } else if ("resume".equals(str)) {
                zzlt.zzem();
            }
        }
    };
    public static final zzev zzbmo = new zzff();
    public static final zzev zzbmp = new zzfg();
    public static final zzev zzbmq = new zzfk();
    public static final zzev zzbmr = new zzet();
    public static final zzfd zzbms = new zzfd();
    public static final zzev zzbmt = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzlt.zzvr().zzwp();
            } else if (map.keySet().contains("stop")) {
                zzlt.zzvr().zzwq();
            } else if (map.keySet().contains("cancel")) {
                zzlt.zzvr().zzwr();
            }
        }
    };
    public static final zzev zzbmu = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzlt.zzam(true);
            }
            if (map.keySet().contains("stop")) {
                zzlt.zzam(false);
            }
        }
    };
    public static final zzev zzbmv = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            zzlt.zza("locationReady", (Map<String, ?>) zzu.zzfz().zza((View) zzlt, (WindowManager) zzlt.getContext().getSystemService("window")));
            zzkn.zzdf("GET LOCATION COMPILED");
        }
    };
}
