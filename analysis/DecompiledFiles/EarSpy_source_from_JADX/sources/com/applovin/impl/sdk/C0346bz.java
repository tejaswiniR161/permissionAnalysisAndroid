package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bz */
class C0346bz {

    /* renamed from: a */
    private final AppLovinSdkImpl f573a;

    /* renamed from: b */
    private final AppLovinLogger f574b;

    /* renamed from: c */
    private final Context f575c;

    /* renamed from: d */
    private final Object[] f576d = new Object[C0343bw.m388b()];

    C0346bz(AppLovinSdkImpl appLovinSdkImpl) {
        this.f573a = appLovinSdkImpl;
        this.f574b = appLovinSdkImpl.getLogger();
        this.f575c = appLovinSdkImpl.getApplicationContext();
    }

    /* renamed from: a */
    private static C0345by m393a(String str) {
        for (C0345by byVar : C0343bw.m387a()) {
            if (byVar.mo5541b().equals(str)) {
                return byVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Object m394a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    /* renamed from: e */
    private String m395e() {
        return "com.applovin.sdk." + C0382dh.m582a(this.f573a.getSdkKey()) + ".";
    }

    /* renamed from: a */
    public SharedPreferences mo5544a() {
        if (this.f575c != null) {
            return this.f575c.getSharedPreferences("com.applovin.sdk.1", 0);
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: a */
    public Object mo5545a(C0345by byVar) {
        Object a;
        if (byVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.f576d) {
            Object obj = this.f576d[byVar.mo5539a()];
            a = obj != null ? byVar.mo5540a(obj) : byVar.mo5542c();
        }
        return a;
    }

    /* renamed from: a */
    public void mo5546a(C0345by byVar, Object obj) {
        if (byVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        } else {
            synchronized (this.f576d) {
                this.f576d[byVar.mo5539a()] = obj;
            }
            this.f574b.mo5665d("SettingsManager", "Setting update: " + byVar.mo5541b() + " set to \"" + obj + "\"");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5547a(AppLovinSdkSettings appLovinSdkSettings) {
        boolean z;
        long j = 0;
        boolean z2 = false;
        this.f574b.mo5668i("SettingsManager", "Loading user-defined settings...");
        if (appLovinSdkSettings != null) {
            synchronized (this.f576d) {
                this.f576d[C0343bw.f552j.mo5539a()] = Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled());
                long bannerAdRefreshSeconds = appLovinSdkSettings.getBannerAdRefreshSeconds();
                if (bannerAdRefreshSeconds >= 0) {
                    if (bannerAdRefreshSeconds > 0) {
                        j = Math.max(30, bannerAdRefreshSeconds);
                    }
                    this.f576d[C0343bw.f441A.mo5539a()] = Long.valueOf(j);
                    this.f576d[C0343bw.f568z.mo5539a()] = true;
                } else if (bannerAdRefreshSeconds == -1) {
                    this.f576d[C0343bw.f568z.mo5539a()] = false;
                }
                String autoPreloadSizes = appLovinSdkSettings.getAutoPreloadSizes();
                if (autoPreloadSizes == null) {
                    autoPreloadSizes = "NONE";
                }
                Object[] objArr = this.f576d;
                int a = C0343bw.f450J.mo5539a();
                if (autoPreloadSizes.equals("NONE")) {
                    autoPreloadSizes = "";
                }
                objArr[a] = autoPreloadSizes;
                String autoPreloadTypes = appLovinSdkSettings.getAutoPreloadTypes();
                if (autoPreloadTypes == null) {
                    autoPreloadTypes = "NONE";
                }
                if (!autoPreloadTypes.equals("NONE")) {
                    z = false;
                    for (String str : autoPreloadTypes.split(",")) {
                        if (str.equals(AppLovinAdType.REGULAR.getLabel())) {
                            z = true;
                        } else if (str.equals(AppLovinAdType.INCENTIVIZED.getLabel()) || str.contains("INCENT") || str.contains("REWARD")) {
                            z2 = true;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.f576d[C0343bw.f450J.mo5539a()] = "";
                }
                this.f576d[C0343bw.f451K.mo5539a()] = Boolean.valueOf(z2);
                if (appLovinSdkSettings instanceof C0316aw) {
                    for (Map.Entry entry : ((C0316aw) appLovinSdkSettings).mo5458b().entrySet()) {
                        this.f576d[((C0345by) entry.getKey()).mo5539a()] = entry.getValue();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5548a(JSONObject jSONObject) {
        this.f574b.mo5665d("SettingsManager", "Loading settings from JSON array...");
        synchronized (this.f576d) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C0345by a = m393a(next);
                        if (a != null) {
                            Object a2 = m394a(next, jSONObject, a.mo5542c());
                            this.f576d[a.mo5539a()] = a2;
                            this.f574b.mo5665d("SettingsManager", "Setting update: " + a.mo5541b() + " set to \"" + a2 + "\"");
                        } else {
                            this.f574b.mo5671w("SettingsManager", "Unknown setting recieved: " + next);
                        }
                    } catch (JSONException e) {
                        this.f574b.mo5667e("SettingsManager", "Unable to parse JSON settings array", e);
                    } catch (Throwable th) {
                        this.f574b.mo5667e("SettingsManager", "Unable to convert setting object ", th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5549b() {
        if (this.f575c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f574b.mo5668i("SettingsManager", "Saving settings with the application...");
        String e = m395e();
        SharedPreferences.Editor edit = mo5544a().edit();
        synchronized (this.f576d) {
            for (C0345by byVar : C0343bw.m387a()) {
                Object obj = this.f576d[byVar.mo5539a()];
                if (obj != null) {
                    String str = e + byVar.mo5541b();
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else {
                        throw new RuntimeException("SDK Error: unknown value: " + obj.getClass());
                    }
                }
            }
        }
        edit.commit();
        this.f574b.mo5665d("SettingsManager", "Settings saved with the application.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5550c() {
        Object string;
        if (this.f575c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f574b.mo5668i("SettingsManager", "Loading settings saved with the application...");
        String e = m395e();
        SharedPreferences a = mo5544a();
        synchronized (this.f576d) {
            for (C0345by byVar : C0343bw.m387a()) {
                try {
                    String str = e + byVar.mo5541b();
                    Object c = byVar.mo5542c();
                    if (c instanceof Boolean) {
                        string = Boolean.valueOf(a.getBoolean(str, ((Boolean) c).booleanValue()));
                    } else if (c instanceof Float) {
                        string = Float.valueOf(a.getFloat(str, ((Float) c).floatValue()));
                    } else if (c instanceof Integer) {
                        string = Integer.valueOf(a.getInt(str, ((Integer) c).intValue()));
                    } else if (c instanceof Long) {
                        string = Long.valueOf(a.getLong(str, ((Long) c).longValue()));
                    } else if (c instanceof String) {
                        string = a.getString(str, (String) c);
                    } else {
                        throw new RuntimeException("SDK Error: unknown value: " + c.getClass());
                    }
                    this.f576d[byVar.mo5539a()] = string;
                } catch (Exception e2) {
                    this.f574b.mo5667e("SettingsManager", "Unable to load \"" + byVar.mo5541b() + "\"", e2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5551d() {
        synchronized (this.f576d) {
            Arrays.fill(this.f576d, (Object) null);
        }
        SharedPreferences.Editor edit = mo5544a().edit();
        edit.clear();
        edit.commit();
    }
}
