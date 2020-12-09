package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public abstract class zzcj implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    protected final Object zzakd = new Object();
    private boolean zzaoy = false;
    private zzlc zzasa;
    private final WeakReference<zzke> zzasg;
    private WeakReference<ViewTreeObserver> zzash;
    private final zzcq zzasi;
    protected final zzcl zzasj;
    private final Context zzask;
    private final WindowManager zzasl;
    private final PowerManager zzasm;
    private final KeyguardManager zzasn;
    @Nullable
    private zzcn zzaso;
    private boolean zzasp;
    private boolean zzasq = false;
    private boolean zzasr;
    private boolean zzass;
    private boolean zzast;
    @Nullable
    BroadcastReceiver zzasu;
    private final HashSet<zzck> zzasv = new HashSet<>();
    private final zzev zzasw = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (zzcj.this.zzb(map)) {
                zzcj.this.zza(zzlt.getView(), map);
            }
        }
    };
    private final zzev zzasx = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (zzcj.this.zzb(map)) {
                String valueOf = String.valueOf(zzcj.this.zzasj.zzia());
                zzkn.zzdd(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
                zzcj.this.destroy();
            }
        }
    };
    private final zzev zzasy = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            if (zzcj.this.zzb(map) && map.containsKey("isVisible")) {
                zzcj.this.zzj(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))).booleanValue());
            }
        }
    };

    public static class zza implements zzcq {
        private WeakReference<zzi> zzata;

        public zza(zzi zzi) {
            this.zzata = new WeakReference<>(zzi);
        }

        @Nullable
        public View zzhu() {
            zzi zzi = (zzi) this.zzata.get();
            if (zzi != null) {
                return zzi.zzly();
            }
            return null;
        }

        public boolean zzhv() {
            return this.zzata.get() == null;
        }

        public zzcq zzhw() {
            return new zzb((zzi) this.zzata.get());
        }
    }

    public static class zzb implements zzcq {
        private zzi zzatb;

        public zzb(zzi zzi) {
            this.zzatb = zzi;
        }

        public View zzhu() {
            if (this.zzatb != null) {
                return this.zzatb.zzly();
            }
            return null;
        }

        public boolean zzhv() {
            return this.zzatb == null;
        }

        public zzcq zzhw() {
            return this;
        }
    }

    public static class zzc implements zzcq {
        @Nullable
        private final View mView;
        @Nullable
        private final zzke zzatc;

        public zzc(View view, zzke zzke) {
            this.mView = view;
            this.zzatc = zzke;
        }

        public View zzhu() {
            return this.mView;
        }

        public boolean zzhv() {
            return this.zzatc == null || this.mView == null;
        }

        public zzcq zzhw() {
            return this;
        }
    }

    public static class zzd implements zzcq {
        private final WeakReference<View> zzatd;
        private final WeakReference<zzke> zzate;

        public zzd(View view, zzke zzke) {
            this.zzatd = new WeakReference<>(view);
            this.zzate = new WeakReference<>(zzke);
        }

        public View zzhu() {
            return (View) this.zzatd.get();
        }

        public boolean zzhv() {
            return this.zzatd.get() == null || this.zzate.get() == null;
        }

        public zzcq zzhw() {
            return new zzc((View) this.zzatd.get(), (zzke) this.zzate.get());
        }
    }

    public zzcj(Context context, AdSizeParcel adSizeParcel, zzke zzke, VersionInfoParcel versionInfoParcel, zzcq zzcq) {
        this.zzasg = new WeakReference<>(zzke);
        this.zzasi = zzcq;
        this.zzash = new WeakReference<>((Object) null);
        this.zzasr = true;
        this.zzast = false;
        this.zzasa = new zzlc(200);
        this.zzasj = new zzcl(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zzaxi, zzke.zzcod, zzke.zzib(), adSizeParcel.zzaxl);
        this.zzasl = (WindowManager) context.getSystemService("window");
        this.zzasm = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzasn = (KeyguardManager) context.getSystemService("keyguard");
        this.zzask = context;
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (this.zzakd) {
            zzhp();
            zzhk();
            this.zzasr = false;
            zzhm();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isScreenOn() {
        return this.zzasm.isScreenOn();
    }

    public void onGlobalLayout() {
        zzk(2);
    }

    public void onScrollChanged() {
        zzk(1);
    }

    public void pause() {
        synchronized (this.zzakd) {
            this.zzaoy = true;
            zzk(3);
        }
    }

    public void resume() {
        synchronized (this.zzakd) {
            this.zzaoy = false;
            zzk(3);
        }
    }

    public void stop() {
        synchronized (this.zzakd) {
            this.zzasq = true;
            zzk(3);
        }
    }

    /* access modifiers changed from: protected */
    public int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: protected */
    public void zza(View view, Map<String, String> map) {
        zzk(3);
    }

    public void zza(zzck zzck) {
        this.zzasv.add(zzck);
    }

    public void zza(zzcn zzcn) {
        synchronized (this.zzakd) {
            this.zzaso = zzcn;
        }
    }

    /* access modifiers changed from: protected */
    public void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            zzb(jSONObject2);
        } catch (Throwable th) {
            zzkn.zzb("Skipping active view message.", th);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public boolean zzb(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzasj.zzia());
    }

    /* access modifiers changed from: protected */
    public void zzc(zzfz zzfz) {
        zzfz.zza("/updateActiveView", this.zzasw);
        zzfz.zza("/untrackActiveViewUnit", this.zzasx);
        zzfz.zza("/visibilityChanged", this.zzasy);
    }

    /* access modifiers changed from: protected */
    public JSONObject zzd(@Nullable View view) throws JSONException {
        if (view == null) {
            return zzhs();
        }
        boolean isAttachedToWindow = zzu.zzgb().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzkn.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzasl.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzasl.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, (Point) null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject zzhq = zzhq();
        zzhq.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzu.zzfz().zza(view, this.zzasm, this.zzasn));
        return zzhq;
    }

    /* access modifiers changed from: protected */
    public void zzd(zzfz zzfz) {
        zzfz.zzb("/visibilityChanged", this.zzasy);
        zzfz.zzb("/untrackActiveViewUnit", this.zzasx);
        zzfz.zzb("/updateActiveView", this.zzasw);
    }

    /* access modifiers changed from: protected */
    public void zzhj() {
        synchronized (this.zzakd) {
            if (this.zzasu == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                this.zzasu = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        zzcj.this.zzk(3);
                    }
                };
                this.zzask.registerReceiver(this.zzasu, intentFilter);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzhk() {
        synchronized (this.zzakd) {
            if (this.zzasu != null) {
                try {
                    this.zzask.unregisterReceiver(this.zzasu);
                } catch (IllegalStateException e) {
                    zzkn.zzb("Failed trying to unregister the receiver", e);
                } catch (Exception e2) {
                    zzu.zzgd().zza((Throwable) e2, "AbstractActiveViewUnit.stopScreenStatusMonitoring");
                }
                this.zzasu = null;
            }
        }
        return;
    }

    public void zzhl() {
        synchronized (this.zzakd) {
            if (this.zzasr) {
                this.zzass = true;
                try {
                    zza(zzht());
                } catch (JSONException e) {
                    zzkn.zzb("JSON failure while processing active view data.", e);
                } catch (RuntimeException e2) {
                    zzkn.zzb("Failure while processing active view data.", e2);
                }
                String valueOf = String.valueOf(this.zzasj.zzia());
                zzkn.zzdd(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzhm() {
        if (this.zzaso != null) {
            this.zzaso.zza(this);
        }
    }

    public boolean zzhn() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzasr;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = (android.view.ViewTreeObserver) r3.zzash.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzho() {
        /*
            r3 = this;
            com.google.android.gms.internal.zzcq r0 = r3.zzasi
            com.google.android.gms.internal.zzcq r0 = r0.zzhw()
            android.view.View r1 = r0.zzhu()
            if (r1 != 0) goto L_0x000d
        L_0x000c:
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r0 = r3.zzash
            java.lang.Object r0 = r0.get()
            android.view.ViewTreeObserver r0 = (android.view.ViewTreeObserver) r0
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            if (r1 == r0) goto L_0x000c
            r3.zzhp()
            boolean r2 = r3.zzasp
            if (r2 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L_0x0033
        L_0x002a:
            r0 = 1
            r3.zzasp = r0
            r1.addOnScrollChangedListener(r3)
            r1.addOnGlobalLayoutListener(r3)
        L_0x0033:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            r3.zzash = r0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcj.zzho():void");
    }

    /* access modifiers changed from: protected */
    public void zzhp() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzash.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zzhq() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzasj.zzhy()).put("activeViewJSON", this.zzasj.zzhz()).put("timestamp", zzu.zzgf().elapsedRealtime()).put("adFormat", this.zzasj.zzhx()).put("hashCode", this.zzasj.zzia()).put("isMraid", this.zzasj.zzib()).put("isStopped", this.zzasq).put("isPaused", this.zzaoy).put("isScreenOn", isScreenOn()).put("isNative", this.zzasj.zzic()).put("appMuted", zzu.zzfz().zzfg()).put("appVolume", (double) zzu.zzfz().zzfe()).put("deviceVolume", (double) zzu.zzfz().zzal(this.zzask));
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzhr();

    /* access modifiers changed from: protected */
    public JSONObject zzhs() throws JSONException {
        return zzhq().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    /* access modifiers changed from: protected */
    public JSONObject zzht() throws JSONException {
        JSONObject zzhq = zzhq();
        zzhq.put("doneReasonCode", "u");
        return zzhq;
    }

    /* access modifiers changed from: protected */
    public void zzj(boolean z) {
        Iterator<zzck> it = this.zzasv.iterator();
        while (it.hasNext()) {
            it.next().zza(this, z);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        com.google.android.gms.internal.zzkn.zza("Active view update failed.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzk(int r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r3 = r7.zzakd
            monitor-enter(r3)
            boolean r2 = r7.zzhr()     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x000f
            boolean r2 = r7.zzasr     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x0011
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.zzcq r2 = r7.zzasi     // Catch:{ all -> 0x0041 }
            android.view.View r4 = r2.zzhu()     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0044
            com.google.android.gms.internal.zzkr r2 = com.google.android.gms.ads.internal.zzu.zzfz()     // Catch:{ all -> 0x0041 }
            android.os.PowerManager r5 = r7.zzasm     // Catch:{ all -> 0x0041 }
            android.app.KeyguardManager r6 = r7.zzasn     // Catch:{ all -> 0x0041 }
            boolean r2 = r2.zza((android.view.View) r4, (android.os.PowerManager) r5, (android.app.KeyguardManager) r6)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0044
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x0041 }
            r2.<init>()     // Catch:{ all -> 0x0041 }
            r5 = 0
            boolean r2 = r4.getGlobalVisibleRect(r2, r5)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0044
            r2 = r1
        L_0x0034:
            com.google.android.gms.internal.zzcq r5 = r7.zzasi     // Catch:{ all -> 0x0041 }
            boolean r5 = r5.zzhv()     // Catch:{ all -> 0x0041 }
            if (r5 == 0) goto L_0x0046
            r7.zzhl()     // Catch:{ all -> 0x0041 }
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0010
        L_0x0041:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            throw r0
        L_0x0044:
            r2 = r0
            goto L_0x0034
        L_0x0046:
            if (r8 != r1) goto L_0x0049
            r0 = r1
        L_0x0049:
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.zzlc r0 = r7.zzasa     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.tryAcquire()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0059
            boolean r0 = r7.zzast     // Catch:{ all -> 0x0041 }
            if (r2 != r0) goto L_0x0059
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0010
        L_0x0059:
            if (r2 != 0) goto L_0x0063
            boolean r0 = r7.zzast     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0063
            if (r8 != r1) goto L_0x0063
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0010
        L_0x0063:
            org.json.JSONObject r0 = r7.zzd((android.view.View) r4)     // Catch:{ JSONException -> 0x0074, RuntimeException -> 0x007b }
            r7.zza((org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x0074, RuntimeException -> 0x007b }
            r7.zzast = r2     // Catch:{ JSONException -> 0x0074, RuntimeException -> 0x007b }
        L_0x006c:
            r7.zzho()     // Catch:{ all -> 0x0041 }
            r7.zzhm()     // Catch:{ all -> 0x0041 }
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0010
        L_0x0074:
            r0 = move-exception
        L_0x0075:
            java.lang.String r1 = "Active view update failed."
            com.google.android.gms.internal.zzkn.zza(r1, r0)     // Catch:{ all -> 0x0041 }
            goto L_0x006c
        L_0x007b:
            r0 = move-exception
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcj.zzk(int):void");
    }
}
