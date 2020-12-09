package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.internal.zzky;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
public class zzkv {
    private final Object zzakd = new Object();
    private String zzcrv = "";
    private String zzcrw = "";
    private boolean zzcrx = false;

    private Uri zze(Context context, String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzap(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        return buildUpon.build();
    }

    private void zzn(Context context, String str) {
        zzu.zzfz().zza(context, zze(context, zzdi.zzbhr.get(), str));
    }

    public void zza(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zze(context, zzdi.zzbhu.get(), str3).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzu.zzfz().zzc(context, str, buildUpon.build().toString());
    }

    public void zzai(boolean z) {
        synchronized (this.zzakd) {
            this.zzcrx = z;
        }
    }

    public String zzap(Context context) {
        String str;
        synchronized (this.zzakd) {
            if (TextUtils.isEmpty(this.zzcrv)) {
                this.zzcrv = zzu.zzfz().zzh(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzcrv)) {
                    this.zzcrv = zzu.zzfz().zzuh();
                    zzu.zzfz().zzd(context, "debug_signals_id.txt", this.zzcrv);
                }
            }
            str = this.zzcrv;
        }
        return str;
    }

    public void zzdb(String str) {
        synchronized (this.zzakd) {
            this.zzcrw = str;
        }
    }

    public void zzi(Context context, String str) {
        if (zzk(context, str)) {
            zzkn.zzdd("Device is linked for in app preview.");
        } else {
            zzn(context, str);
        }
    }

    public void zzj(Context context, String str) {
        if (zzl(context, str)) {
            zzkn.zzdd("Device is linked for debug signals.");
        } else {
            zzn(context, str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzk(Context context, String str) {
        String zzm = zzm(context, zze(context, zzdi.zzbhs.get(), str).toString());
        if (TextUtils.isEmpty(zzm)) {
            zzkn.zzdd("Not linked for in app preview.");
            return false;
        }
        zzdb(zzm.trim());
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zzl(Context context, String str) {
        String zzm = zzm(context, zze(context, zzdi.zzbht.get(), str).toString());
        if (TextUtils.isEmpty(zzm)) {
            zzkn.zzdd("Not linked for debug signals.");
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(zzm.trim());
        zzai(parseBoolean);
        return parseBoolean;
    }

    /* access modifiers changed from: protected */
    public String zzm(Context context, final String str) {
        zzlj zza = new zzky(context).zza(str, new zzky.zza<String>() {
            /* renamed from: zzi */
            public String zzh(InputStream inputStream) {
                try {
                    String str = new String(zzo.zza(inputStream, true), "UTF-8");
                    String str2 = str;
                    zzkn.zzdd(new StringBuilder(String.valueOf(str2).length() + 49 + String.valueOf(str).length()).append("Response received from server. \nURL: ").append(str2).append("\n Response: ").append(str).toString());
                    return str;
                } catch (IOException e) {
                    IOException iOException = e;
                    String valueOf = String.valueOf(str);
                    zzkn.zzd(valueOf.length() != 0 ? "Error connecting to url: ".concat(valueOf) : new String("Error connecting to url: "), iOException);
                    return null;
                }
            }

            /* renamed from: zzuv */
            public String zzrs() {
                String valueOf = String.valueOf(str);
                zzkn.zzdf(valueOf.length() != 0 ? "Error getting a response from: ".concat(valueOf) : new String("Error getting a response from: "));
                return null;
            }
        });
        try {
            return (String) zza.get((long) zzdi.zzbhv.get().intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            TimeoutException timeoutException = e;
            String valueOf = String.valueOf(str);
            zzkn.zzb(valueOf.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf) : new String("Timeout while retriving a response from: "), timeoutException);
            zza.cancel(true);
        } catch (InterruptedException e2) {
            InterruptedException interruptedException = e2;
            String valueOf2 = String.valueOf(str);
            zzkn.zzb(valueOf2.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf2) : new String("Interrupted while retriving a response from: "), interruptedException);
            zza.cancel(true);
        } catch (Exception e3) {
            Exception exc = e3;
            String valueOf3 = String.valueOf(str);
            zzkn.zzb(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), exc);
        }
        return null;
    }

    public String zzut() {
        String str;
        synchronized (this.zzakd) {
            str = this.zzcrw;
        }
        return str;
    }

    public boolean zzuu() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcrx;
        }
        return z;
    }
}
