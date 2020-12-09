package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzj implements zzi {
    private final Context mContext;
    private final Object zzakd = new Object();
    @Nullable
    private final VersionInfoParcel zzanh;
    private final zzq zzbkj;
    @Nullable
    private final JSONObject zzbkm;
    @Nullable
    private final zzir zzbkn;
    @Nullable
    private final zzi.zza zzbko;
    private final zzau zzbkp;
    private boolean zzbkq;
    /* access modifiers changed from: private */
    public zzlt zzbkr;
    /* access modifiers changed from: private */
    public String zzbks;
    @Nullable
    private String zzbkt;
    private WeakReference<View> zzbku = null;

    public zzj(Context context, zzq zzq, @Nullable zzir zzir, zzau zzau, @Nullable JSONObject jSONObject, @Nullable zzi.zza zza, @Nullable VersionInfoParcel versionInfoParcel, @Nullable String str) {
        this.mContext = context;
        this.zzbkj = zzq;
        this.zzbkn = zzir;
        this.zzbkp = zzau;
        this.zzbkm = jSONObject;
        this.zzbko = zza;
        this.zzanh = versionInfoParcel;
        this.zzbkt = str;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void recordImpression() {
        zzac.zzhq("recordImpression must be called on the main UI thread.");
        zzr(true);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzbkm);
            jSONObject.put("ads_id", this.zzbkt);
            this.zzbkn.zza((zzir.zza) new zzir.zza() {
                public void zze(zzfz zzfz) {
                    zzfz.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
                }
            });
        } catch (JSONException e) {
            zzkn.zzb("Unable to create impression JSON.", e);
        }
        this.zzbkj.zza((zzi) this);
    }

    public zzb zza(View.OnClickListener onClickListener) {
        zza zzlr = this.zzbko.zzlr();
        if (zzlr == null) {
            return null;
        }
        zzb zzb = new zzb(this.mContext, zzlr);
        zzb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zzb.zzlm().setOnClickListener(onClickListener);
        zzb.zzlm().setContentDescription(zzdi.zzbgd.get());
        return zzb;
    }

    public void zza(View view, zzg zzg) {
        zzdx zze;
        if (this.zzbko instanceof zzd) {
            zzd zzd = (zzd) this.zzbko;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (zzd.zzls() != null) {
                ((FrameLayout) view).addView(zzd.zzls(), layoutParams);
                this.zzbkj.zza(zzg);
            } else if (zzd.getImages() != null && zzd.getImages().size() > 0 && (zze = zze(zzd.getImages().get(0))) != null) {
                try {
                    zzd zzln = zze.zzln();
                    if (zzln != null) {
                        ImageView zzmb = zzmb();
                        zzmb.setImageDrawable((Drawable) zze.zzae(zzln));
                        zzmb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((FrameLayout) view).addView(zzmb, layoutParams);
                    }
                } catch (RemoteException e) {
                    zzkn.zzdf("Could not get drawable from image");
                }
            }
        }
    }

    public void zza(View view, String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3) {
        zzac.zzhq("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.zzbko.zzlq());
            final JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzbkm);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.zzbkj.zzx(this.zzbko.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            try {
                JSONObject optJSONObject = this.zzbkm.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject4.put("click_signals", this.zzbkp.zzaw().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Exception e) {
                zzkn.zzb("Exception obtaining click signals", e);
            }
            jSONObject5.put("ads_id", this.zzbkt);
            this.zzbkn.zza((zzir.zza) new zzir.zza() {
                public void zze(zzfz zzfz) {
                    zzfz.zza("google.afma.nativeAds.handleClickGmsg", jSONObject5);
                }
            });
        } catch (JSONException e2) {
            zzkn.zzb("Unable to create click JSON.", e2);
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        if (zzdi.zzbga.get().booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzac.zzhq("performClick must be called on the main UI thread.");
        for (Map.Entry next : map.entrySet()) {
            if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                zza(view, (String) next.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
        if ("2".equals(this.zzbko.zzlq())) {
            zza(view, "2099", jSONObject, jSONObject2, jSONObject3);
        } else if ("1".equals(this.zzbko.zzlq())) {
            zza(view, "1099", jSONObject, jSONObject2, jSONObject3);
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        view.setOnTouchListener((View.OnTouchListener) null);
        view.setClickable(false);
        view.setOnClickListener((View.OnClickListener) null);
        for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
            View view2 = (View) ((WeakReference) value.getValue()).get();
            if (view2 != null) {
                view2.setOnTouchListener((View.OnTouchListener) null);
                view2.setClickable(false);
                view2.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public void zzd(MotionEvent motionEvent) {
        this.zzbkp.zza(motionEvent);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public zzdx zze(Object obj) {
        if (obj instanceof IBinder) {
            return zzdx.zza.zzab((IBinder) obj);
        }
        return null;
    }

    public void zzg(View view) {
        synchronized (this.zzakd) {
            if (!this.zzbkq) {
                if (view.isShown()) {
                    if (view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                        recordImpression();
                    }
                }
            }
        }
    }

    public void zzh(View view) {
        this.zzbku = new WeakReference<>(view);
    }

    public zzlt zzlx() {
        this.zzbkr = zzma();
        this.zzbkr.getView().setVisibility(8);
        this.zzbkn.zza((zzir.zza) new zzir.zza() {
            public void zze(final zzfz zzfz) {
                zzfz.zza("/loadHtml", (zzev) new zzev() {
                    public void zza(zzlt zzlt, final Map<String, String> map) {
                        zzj.this.zzbkr.zzvr().zza((zzlu.zza) new zzlu.zza() {
                            public void zza(zzlt zzlt, boolean z) {
                                String unused = zzj.this.zzbks = (String) map.get("id");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("messageType", "htmlLoaded");
                                    jSONObject.put("id", zzj.this.zzbks);
                                    zzfz.zzb("sendMessageToNativeJs", jSONObject);
                                } catch (JSONException e) {
                                    zzkn.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                                }
                            }
                        });
                        String str = map.get("overlayHtml");
                        String str2 = map.get("baseUrl");
                        if (TextUtils.isEmpty(str2)) {
                            zzj.this.zzbkr.loadData(str, "text/html", "UTF-8");
                        } else {
                            zzj.this.zzbkr.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
                        }
                    }
                });
                zzfz.zza("/showOverlay", (zzev) new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        zzj.this.zzbkr.getView().setVisibility(0);
                    }
                });
                zzfz.zza("/hideOverlay", (zzev) new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        zzj.this.zzbkr.getView().setVisibility(8);
                    }
                });
                zzj.this.zzbkr.zzvr().zza("/hideOverlay", (zzev) new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        zzj.this.zzbkr.getView().setVisibility(8);
                    }
                });
                zzj.this.zzbkr.zzvr().zza("/sendMessageToSdk", (zzev) new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            for (String next : map.keySet()) {
                                jSONObject.put(next, map.get(next));
                            }
                            jSONObject.put("id", zzj.this.zzbks);
                            zzfz.zzb("sendMessageToNativeJs", jSONObject);
                        } catch (JSONException e) {
                            zzkn.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                        }
                    }
                });
            }
        });
        return this.zzbkr;
    }

    public View zzly() {
        if (this.zzbku != null) {
            return (View) this.zzbku.get();
        }
        return null;
    }

    public void zzlz() {
        if (this.zzbko instanceof zzd) {
            this.zzbkj.zzfj();
        }
    }

    /* access modifiers changed from: package-private */
    public zzlt zzma() {
        return zzu.zzga().zza(this.mContext, AdSizeParcel.zzk(this.mContext), false, false, this.zzbkp, this.zzanh);
    }

    /* access modifiers changed from: package-private */
    public ImageView zzmb() {
        return new ImageView(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void zzr(boolean z) {
        this.zzbkq = z;
    }
}
