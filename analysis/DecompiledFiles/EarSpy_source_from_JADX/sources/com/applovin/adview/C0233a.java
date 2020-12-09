package com.applovin.adview;

import android.content.DialogInterface;

/* renamed from: com.applovin.adview.a */
class C0233a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinConfirmationActivity f54a;

    C0233a(AppLovinConfirmationActivity appLovinConfirmationActivity) {
        this.f54a = appLovinConfirmationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f54a.finish();
    }
}
