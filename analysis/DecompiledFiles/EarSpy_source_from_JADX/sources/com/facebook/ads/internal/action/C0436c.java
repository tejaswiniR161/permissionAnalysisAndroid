package com.facebook.ads.internal.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0535f;
import com.facebook.ads.internal.util.C0542i;
import com.facebook.ads.internal.util.C0553r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.action.c */
public class C0436c extends C0434a {

    /* renamed from: a */
    private static final String f881a = C0436c.class.getSimpleName();

    /* renamed from: b */
    private final Context f882b;

    /* renamed from: c */
    private final Uri f883c;

    public C0436c(Context context, Uri uri) {
        this.f882b = context;
        this.f883c = uri;
    }

    /* renamed from: a */
    private Intent m814a(C0542i iVar) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!C0553r.m1245a(iVar.mo6124a()) && !C0553r.m1245a(iVar.mo6125b())) {
            intent.setComponent(new ComponentName(iVar.mo6124a(), iVar.mo6125b()));
        }
        if (!C0553r.m1245a(iVar.mo6126c())) {
            intent.setData(Uri.parse(iVar.mo6126c()));
        }
        return intent;
    }

    /* renamed from: b */
    private Intent m815b(C0542i iVar) {
        if (C0553r.m1245a(iVar.mo6124a())) {
            return null;
        }
        if (!C0535f.m1193a(this.f882b, iVar.mo6124a())) {
            return null;
        }
        String c = iVar.mo6126c();
        if (!C0553r.m1245a(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.f882b.getPackageManager();
        if (C0553r.m1245a(iVar.mo6125b()) && C0553r.m1245a(c)) {
            return packageManager.getLaunchIntentForPackage(iVar.mo6124a());
        }
        Intent a = m814a(iVar);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, 65536);
        if (a.getComponent() == null) {
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (next.activityInfo.packageName.equals(iVar.mo6124a())) {
                    a.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                    break;
                }
            }
        }
        if (queryIntentActivities.isEmpty() || a.getComponent() == null) {
            return null;
        }
        return a;
    }

    /* renamed from: f */
    private List<C0542i> m816f() {
        String queryParameter = this.f883c.getQueryParameter("appsite_data");
        if (C0553r.m1245a(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0542i a = C0542i.m1221a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            Log.w(f881a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    /* renamed from: a */
    public C0528b.C0529a mo5881a() {
        return C0528b.C0529a.OPEN_STORE;
    }

    /* renamed from: b */
    public void mo5883b() {
        mo5882a(this.f882b, this.f883c);
        List<Intent> d = mo5885d();
        if (d != null) {
            for (Intent startActivity : d) {
                try {
                    this.f882b.startActivity(startActivity);
                    return;
                } catch (Exception e) {
                    Log.d(f881a, "Failed to open app intent, falling back", e);
                }
            }
        }
        mo5886e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Uri mo5884c() {
        String queryParameter = this.f883c.getQueryParameter("store_url");
        if (!C0553r.m1245a(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        return Uri.parse(String.format("market://details?id=%s", new Object[]{this.f883c.getQueryParameter(AppLovinEventParameters.IN_APP_PURCHASE_TRANSACTION_IDENTIFIER)}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public List<Intent> mo5885d() {
        List<C0542i> f = m816f();
        ArrayList arrayList = new ArrayList();
        if (f != null) {
            for (C0542i b : f) {
                Intent b2 = m815b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public void mo5886e() {
        Intent intent = new Intent("android.intent.action.VIEW", mo5884c());
        intent.addFlags(268435456);
        try {
            this.f882b.startActivity(intent);
        } catch (Exception e) {
            Log.d(f881a, "Failed to open market url: " + this.f883c.toString(), e);
            String queryParameter = this.f883c.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                intent2.addFlags(268435456);
                try {
                    this.f882b.startActivity(intent2);
                } catch (Exception e2) {
                    Log.d(f881a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }
}
