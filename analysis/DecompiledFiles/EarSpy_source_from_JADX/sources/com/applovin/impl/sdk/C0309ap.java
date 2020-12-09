package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

/* renamed from: com.applovin.impl.sdk.ap */
class C0309ap implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0308ao f349a;

    C0309ap(C0308ao aoVar) {
        this.f349a = aoVar;
    }

    public void run() {
        String str = (String) this.f349a.f346a.mo5363a(C0343bw.f495ab);
        String b = this.f349a.mo5444b();
        String str2 = (String) this.f349a.f346a.mo5363a(C0343bw.f500ag);
        if (C0392n.m608a(AppLovinConfirmationActivity.class, (Context) this.f349a.f348c)) {
            try {
                Intent intent = new Intent(this.f349a.f348c, AppLovinConfirmationActivity.class);
                intent.putExtra("dialog_title", str);
                intent.putExtra("dialog_body", b);
                intent.putExtra("dialog_button_text", str2);
                this.f349a.f348c.startActivity(intent);
            } catch (Throwable th) {
                this.f349a.mo5443a(b, th);
            }
        } else {
            this.f349a.mo5443a(b, (Throwable) null);
        }
    }
}
