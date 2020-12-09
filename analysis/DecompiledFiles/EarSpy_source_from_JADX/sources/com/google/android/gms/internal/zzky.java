package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zziy
public class zzky {
    private static zzl zzcsk;
    private static final Object zzcsl = new Object();
    public static final zza<Void> zzcsm = new zza<Void>() {
        /* renamed from: zzj */
        public Void zzh(InputStream inputStream) {
            return null;
        }

        /* renamed from: zzux */
        public Void zzrs() {
            return null;
        }
    };

    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zzrs();
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zzm.zzb<T> zzcg;
        private final zza<T> zzcsr;

        public zzb(String str, final zza<T> zza, final zzm.zzb<T> zzb) {
            super(0, str, new zzm.zza() {
                public void zze(zzr zzr) {
                    zzm.zzb.this.zzb(zza.zzrs());
                }
            });
            this.zzcsr = zza;
            this.zzcg = zzb;
        }

        /* access modifiers changed from: protected */
        public zzm<InputStream> zza(zzi zzi) {
            return zzm.zza(new ByteArrayInputStream(zzi.data), zzx.zzb(zzi));
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzk */
        public void zza(InputStream inputStream) {
            this.zzcg.zzb(this.zzcsr.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzlg<T> implements zzm.zzb<T> {
        private zzc() {
        }

        public void zzb(@Nullable T t) {
            super.zzh(t);
        }
    }

    public zzky(Context context) {
        zzaq(context);
    }

    private static zzl zzaq(Context context) {
        zzl zzl;
        synchronized (zzcsl) {
            if (zzcsk == null) {
                zzcsk = zzac.zza(context.getApplicationContext());
            }
            zzl = zzcsk;
        }
        return zzl;
    }

    public zzlj<String> zza(int i, final String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        final zzc zzc2 = new zzc();
        final byte[] bArr2 = bArr;
        final Map<String, String> map2 = map;
        zzcsk.zze(new zzab(i, str, zzc2, new zzm.zza() {
            public void zze(zzr zzr) {
                String str = str;
                String valueOf = String.valueOf(zzr.toString());
                zzkn.zzdf(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
                zzc2.zzb(null);
            }
        }) {
            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }

            public byte[] zzp() throws zza {
                return bArr2 == null ? super.zzp() : bArr2;
            }
        });
        return zzc2;
    }

    public <T> zzlj<T> zza(String str, zza<T> zza2) {
        zzc zzc2 = new zzc();
        zzcsk.zze(new zzb(str, zza2, zzc2));
        return zzc2;
    }

    public zzlj<String> zzd(String str, Map<String, String> map) {
        return zza(0, str, map, (byte[]) null);
    }
}
