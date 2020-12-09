package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzk;
import java.util.Map;
import org.json.JSONObject;

@zziy
public final class zzff implements zzev {
    private boolean zzbnr;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return zzm.zzjr().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzkn.zzdf(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            return i;
        }
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        int i;
        int i2;
        String str = map.get("action");
        if (str == null) {
            zzkn.zzdf("Action missing from video GMSG.");
            return;
        }
        if (zzkn.zzbf(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            zzkn.zzdd(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzkn.zzdf("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzlt.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException e) {
                zzkn.zzdf("Invalid color parameter in video GMSG.");
            }
        } else {
            zzls zzvy = zzlt.zzvy();
            if (zzvy == null) {
                zzkn.zzdf("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzlt.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                if (zzdi.zzbge.get().booleanValue()) {
                    i = Math.min(zza3, zzlt.getMeasuredWidth() - zza);
                    zza4 = Math.min(zza4, zzlt.getMeasuredHeight() - zza2);
                } else {
                    i = zza3;
                }
                try {
                    i2 = Integer.parseInt(map.get("player"));
                } catch (NumberFormatException e2) {
                    i2 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean(map.get("spherical"));
                if (!equals || zzvy.zzvk() != null) {
                    zzvy.zze(zza, zza2, i, zza4);
                } else {
                    zzvy.zza(zza, zza2, i, zza4, i2, parseBoolean);
                }
            } else {
                zzk zzvk = zzvy.zzvk();
                if (zzvk == null) {
                    zzk.zzi(zzlt);
                } else if ("click".equals(str)) {
                    Context context2 = zzlt.getContext();
                    int zza5 = zza(context2, map, "x", 0);
                    int zza6 = zza(context2, map, "y", 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                    zzvk.zzf(obtain);
                    obtain.recycle();
                } else if ("currentTime".equals(str)) {
                    String str3 = map.get("time");
                    if (str3 == null) {
                        zzkn.zzdf("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        zzvk.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                    } catch (NumberFormatException e3) {
                        String valueOf2 = String.valueOf(str3);
                        zzkn.zzdf(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    }
                } else if ("hide".equals(str)) {
                    zzvk.setVisibility(4);
                } else if ("load".equals(str)) {
                    zzvk.zzmt();
                } else if ("muted".equals(str)) {
                    if (Boolean.parseBoolean(map.get("muted"))) {
                        zzvk.zzom();
                    } else {
                        zzvk.zzon();
                    }
                } else if ("pause".equals(str)) {
                    zzvk.pause();
                } else if ("play".equals(str)) {
                    zzvk.play();
                } else if ("show".equals(str)) {
                    zzvk.setVisibility(0);
                } else if ("src".equals(str)) {
                    zzvk.zzca(map.get("src"));
                } else if ("touchMove".equals(str)) {
                    Context context3 = zzlt.getContext();
                    zzvk.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                    if (!this.zzbnr) {
                        zzlt.zzvp().zzpa();
                        this.zzbnr = true;
                    }
                } else if ("volume".equals(str)) {
                    String str4 = map.get("volume");
                    if (str4 == null) {
                        zzkn.zzdf("Level parameter missing from volume video GMSG.");
                        return;
                    }
                    try {
                        zzvk.zza(Float.parseFloat(str4));
                    } catch (NumberFormatException e4) {
                        String valueOf3 = String.valueOf(str4);
                        zzkn.zzdf(valueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
                    }
                } else if ("watermark".equals(str)) {
                    zzvk.zzpn();
                } else {
                    String valueOf4 = String.valueOf(str);
                    zzkn.zzdf(valueOf4.length() != 0 ? "Unknown video action: ".concat(valueOf4) : new String("Unknown video action: "));
                }
            }
        }
    }
}
