package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zziy
public final class zzfc implements zzev {
    private final zze zzbnl;
    private final zzhh zzbnm;
    private final zzex zzbno;

    public static class zza {
        private final zzlt zzbkr;

        public zza(zzlt zzlt) {
            this.zzbkr = zzlt;
        }

        public Intent zza(Context context, Map<String, String> map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo zza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.zzbkr != null) {
                str = zzu.zzfz().zza(this.zzbkr, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean(map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean(map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zzf = zzf(parse);
            Intent zzf2 = zzf(build);
            ResolveInfo zza2 = zza(context, zzf, arrayList);
            if (zza2 != null) {
                return zza(zzf, zza2);
            }
            if (!(zzf2 == null || (zza = zza(context, zzf2)) == null)) {
                Intent zza3 = zza(zzf, zza);
                if (zza(context, zza3) != null) {
                    return zza3;
                }
            }
            if (arrayList.size() == 0) {
                return zzf;
            }
            if (!(!parseBoolean2 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it.next();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                return zza(zzf, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzf, (ResolveInfo) arrayList.get(0)) : zzf;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzf(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzfc(zzex zzex, zze zze, zzhh zzhh) {
        this.zzbno = zzex;
        this.zzbnl = zze;
        this.zzbnm = zzhh;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzu.zzgb().zzun();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzu.zzgb().zzum();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzu.zzgb().zzuo();
            }
        }
        return -1;
    }

    private static void zze(zzlt zzlt, Map<String, String> map) {
        Context context = zzlt.getContext();
        if (TextUtils.isEmpty(map.get("u"))) {
            zzkn.zzdf("Destination url cannot be empty.");
            return;
        }
        try {
            zzlt.zzvr().zza(new AdLauncherIntentInfoParcel(new zza(zzlt).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzkn.zzdf(e.getMessage());
        }
    }

    private void zzs(boolean z) {
        if (this.zzbnm != null) {
            this.zzbnm.zzt(z);
        }
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            zzkn.zzdf("Action missing from an open GMSG.");
        } else if (this.zzbnl == null || this.zzbnl.zzer()) {
            zzlu zzvr = zzlt.zzvr();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzlt.zzvv()) {
                    zzkn.zzdf("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzs(false);
                zzvr.zza(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = map.get("u");
                zzs(false);
                if (str2 != null) {
                    zzvr.zza(zzc(map), zzd(map), str2);
                } else {
                    zzvr.zza(zzc(map), zzd(map), map.get("html"), map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = map.get("product_id");
                String str4 = map.get("report_urls");
                if (this.zzbno == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    this.zzbno.zza(str3, new ArrayList());
                } else {
                    this.zzbno.zza(str3, new ArrayList(Arrays.asList(str4.split(" "))));
                }
            } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase(map.get("system_browser"))) {
                zzs(true);
                String str5 = map.get("u");
                zzvr.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str5) ? zzu.zzfz().zza(zzlt, str5) : str5, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            } else {
                zzs(true);
                zze(zzlt, map);
            }
        } else {
            this.zzbnl.zzv(map.get("u"));
        }
    }
}
