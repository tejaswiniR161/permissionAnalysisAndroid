package com.applovin.impl.sdk;

import android.content.DialogInterface;

/* renamed from: com.applovin.impl.sdk.av */
class C0315av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0311ar f362a;

    C0315av(C0311ar arVar) {
        this.f362a = arVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f362a.f358a.f351b.mo5716a(this.f362a.f358a.f356g);
    }
}
