package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzje {
    private int mOrientation = -1;
    private boolean zzazd = false;
    private String zzbjs;
    private final AdRequestInfoParcel zzbtk;
    private List<String> zzcea;
    private String zzckg;
    private String zzckh;
    private List<String> zzcki;
    private String zzckj;
    private String zzckk;
    private String zzckl;
    private List<String> zzckm;
    private long zzckn = -1;
    private boolean zzcko = false;
    private final long zzckp = -1;
    private long zzckq = -1;
    private boolean zzckr = false;
    private boolean zzcks = false;
    private boolean zzckt = false;
    private boolean zzcku = true;
    private String zzckv = "";
    private boolean zzckw = false;
    private RewardItemParcel zzckx;
    private List<String> zzcky;
    private List<String> zzckz;
    private boolean zzcla = false;
    private AutoClickProtectionConfigurationParcel zzclb;
    private boolean zzclc = false;
    private String zzcld;
    private List<String> zzcle;
    private boolean zzclf;
    private String zzclg;
    private SafeBrowsingConfigParcel zzclh;

    public zzje(AdRequestInfoParcel adRequestInfoParcel) {
        this.zzbtk = adRequestInfoParcel;
    }

    private void zzaa(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.zzcku = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzab(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.zzckv = (String) list.get(0);
        }
    }

    private void zzac(Map<String, List<String>> map) {
        String zzd = zzd(map, "X-Afma-Fluid");
        if (zzd != null && zzd.equals("height")) {
            this.zzckw = true;
        }
    }

    private void zzad(Map<String, List<String>> map) {
        this.zzazd = "native_express".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzae(Map<String, List<String>> map) {
        this.zzckx = RewardItemParcel.zzcp(zzd(map, "X-Afma-Rewards"));
    }

    private void zzaf(Map<String, List<String>> map) {
        if (this.zzcky == null) {
            this.zzcky = zzf(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void zzag(Map<String, List<String>> map) {
        if (this.zzckz == null) {
            this.zzckz = zzf(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void zzah(Map<String, List<String>> map) {
        this.zzcla |= zzg(map, "X-Afma-Use-Displayed-Impression");
    }

    private void zzai(Map<String, List<String>> map) {
        this.zzclc |= zzg(map, "X-Afma-Auto-Collect-Location");
    }

    private void zzaj(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Remote-Ping-Urls");
        if (zzf != null) {
            this.zzcle = zzf;
        }
    }

    private void zzak(Map<String, List<String>> map) {
        String zzd = zzd(map, "X-Afma-Auto-Protection-Configuration");
        if (zzd == null || TextUtils.isEmpty(zzd)) {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzckk)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzckk);
            }
            boolean booleanValue = zzdi.zzbaw.get().booleanValue();
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            this.zzclb = new AutoClickProtectionConfigurationParcel(booleanValue, Arrays.asList(new String[]{new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString()}));
            return;
        }
        try {
            this.zzclb = AutoClickProtectionConfigurationParcel.zzi(new JSONObject(zzd));
        } catch (JSONException e) {
            zzkn.zzd("Error parsing configuration JSON", e);
            this.zzclb = new AutoClickProtectionConfigurationParcel();
        }
    }

    private void zzal(Map<String, List<String>> map) {
        this.zzcld = zzd(map, "Set-Cookie");
    }

    private void zzam(Map<String, List<String>> map) {
        String zzd = zzd(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zzd)) {
            try {
                this.zzclh = SafeBrowsingConfigParcel.zzk(new JSONObject(zzd));
            } catch (JSONException e) {
                zzkn.zzd("Error parsing safe browsing header", e);
            }
        }
    }

    static String zzd(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    static long zze(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzkn.zzdf(new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    static List<String> zzf(Map<String, List<String>> map, String str) {
        String str2;
        List list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = (String) list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private boolean zzg(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        return list != null && !list.isEmpty() && Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    private void zzk(Map<String, List<String>> map) {
        this.zzckg = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzl(Map<String, List<String>> map) {
        this.zzclg = zzd(map, "X-Afma-Ad-Slot-Size");
    }

    private void zzm(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (zzf != null) {
            this.zzcki = zzf;
        }
    }

    private void zzn(Map<String, List<String>> map) {
        this.zzckj = zzd(map, "X-Afma-Debug-Signals");
    }

    private void zzo(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzckk = (String) list.get(0);
        }
    }

    private void zzp(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Tracking-Urls");
        if (zzf != null) {
            this.zzckm = zzf;
        }
    }

    private void zzq(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Interstitial-Timeout");
        if (zze != -1) {
            this.zzckn = zze;
        }
    }

    private void zzr(Map<String, List<String>> map) {
        this.zzckl = zzd(map, "X-Afma-ActiveView");
    }

    private void zzs(Map<String, List<String>> map) {
        this.zzcks = "native".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzt(Map<String, List<String>> map) {
        this.zzckr |= zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzu(Map<String, List<String>> map) {
        this.zzcko |= zzg(map, "X-Afma-Mediation");
    }

    private void zzv(Map<String, List<String>> map) {
        this.zzclf |= zzg(map, "X-Afma-Render-In-Browser");
    }

    private void zzw(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (zzf != null) {
            this.zzcea = zzf;
        }
    }

    private void zzx(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Refresh-Rate");
        if (zze != -1) {
            this.zzckq = zze;
        }
    }

    private void zzy(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = zzu.zzgb().zzun();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = zzu.zzgb().zzum();
            }
        }
    }

    private void zzz(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.zzckt = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzckh = str;
        this.zzbjs = str2;
        zzj(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.zzbtk, this.zzckh, this.zzbjs, this.zzcki, this.zzckm, this.zzckn, this.zzcko, -1, this.zzcea, this.zzckq, this.mOrientation, this.zzckg, j, this.zzckk, this.zzckl, this.zzckr, this.zzcks, this.zzckt, this.zzcku, false, this.zzckv, this.zzckw, this.zzazd, this.zzckx, this.zzcky, this.zzckz, this.zzcla, this.zzclb, this.zzclc, this.zzcld, this.zzcle, this.zzclf, this.zzclg, this.zzclh, this.zzckj);
    }

    public void zzj(Map<String, List<String>> map) {
        zzk(map);
        zzl(map);
        zzm(map);
        zzn(map);
        zzo(map);
        zzp(map);
        zzq(map);
        zzu(map);
        zzw(map);
        zzx(map);
        zzy(map);
        zzr(map);
        zzz(map);
        zzt(map);
        zzs(map);
        zzaa(map);
        zzab(map);
        zzac(map);
        zzad(map);
        zzae(map);
        zzaf(map);
        zzag(map);
        zzah(map);
        zzai(map);
        zzal(map);
        zzak(map);
        zzaj(map);
        zzam(map);
        zzv(map);
    }
}
