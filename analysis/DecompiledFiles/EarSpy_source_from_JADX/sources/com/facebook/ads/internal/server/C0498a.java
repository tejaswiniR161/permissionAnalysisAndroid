package com.facebook.ads.internal.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.C0462b;
import com.facebook.ads.internal.dto.C0468c;
import com.facebook.ads.internal.dto.C0470e;
import com.facebook.ads.internal.dto.C0472f;
import com.facebook.ads.internal.server.C0504c;
import com.facebook.ads.internal.thirdparty.http.C0509a;
import com.facebook.ads.internal.thirdparty.http.C0511b;
import com.facebook.ads.internal.thirdparty.http.C0522m;
import com.facebook.ads.internal.thirdparty.http.C0523n;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.C0532d;
import com.facebook.ads.internal.util.C0551p;
import com.facebook.ads.internal.util.C0553r;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

/* renamed from: com.facebook.ads.internal.server.a */
public class C0498a {

    /* renamed from: g */
    private static final C0551p f1170g = new C0551p();

    /* renamed from: h */
    private static final ThreadPoolExecutor f1171h = ((ThreadPoolExecutor) Executors.newCachedThreadPool(f1170g));

    /* renamed from: a */
    Map<String, String> f1172a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0503b f1173b = C0503b.m1095a();

    /* renamed from: c */
    private C0502a f1174c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0470e f1175d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0509a f1176e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f1177f;

    /* renamed from: com.facebook.ads.internal.server.a$a */
    public interface C0502a {
        /* renamed from: a */
        void mo6013a(C0462b bVar);

        /* renamed from: a */
        void mo6014a(C0506d dVar);
    }

    public C0498a() {
        String format;
        String format2;
        String urlPrefix = AdSettings.getUrlPrefix();
        if (AdInternalSettings.shouldUseLiveRailEndpoint()) {
            if (C0553r.m1245a(urlPrefix)) {
                format2 = "https://ad6.liverail.com/";
            } else {
                format2 = String.format("https://ad6.%s.liverail.com/", new Object[]{urlPrefix});
            }
            this.f1177f = format2;
            return;
        }
        if (C0553r.m1245a(urlPrefix)) {
            format = "https://graph.facebook.com/network_ads_common/";
        } else {
            format = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[]{urlPrefix});
        }
        this.f1177f = format;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1076a(C0462b bVar) {
        if (this.f1174c != null) {
            this.f1174c.mo6013a(bVar);
        }
        mo6037a();
    }

    /* renamed from: a */
    private void m1079a(C0506d dVar) {
        if (this.f1174c != null) {
            this.f1174c.mo6014a(dVar);
        }
        mo6037a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1080a(String str) {
        try {
            C0504c a = this.f1173b.mo6044a(str);
            C0468c b = a.mo6046b();
            if (b != null) {
                C0532d.m1184a(b.mo5982a().mo5988c(), this.f1175d);
            }
            switch (a.mo6045a()) {
                case ADS:
                    C0506d dVar = (C0506d) a;
                    if (b != null && b.mo5982a().mo5989d()) {
                        C0532d.m1185a(str, this.f1175d);
                    }
                    m1079a(dVar);
                    return;
                case ERROR:
                    C0507e eVar = (C0507e) a;
                    String c = eVar.mo6047c();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(eVar.mo6048d(), AdErrorType.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    m1076a(adErrorTypeFromCode.getAdErrorWrapper(str));
                    return;
                default:
                    m1076a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(str));
                    return;
            }
        } catch (Exception e) {
            m1076a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
        }
        m1076a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
    }

    /* renamed from: a */
    private boolean m1081a(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C0511b m1083b() {
        return new C0511b() {
            /* renamed from: a */
            public void mo6041a(C0522m mVar) {
                C0532d.m1187b(C0498a.this.f1175d);
                C0509a unused = C0498a.this.f1176e = null;
                try {
                    C0523n a = mVar.mo6096a();
                    if (a != null) {
                        String e = a.mo6101e();
                        C0504c a2 = C0498a.this.f1173b.mo6044a(e);
                        if (a2.mo6045a() == C0504c.C0505a.ERROR) {
                            C0507e eVar = (C0507e) a2;
                            String c = eVar.mo6047c();
                            C0498a.this.m1076a(AdErrorType.adErrorTypeFromCode(eVar.mo6048d(), AdErrorType.ERROR_MESSAGE).getAdErrorWrapper(c == null ? e : c));
                            return;
                        }
                    }
                } catch (JSONException e2) {
                }
                C0498a.this.m1076a(new C0462b(AdErrorType.NETWORK_ERROR, mVar.getMessage()));
            }

            /* renamed from: a */
            public void mo6042a(C0523n nVar) {
                if (nVar != null) {
                    String e = nVar.mo6101e();
                    C0532d.m1187b(C0498a.this.f1175d);
                    C0509a unused = C0498a.this.f1176e = null;
                    C0498a.this.m1080a(e);
                }
            }

            /* renamed from: a */
            public void mo6043a(Exception exc) {
                if (C0522m.class.equals(exc.getClass())) {
                    mo6041a((C0522m) exc);
                } else {
                    C0498a.this.m1076a(new C0462b(AdErrorType.NETWORK_ERROR, exc.getMessage()));
                }
            }
        };
    }

    /* renamed from: a */
    public void mo6037a() {
        if (this.f1176e != null) {
            this.f1176e.mo6070c(1);
            this.f1176e.mo6069b(1);
            this.f1176e = null;
        }
    }

    /* renamed from: a */
    public void mo6038a(final Context context, final C0470e eVar) {
        mo6037a();
        if (!m1081a(context)) {
            m1076a(new C0462b(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f1175d = eVar;
        if (C0532d.m1186a(eVar)) {
            String c = C0532d.m1188c(eVar);
            if (c != null) {
                m1080a(c);
            } else {
                m1076a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper((String) null));
            }
        } else {
            f1171h.submit(new Runnable() {
                public void run() {
                    C0472f.m1003b(context);
                    C0498a.this.f1172a = eVar.mo5997e();
                    try {
                        C0509a unused = C0498a.this.f1176e = new C0509a(context, eVar.f1058e);
                        C0498a.this.f1176e.mo6062a(C0498a.this.f1177f, C0498a.this.f1176e.mo6068b().mo6102a((Map<? extends String, ? extends String>) C0498a.this.f1172a), C0498a.this.m1083b());
                    } catch (Exception e) {
                        C0498a.this.m1076a(AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(e.getMessage()));
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo6039a(C0502a aVar) {
        this.f1174c = aVar;
    }
}
