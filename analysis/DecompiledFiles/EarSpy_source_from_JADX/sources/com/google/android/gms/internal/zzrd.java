package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;

public final class zzrd<L> {
    private volatile L mListener;

    /* renamed from: ze */
    private final zza f2171ze;

    /* renamed from: zf */
    private final zzb<L> f2172zf;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzac.zzbs(z);
            zzrd.this.zzb((zzc) message.obj);
        }
    }

    public static final class zzb<L> {
        private final L mListener;

        /* renamed from: zh */
        private final String f2174zh;

        private zzb(L l, String str) {
            this.mListener = l;
            this.f2174zh = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            return this.mListener == zzb.mListener && this.f2174zh.equals(zzb.f2174zh);
        }

        public int hashCode() {
            return (System.identityHashCode(this.mListener) * 31) + this.f2174zh.hashCode();
        }
    }

    public interface zzc<L> {
        void zzarg();

        void zzt(L l);
    }

    zzrd(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f2171ze = new zza(looper);
        this.mListener = zzac.zzb(l, (Object) "Listener must not be null");
        this.f2172zf = new zzb<>(l, zzac.zzhz(str));
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzc<? super L> zzc2) {
        zzac.zzb(zzc2, (Object) "Notifier must not be null");
        this.f2171ze.sendMessage(this.f2171ze.obtainMessage(1, zzc2));
    }

    @NonNull
    public zzb<L> zzasr() {
        return this.f2172zf;
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzc<? super L> zzc2) {
        L l = this.mListener;
        if (l == null) {
            zzc2.zzarg();
            return;
        }
        try {
            zzc2.zzt(l);
        } catch (RuntimeException e) {
            zzc2.zzarg();
            throw e;
        }
    }
}
