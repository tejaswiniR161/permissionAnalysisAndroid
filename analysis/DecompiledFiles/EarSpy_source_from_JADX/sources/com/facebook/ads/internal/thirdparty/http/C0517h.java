package com.facebook.ads.internal.thirdparty.http;

import android.os.AsyncTask;

/* renamed from: com.facebook.ads.internal.thirdparty.http.h */
public class C0517h extends AsyncTask<C0521l, Void, C0523n> implements C0512c {

    /* renamed from: a */
    private C0509a f1205a;

    /* renamed from: b */
    private C0511b f1206b;

    /* renamed from: c */
    private Exception f1207c;

    public C0517h(C0509a aVar, C0511b bVar) {
        this.f1205a = aVar;
        this.f1206b = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0523n doInBackground(C0521l... lVarArr) {
        if (lVarArr != null) {
            try {
                if (lVarArr.length > 0) {
                    return this.f1205a.mo6056a(lVarArr[0]);
                }
            } catch (Exception e) {
                this.f1207c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    /* renamed from: a */
    public void mo6071a(C0521l lVar) {
        super.execute(new C0521l[]{lVar});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C0523n nVar) {
        this.f1206b.mo6042a(nVar);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.f1206b.mo6043a(this.f1207c);
    }
}
