package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.action.C0434a;
import com.facebook.ads.internal.action.C0435b;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0534e;
import com.facebook.ads.internal.util.C0535f;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0550o;
import com.facebook.ads.internal.util.C0553r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.j */
public class C0453j extends C0460n implements C0535f.C0536a {

    /* renamed from: a */
    private static final String f941a = C0453j.class.getSimpleName();

    /* renamed from: A */
    private String f942A;

    /* renamed from: B */
    private String f943B;

    /* renamed from: C */
    private NativeAd.Image f944C;

    /* renamed from: D */
    private String f945D;

    /* renamed from: E */
    private String f946E;

    /* renamed from: F */
    private C0455a f947F;

    /* renamed from: G */
    private AdExtras f948G;

    /* renamed from: H */
    private NativeAdViewAttributes f949H;

    /* renamed from: I */
    private boolean f950I;

    /* renamed from: J */
    private boolean f951J;

    /* renamed from: K */
    private boolean f952K;

    /* renamed from: L */
    private boolean f953L;

    /* renamed from: M */
    private boolean f954M;

    /* renamed from: N */
    private long f955N = 0;

    /* renamed from: O */
    private C0528b.C0529a f956O = null;

    /* renamed from: b */
    private Context f957b;

    /* renamed from: c */
    private Uri f958c;

    /* renamed from: d */
    private String f959d;

    /* renamed from: e */
    private String f960e;

    /* renamed from: f */
    private String f961f;

    /* renamed from: g */
    private String f962g;

    /* renamed from: h */
    private String f963h;

    /* renamed from: i */
    private NativeAd.Image f964i;

    /* renamed from: j */
    private NativeAd.Image f965j;

    /* renamed from: k */
    private NativeAd.Rating f966k;

    /* renamed from: l */
    private String f967l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f968m;

    /* renamed from: n */
    private String f969n;

    /* renamed from: o */
    private String f970o;

    /* renamed from: p */
    private C0534e f971p;

    /* renamed from: q */
    private String f972q;

    /* renamed from: r */
    private Collection<String> f973r;

    /* renamed from: s */
    private boolean f974s;

    /* renamed from: t */
    private boolean f975t;

    /* renamed from: u */
    private boolean f976u;

    /* renamed from: v */
    private int f977v;

    /* renamed from: w */
    private int f978w;

    /* renamed from: x */
    private int f979x;

    /* renamed from: y */
    private int f980y;

    /* renamed from: z */
    private String f981z;

    /* renamed from: com.facebook.ads.internal.adapters.j$a */
    public static class C0455a {

        /* renamed from: a */
        Map<String, List<String>> f985a = new HashMap();

