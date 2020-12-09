package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzrn extends Fragment implements zzrb {

    /* renamed from: yZ */
    private static WeakHashMap<FragmentActivity, WeakReference<zzrn>> f2182yZ = new WeakHashMap<>();

    /* renamed from: za */
    private Map<String, zzra> f2183za = new ArrayMap();
    /* access modifiers changed from: private */

    /* renamed from: zb */
    public Bundle f2184zb;
    /* access modifiers changed from: private */
    public int zzbqm = 0;

    public static zzrn zza(FragmentActivity fragmentActivity) {
        zzrn zzrn;
        WeakReference weakReference = f2182yZ.get(fragmentActivity);
        if (weakReference == null || (zzrn = (zzrn) weakReference.get()) == null) {
            try {
                zzrn = (zzrn) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzrn == null || zzrn.isRemoving()) {
                    zzrn = new zzrn();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzrn, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f2182yZ.put(fragmentActivity, new WeakReference(zzrn));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzrn;
    }

    private void zzb(final String str, @NonNull final zzra zzra) {
        if (this.zzbqm > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzrn.this.zzbqm >= 1) {
                        zzra.onCreate(zzrn.this.f2184zb != null ? zzrn.this.f2184zb.getBundle(str) : null);
                    }
                    if (zzrn.this.zzbqm >= 2) {
                        zzra.onStart();
                    }
                    if (zzrn.this.zzbqm >= 3) {
                        zzra.onStop();
                    }
                    if (zzrn.this.zzbqm >= 4) {
                        zzra.onDestroy();
                    }
                }
            });
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzra dump : this.f2183za.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzra onActivityResult : this.f2183za.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbqm = 1;
        this.f2184zb = bundle;
        for (Map.Entry next : this.f2183za.entrySet()) {
            ((zzra) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onStop();
        this.zzbqm = 4;
        for (zzra onDestroy : this.f2183za.values()) {
            onDestroy.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f2183za.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzra) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.zzbqm = 2;
        for (zzra onStart : this.f2183za.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.zzbqm = 3;
        for (zzra onStop : this.f2183za.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzra> T zza(String str, Class<T> cls) {
        return (zzra) cls.cast(this.f2183za.get(str));
    }

    public void zza(String str, @NonNull zzra zzra) {
        if (!this.f2183za.containsKey(str)) {
            this.f2183za.put(str, zzra);
            zzb(str, zzra);
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    /* renamed from: zzass */
    public FragmentActivity zzasq() {
        return getActivity();
    }
}
