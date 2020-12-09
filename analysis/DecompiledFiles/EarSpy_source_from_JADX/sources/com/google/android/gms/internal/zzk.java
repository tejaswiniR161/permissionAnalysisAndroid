package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class zzk<T> implements Comparable<zzk<T>> {
    /* access modifiers changed from: private */
    public final zzs.zza zzac;
    private final int zzad;
    private final String zzae;
    private final int zzaf;
    private final zzm.zza zzag;
    private Integer zzah;
    private zzl zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private long zzam;
    private zzo zzan;
    private zzb.zza zzao;

    public enum zza {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public zzk(int i, String str, zzm.zza zza2) {
        this.zzac = zzs.zza.zzbj ? new zzs.zza() : null;
        this.zzaj = true;
        this.zzak = false;
        this.zzal = false;
        this.zzam = 0;
        this.zzao = null;
        this.zzad = i;
        this.zzae = str;
        this.zzag = zza2;
        zza((zzo) new zzd());
        this.zzaf = zzb(str);
    }

    private byte[] zza(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Encoding not supported: ".concat(valueOf) : new String("Encoding not supported: "), unsupportedEncodingException);
        }
    }

    private static int zzb(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.zzad;
    }

    public String getUrl() {
        return this.zzae;
    }

    public boolean isCanceled() {
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(zzf()));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        String valueOf2 = String.valueOf(getUrl());
        String valueOf3 = String.valueOf(zzr());
        String valueOf4 = String.valueOf(this.zzah);
        return new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(valueOf2).length() + String.valueOf(concat).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append("[ ] ").append(valueOf2).append(" ").append(concat).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    public final zzk<?> zza(int i) {
        this.zzah = Integer.valueOf(i);
        return this;
    }

    public zzk<?> zza(zzb.zza zza2) {
        this.zzao = zza2;
        return this;
    }

    public zzk<?> zza(zzl zzl) {
        this.zzai = zzl;
        return this;
    }

    public zzk<?> zza(zzo zzo) {
        this.zzan = zzo;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzm<T> zza(zzi zzi);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    /* access modifiers changed from: protected */
    public zzr zzb(zzr zzr) {
        return zzr;
    }

    /* renamed from: zzc */
    public int compareTo(zzk<T> zzk) {
        zza zzr = zzr();
        zza zzr2 = zzk.zzr();
        return zzr == zzr2 ? this.zzah.intValue() - zzk.zzah.intValue() : zzr2.ordinal() - zzr.ordinal();
    }

    public void zzc(zzr zzr) {
        if (this.zzag != null) {
            this.zzag.zze(zzr);
        }
    }

    public void zzc(String str) {
        if (zzs.zza.zzbj) {
            this.zzac.zza(str, Thread.currentThread().getId());
        } else if (this.zzam == 0) {
            this.zzam = SystemClock.elapsedRealtime();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzd(final String str) {
        if (this.zzai != null) {
            this.zzai.zzf(this);
        }
        if (zzs.zza.zzbj) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        zzk.this.zzac.zza(str, id);
                        zzk.this.zzac.zzd(toString());
                    }
                });
                return;
            }
            this.zzac.zza(str, id);
            this.zzac.zzd(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzam;
        if (elapsedRealtime >= 3000) {
            zzs.zzb("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public int zzf() {
        return this.zzaf;
    }

    public String zzg() {
        return getUrl();
    }

    public zzb.zza zzh() {
        return this.zzao;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Map<String, String> zzi() throws zza {
        return zzm();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String zzj() {
        return zzn();
    }

    @Deprecated
    public String zzk() {
        return zzo();
    }

    @Deprecated
    public byte[] zzl() throws zza {
        Map<String, String> zzi = zzi();
        if (zzi == null || zzi.size() <= 0) {
            return null;
        }
        return zza(zzi, zzj());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> zzm() throws zza {
        return null;
    }

    /* access modifiers changed from: protected */
    public String zzn() {
        return "UTF-8";
    }

    public String zzo() {
        String valueOf = String.valueOf(zzn());
        return valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset=");
    }

    public byte[] zzp() throws zza {
        Map<String, String> zzm = zzm();
        if (zzm == null || zzm.size() <= 0) {
            return null;
        }
        return zza(zzm, zzn());
    }

    public final boolean zzq() {
        return this.zzaj;
    }

    public zza zzr() {
        return zza.NORMAL;
    }

    public final int zzs() {
        return this.zzan.zzc();
    }

    public zzo zzt() {
        return this.zzan;
    }

    public void zzu() {
        this.zzal = true;
    }

    public boolean zzv() {
        return this.zzal;
    }
}