        C0455a(JSONArray jSONArray) {
            JSONArray optJSONArray;
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("type");
                    if (!C0553r.m1245a(optString) && (optJSONArray = optJSONObject.optJSONArray("urls")) != null) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                        this.f985a.put(optString, arrayList);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5952a(String str) {
            List<String> list = this.f985a.get(str);
            if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    new C0550o().execute(new String[]{str2});
                }
            }
        }
    }

    /* renamed from: A */
    private boolean m870A() {
        return (this.f959d == null || this.f959d.length() <= 0 || this.f962g == null || this.f962g.length() <= 0 || this.f964i == null || this.f965j == null) ? false : true;
    }

    /* renamed from: B */
    private void m871B() {
        if (!this.f954M) {
            new C0550o().execute(new String[]{this.f970o});
            this.f954M = true;
        }
    }

    /* renamed from: a */
    private void m873a(String str, Map<String, String> map, Map<String, Object> map2) {
        if (map2.containsKey(str)) {
            map.put(str, String.valueOf(map2.get(str)));
        }
    }

    /* renamed from: a */
    private void m874a(Map<String, String> map, Map<String, Object> map2) {
        if (map2.containsKey("mil")) {
            boolean booleanValue = ((Boolean) map2.get("mil")).booleanValue();
            map2.remove("mil");
            if (!booleanValue) {
                return;
            }
        }
        map.put("mil", String.valueOf(true));
    }

    /* renamed from: b */
    private void m875b(Map<String, String> map, Map<String, Object> map2) {
        m873a("nti", map, map2);
        m873a("nhs", map, map2);
        m873a("nmv", map, map2);
    }

    /* renamed from: c */
    private Map<String, String> m876c(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", String.valueOf(map.get("view")));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", String.valueOf(map.get("snapshot")));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C0534e mo5920a() {
        return this.f971p;
    }

    /* renamed from: a */
    public void mo5921a(int i) {
        if (mo5950z() && i == 0 && this.f955N > 0 && this.f956O != null) {
            C0531c.m1182a(C0528b.m1177a(this.f955N, this.f956O, this.f946E));
            this.f955N = 0;
            this.f956O = null;
        }
    }

    /* renamed from: a */
    public void mo5922a(Context context, C0461o oVar, Map<String, Object> map) {
        mo5924a((JSONObject) map.get("data"));
        if (C0535f.m1192a(context, (C0535f.C0536a) this)) {
            oVar.mo5974a(this, AdError.NO_FILL);
            return;
        }
        this.f957b = context;
        if (oVar != null) {
            oVar.mo5973a(this);
        }
        C0528b.f1230a = this.f946E;
    }

    /* renamed from: a */
    public void mo5923a(Map<String, Object> map) {
        if (mo5950z() && !this.f952K) {
            final HashMap hashMap = new HashMap();
            if (map != null) {
                m874a(hashMap, map);
                m875b(hashMap, map);
            }
            new C0550o(hashMap).execute(new String[]{this.f967l});
            if (mo5929e() || mo5931g()) {
                try {
                    final Map<String, String> c = m876c(map);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            new C0550o(hashMap, c).execute(new String[]{C0453j.this.f968m});
                        }
                    }, (long) (this.f977v * AdError.NETWORK_ERROR_CODE));
                } catch (Exception e) {
                }
            }
            this.f947F.mo5952a("impression");
            this.f952K = true;
        }
    }

    /* renamed from: a */
    public void mo5924a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        if (this.f950I) {
            throw new IllegalStateException("Adapter already loaded data");
        } else if (jSONObject != null) {
            this.f958c = Uri.parse(jSONObject.optString("fbad_command"));
            this.f959d = jSONObject.optString("title");
            this.f960e = jSONObject.optString("subtitle");
            this.f961f = jSONObject.optString("body");
            this.f962g = jSONObject.optString("call_to_action");
            this.f963h = jSONObject.optString("social_context");
            this.f964i = NativeAd.Image.fromJSONObject(jSONObject.optJSONObject("icon"));
            this.f965j = NativeAd.Image.fromJSONObject(jSONObject.optJSONObject("image"));
            this.f966k = NativeAd.Rating.fromJSONObject(jSONObject.optJSONObject("star_rating"));
            this.f967l = jSONObject.optString("impression_report_url");
            this.f968m = jSONObject.optString("native_view_report_url");
            this.f969n = jSONObject.optString("click_report_url");
            this.f970o = jSONObject.optString("used_report_url");
            this.f948G = new AdExtras().setIsOrganic(jSONObject.optBoolean("is_organic", false));
            this.f974s = jSONObject.optBoolean("manual_imp");
            this.f975t = jSONObject.optBoolean("enable_view_log");
            this.f976u = jSONObject.optBoolean("enable_snapshot_log");
            this.f977v = jSONObject.optInt("snapshot_log_delay_second", 4);
            this.f978w = jSONObject.optInt("snapshot_compress_quality", 0);
            this.f979x = jSONObject.optInt("viewability_check_initial_delay", 0);
            this.f980y = jSONObject.optInt("viewability_check_interval", AdError.NETWORK_ERROR_CODE);
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
            this.f949H = optJSONObject2 == null ? null : new NativeAdViewAttributes(optJSONObject2);
            if (optJSONObject != null) {
                this.f944C = NativeAd.Image.fromJSONObject(optJSONObject);
            }
            this.f945D = jSONObject.optString("ad_choices_link_url");
            this.f946E = jSONObject.optString("request_id");
            this.f971p = C0534e.m1190a(jSONObject.optString("invalidation_behavior"));
            this.f972q = jSONObject.optString("invalidation_report_url");
            try {
                jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f973r = C0535f.m1191a(jSONArray);
            this.f947F = new C0455a(jSONObject.optJSONArray("trackers"));
            this.f981z = jSONObject.optString("video_url");
            this.f942A = jSONObject.optString("video_play_report_url");
            this.f943B = jSONObject.optString("video_time_report_url");
            this.f950I = true;
            this.f951J = m870A();
        }
    }

    /* renamed from: b */
    public String mo5925b() {
        return this.f972q;
    }

    /* renamed from: b */
    public void mo5926b(Map<String, Object> map) {
        if (mo5950z()) {
            if (!this.f953L) {
                HashMap hashMap = new HashMap();
                if (map != null) {
                    m874a(hashMap, map);
                    m875b(hashMap, map);
                    hashMap.put("touch", C0537g.m1201a(map));
                }
                new C0550o(hashMap).execute(new String[]{this.f969n});
                this.f947F.mo5952a("click");
                this.f953L = true;
                C0537g.m1206a(this.f957b, "Click logged");
            }
            C0434a a = C0435b.m813a(this.f957b, this.f958c);
            if (a != null) {
                try {
                    this.f955N = System.currentTimeMillis();
                    this.f956O = a.mo5881a();
                    a.mo5883b();
                } catch (Exception e) {
                    Log.e(f941a, "Error executing action", e);
                }
            }
        }
    }

    /* renamed from: c */
    public Collection<String> mo5927c() {
        return this.f973r;
    }

    /* renamed from: d */
    public boolean mo5928d() {
        return mo5950z() && this.f974s;
    }

    /* renamed from: e */
    public boolean mo5929e() {
        return mo5950z() && this.f975t;
    }

    /* renamed from: f */
    public boolean mo5930f() {
        return mo5950z() && this.f949H != null;
    }

    /* renamed from: g */
    public boolean mo5931g() {
        return mo5950z() && this.f976u;
    }

    /* renamed from: h */
    public int mo5932h() {
        if (this.f978w < 0 || this.f978w > 100) {
            return 0;
        }
        return this.f978w;
    }

    /* renamed from: i */
    public int mo5933i() {
        return this.f979x;
    }

    /* renamed from: j */
    public int mo5934j() {
        return this.f980y;
    }

    /* renamed from: k */
    public NativeAd.Image mo5935k() {
        if (!mo5950z()) {
            return null;
        }
        return this.f964i;
    }

    /* renamed from: l */
    public NativeAd.Image mo5936l() {
        if (!mo5950z()) {
            return null;
        }
        return this.f965j;
    }

    /* renamed from: m */
    public NativeAdViewAttributes mo5937m() {
        if (!mo5950z()) {
            return null;
        }
        return this.f949H;
    }

    /* renamed from: n */
    public String mo5938n() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f959d;
    }

    /* renamed from: o */
    public String mo5939o() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f960e;
    }

    public void onDestroy() {
    }

    /* renamed from: p */
    public String mo5940p() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f961f;
    }

    /* renamed from: q */
    public String mo5941q() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f962g;
    }

    /* renamed from: r */
    public String mo5942r() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f963h;
    }

    /* renamed from: s */
    public NativeAd.Rating mo5943s() {
        if (!mo5950z()) {
            return null;
        }
        m871B();
        return this.f966k;
    }

    /* renamed from: t */
    public NativeAd.Image mo5944t() {
        if (!mo5950z()) {
            return null;
        }
        return this.f944C;
    }

    /* renamed from: u */
    public String mo5945u() {
        if (!mo5950z()) {
            return null;
        }
        return this.f945D;
    }

    /* renamed from: v */
    public String mo5946v() {
        if (!mo5950z()) {
            return null;
        }
        return this.f981z;
    }

    /* renamed from: w */
    public String mo5947w() {
        if (!mo5950z()) {
            return null;
        }
        return this.f942A;
    }

    /* renamed from: x */
    public String mo5948x() {
        if (!mo5950z()) {
            return null;
        }
        return this.f943B;
    }

    /* renamed from: y */
    public AdExtras mo5949y() {
        if (!mo5950z()) {
            return null;
        }
        return this.f948G;
    }

    /* renamed from: z */
    public boolean mo5950z() {
        return this.f950I && this.f951J;
    }
}
