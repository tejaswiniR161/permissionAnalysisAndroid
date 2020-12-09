package com.applovin.impl.sdk;

import android.content.DialogInterface;

/* renamed from: com.applovin.impl.sdk.as */
class C0312as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0311ar f359a;

    C0312as(C0311ar arVar) {
        this.f359a = arVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f359a.f358a.f357h.schedule(new C0313at(this), 200);
    }
}
