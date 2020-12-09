package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzra {

    /* renamed from: yY */
    protected final zzrb f2165yY;

    protected zzra(zzrb zzrb) {
        this.f2165yY = zzrb;
    }

    protected static zzrb zzc(zzqz zzqz) {
        return zzqz.zzasn() ? zzrn.zza(zzqz.zzasp()) : zzrc.zzt(zzqz.zzaso());
    }

    protected static zzrb zzs(Activity activity) {
        return zzc(new zzqz(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.f2165yY.zzasq();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onDestroy() {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
