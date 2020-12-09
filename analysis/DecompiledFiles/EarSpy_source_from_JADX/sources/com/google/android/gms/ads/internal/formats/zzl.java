package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zziy
public class zzl extends zzdz.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Object zzakd = new Object();
    /* access modifiers changed from: private */
    @Nullable
    public FrameLayout zzaks;
    @Nullable
    private zzi zzbkb;
    private final FrameLayout zzblg;
    private Map<String, WeakReference<View>> zzblh = new HashMap();
    @Nullable
    private zzb zzbli;
    boolean zzblj = false;
    int zzblk;
    int zzbll;

    public zzl(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzblg = frameLayout;
        this.zzaks = frameLayout2;
        zzu.zzgx().zza((View) this.zzblg, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzu.zzgx().zza((View) this.zzblg, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzblg.setOnTouchListener(this);
        this.zzblg.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void zzd(zzj zzj) {
        if (!this.zzblh.containsKey("2011")) {
            zzj.zzlz();
            return;
        }
        final View view = (View) this.zzblh.get("2011").get();
        if (!(view instanceof FrameLayout)) {
            zzj.zzlz();
        } else {
            zzj.zza(view, (zzg) new zzg() {
                public void zzc(MotionEvent motionEvent) {
                    zzl.this.onTouch((View) null, motionEvent);
                }

                public void zzlu() {
                    zzl.this.onClick(view);
                }
            });
        }
    }

    public void destroy() {
        synchronized (this.zzakd) {
            if (this.zzaks != null) {
                this.zzaks.removeAllViews();
            }
            this.zzaks = null;
            this.zzblh = null;
            this.zzbli = null;
            this.zzbkb = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int getMeasuredHeight() {
        return this.zzblg.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public int getMeasuredWidth() {
        return this.zzblg.getMeasuredWidth();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r10) {
        /*
            r9 = this;
            java.lang.Object r6 = r9.zzakd
            monitor-enter(r6)
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
        L_0x0008:
            return
        L_0x0009:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r3.<init>()     // Catch:{ all -> 0x0090 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r9.zzblh     // Catch:{ all -> 0x0090 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0090 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0090 }
        L_0x0018:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0090 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r0.getValue()     // Catch:{ all -> 0x0090 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0090 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0018
            android.graphics.Point r4 = r9.zzi(r1)     // Catch:{ all -> 0x0090 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = "width"
            int r8 = r1.getWidth()     // Catch:{ JSONException -> 0x0075 }
            int r8 = r9.zzz(r8)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r7, r8)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r7 = "height"
            int r1 = r1.getHeight()     // Catch:{ JSONException -> 0x0075 }
            int r1 = r9.zzz(r1)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r7, r1)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = "x"
            int r7 = r4.x     // Catch:{ JSONException -> 0x0075 }
            int r7 = r9.zzz(r7)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r1, r7)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = "y"
            int r4 = r4.y     // Catch:{ JSONException -> 0x0075 }
            int r4 = r9.zzz(r4)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r1, r4)     // Catch:{ JSONException -> 0x0075 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0075 }
            r3.put(r1, r5)     // Catch:{ JSONException -> 0x0075 }
            goto L_0x0018
        L_0x0075:
            r1 = move-exception
            java.lang.String r1 = "Unable to get view rectangle for view "
            java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0090 }
            int r4 = r0.length()     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0093
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x0018
        L_0x0090:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            throw r0
        L_0x0093:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0090 }
            r0.<init>(r1)     // Catch:{ all -> 0x0090 }
            goto L_0x008c
        L_0x0099:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r4.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "x"
            int r1 = r9.zzblk     // Catch:{ JSONException -> 0x0104 }
            int r1 = r9.zzz(r1)     // Catch:{ JSONException -> 0x0104 }
            r4.put(r0, r1)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r0 = "y"
            int r1 = r9.zzbll     // Catch:{ JSONException -> 0x0104 }
            int r1 = r9.zzz(r1)     // Catch:{ JSONException -> 0x0104 }
            r4.put(r0, r1)     // Catch:{ JSONException -> 0x0104 }
        L_0x00b4:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "width"
            int r1 = r9.getMeasuredWidth()     // Catch:{ JSONException -> 0x010b }
            int r1 = r9.zzz(r1)     // Catch:{ JSONException -> 0x010b }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x010b }
            java.lang.String r0 = "height"
            int r1 = r9.getMeasuredHeight()     // Catch:{ JSONException -> 0x010b }
            int r1 = r9.zzz(r1)     // Catch:{ JSONException -> 0x010b }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x010b }
        L_0x00d3:
            com.google.android.gms.ads.internal.formats.zzb r0 = r9.zzbli     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x011b
            com.google.android.gms.ads.internal.formats.zzb r0 = r9.zzbli     // Catch:{ all -> 0x0090 }
            android.view.ViewGroup r0 = r0.zzlm()     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.equals(r10)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x011b
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            boolean r0 = r0 instanceof com.google.android.gms.ads.internal.formats.zzh     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0112
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzh r0 = (com.google.android.gms.ads.internal.formats.zzh) r0     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzi r0 = r0.zzlw()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0112
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzh r0 = (com.google.android.gms.ads.internal.formats.zzh) r0     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzi r0 = r0.zzlw()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "1007"
            r1 = r10
            r0.zza((android.view.View) r1, (java.lang.String) r2, (org.json.JSONObject) r3, (org.json.JSONObject) r4, (org.json.JSONObject) r5)     // Catch:{ all -> 0x0090 }
        L_0x0101:
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            goto L_0x0008
        L_0x0104:
            r0 = move-exception
            java.lang.String r0 = "Unable to get click location"
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00b4
        L_0x010b:
            r0 = move-exception
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00d3
        L_0x0112:
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "1007"
            r1 = r10
            r0.zza((android.view.View) r1, (java.lang.String) r2, (org.json.JSONObject) r3, (org.json.JSONObject) r4, (org.json.JSONObject) r5)     // Catch:{ all -> 0x0090 }
            goto L_0x0101
        L_0x011b:
            com.google.android.gms.ads.internal.formats.zzi r0 = r9.zzbkb     // Catch:{ all -> 0x0090 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r2 = r9.zzblh     // Catch:{ all -> 0x0090 }
            r1 = r10
            r0.zza((android.view.View) r1, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r2, (org.json.JSONObject) r3, (org.json.JSONObject) r4, (org.json.JSONObject) r5)     // Catch:{ all -> 0x0090 }
            goto L_0x0101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.zzl.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.zzakd) {
            if (this.zzblj) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.zzaks == null)) {
                    this.zzaks.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzblj = false;
                }
            }
            if (this.zzbkb != null) {
                this.zzbkb.zzg(this.zzblg);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzakd) {
            if (this.zzbkb != null) {
                this.zzbkb.zzg(this.zzblg);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzakd) {
            if (this.zzbkb != null) {
                Point zze = zze(motionEvent);
                this.zzblk = zze.x;
                this.zzbll = zze.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) zze.x, (float) zze.y);
                this.zzbkb.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    public zzd zzas(String str) {
        zzd zzac;
        synchronized (this.zzakd) {
            WeakReference weakReference = this.zzblh.get(str);
            zzac = zze.zzac(weakReference == null ? null : (View) weakReference.get());
        }
        return zzac;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public zzb zzc(zzj zzj) {
        return zzj.zza((View.OnClickListener) this);
    }

    public void zzc(String str, zzd zzd) {
        View view = (View) zze.zzae(zzd);
        synchronized (this.zzakd) {
            if (view == null) {
                this.zzblh.remove(str);
            } else {
                this.zzblh.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Point zze(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzblg.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public void zze(zzd zzd) {
        synchronized (this.zzakd) {
            zzh((View) null);
            Object zzae = zze.zzae(zzd);
            if (!(zzae instanceof zzj)) {
                zzkn.zzdf("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.zzaks != null) {
                this.zzaks.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                this.zzblg.requestLayout();
            }
            this.zzblj = true;
            final zzj zzj = (zzj) zzae;
            if (this.zzbkb != null && zzdi.zzbfz.get().booleanValue()) {
                this.zzbkb.zzb(this.zzblg, this.zzblh);
            }
            if (!(this.zzbkb instanceof zzh) || !((zzh) this.zzbkb).zzlv()) {
                this.zzbkb = zzj;
                if (zzj instanceof zzh) {
                    ((zzh) zzj).zzc((zzi) null);
                }
            } else {
                ((zzh) this.zzbkb).zzc(zzj);
            }
            if (zzdi.zzbfz.get().booleanValue()) {
                this.zzaks.setClickable(false);
            }
            this.zzaks.removeAllViews();
            this.zzbli = zzc(zzj);
            if (this.zzbli != null) {
                this.zzblh.put("1007", new WeakReference(this.zzbli.zzlm()));
                this.zzaks.addView(this.zzbli);
            }
            zzj.zza(this.zzblg, this.zzblh, this, this);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzlt zzlx = zzj.zzlx();
                    if (!(zzlx == null || zzl.this.zzaks == null)) {
                        zzl.this.zzaks.addView(zzlx.getView());
                    }
                    if (!(zzj instanceof zzh)) {
                        zzl.this.zzd(zzj);
                    }
                }
            });
            zzh(this.zzblg);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzh(@Nullable View view) {
        if (this.zzbkb != null) {
            zzi zzlw = this.zzbkb instanceof zzh ? ((zzh) this.zzbkb).zzlw() : this.zzbkb;
            if (zzlw != null) {
                zzlw.zzh(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Point zzi(View view) {
        if (this.zzbli == null || !this.zzbli.zzlm().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.zzblg.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    /* access modifiers changed from: package-private */
    public int zzz(int i) {
        return zzm.zzjr().zzc(this.zzbkb.getContext(), i);
    }
}
