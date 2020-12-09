package com.applovin.impl.sdk;

import android.app.AlertDialog;

/* renamed from: com.applovin.impl.sdk.ar */
class C0311ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0310aq f358a;

    C0311ar(C0310aq aqVar) {
        this.f358a = aqVar;
    }

    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f358a.f352c);
        builder.setTitle((CharSequence) this.f358a.f350a.mo5363a(C0343bw.f464X));
        builder.setMessage((CharSequence) this.f358a.f350a.mo5363a(C0343bw.f465Y));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f358a.f350a.mo5363a(C0343bw.f466Z), new C0312as(this));
        builder.setNegativeButton((CharSequence) this.f358a.f350a.mo5363a(C0343bw.f494aa), new C0315av(this));
        builder.show();
    }
}
