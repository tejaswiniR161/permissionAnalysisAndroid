package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

@zziy
public final class zzkp {

    private static abstract class zza extends zzkm {
        private zza() {
        }

        public void onStop() {
        }
    }

    public interface zzb {
        void zzh(Bundle bundle);
    }

    public static Future zza(final Context context, final int i) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putInt("request_in_session_count", i);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zza(final Context context, final long j) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putLong("app_last_background_time_ms", j);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zza(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzn.getBoolean("use_https", true));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zza(final Context context, final String str, final long j) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putString("app_settings_json", str);
                edit.putLong("app_settings_last_update_ms", j);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zzb(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzn.getInt("webview_cache_version", 0));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zzc(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", zzn.getBoolean("content_url_opted_out", true));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zzc(final Context context, final boolean z) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putBoolean("use_https", z);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zzd(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putString("content_url_hashes", zzn.getString("content_url_hashes", ""));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zze(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", zzn.getBoolean("auto_collect_location", false));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zze(final Context context, final boolean z) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putBoolean("content_url_opted_out", z);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zzf(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", zzn.getString("app_settings_json", ""));
                bundle.putLong("app_settings_last_update_ms", zzn.getLong("app_settings_last_update_ms", 0));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static Future zzf(final Context context, final String str) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putString("content_url_hashes", str);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zzf(final Context context, final boolean z) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences.Editor edit = zzkp.zzn(context).edit();
                edit.putBoolean("auto_collect_location", z);
                edit.apply();
            }
        }.zzqw();
    }

    public static Future zzg(final Context context, final zzb zzb2) {
        return (Future) new zza() {
            public void zzfc() {
                SharedPreferences zzn = zzkp.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", zzn.getLong("app_last_background_time_ms", 0));
                if (zzb2 != null) {
                    zzb2.zzh(bundle);
                }
            }
        }.zzqw();
    }

    public static SharedPreferences zzn(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
