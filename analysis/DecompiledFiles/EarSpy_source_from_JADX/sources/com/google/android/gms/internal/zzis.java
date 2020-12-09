package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzli;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzis implements Callable<zzke> {
    private static final long zzcdo = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final Object zzakd = new Object();
    private final zzdq zzalg;
    private final zzir zzbkn;
    private final zzau zzbkp;
    /* access modifiers changed from: private */
    public final zzke.zza zzcck;
    private int zzcdb;
    private final zzky zzcdx;
    /* access modifiers changed from: private */
    public final zzq zzcdy;
    private boolean zzcdz;
    private List<String> zzcea;
    private JSONObject zzceb;

    public interface zza<T extends zzi.zza> {
        T zza(zzis zzis, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        public zzev zzcev;

        zzb() {
        }
    }

    public zzis(Context context, zzq zzq, zzky zzky, zzau zzau, zzke.zza zza2, zzdq zzdq) {
        this.mContext = context;
        this.zzcdy = zzq;
        this.zzcdx = zzky;
        this.zzcck = zza2;
        this.zzbkp = zzau;
        this.zzalg = zzdq;
        this.zzbkn = zza(context, zza2, zzq, zzau);
        this.zzbkn.zzre();
        this.zzcdz = false;
        this.zzcdb = -2;
        this.zzcea = null;
    }

    private zzi.zza zza(zza zza2, JSONObject jSONObject, String str) throws ExecutionException, InterruptedException, JSONException {
        if (zzrq() || zza2 == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzd = zzd(jSONObject2, "impression_tracking_urls");
        this.zzcea = zzd == null ? null : Arrays.asList(zzd);
        this.zzceb = jSONObject2.optJSONObject("active_view");
        zzi.zza zza3 = zza2.zza(this, jSONObject);
        if (zza3 == null) {
            zzkn.m1352e("Failed to retrieve ad assets.");
            return null;
        }
        zza3.zzb(new zzj(this.mContext, this.zzcdy, this.zzbkn, this.zzbkp, jSONObject, zza3, this.zzcck.zzcix.zzaqv, str));
        return zza3;
    }

    private zzlj<zzc> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        final boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(string)) {
            zza(0, z);
            return new zzlh(null);
        } else if (z2) {
            return new zzlh(new zzc((Drawable) null, Uri.parse(string), optDouble));
        } else {
            final boolean z3 = z;
            return this.zzcdx.zza(string, new zzky.zza<zzc>() {
                @TargetApi(19)
                /* renamed from: zzg */
                public zzc zzh(InputStream inputStream) {
                    Bitmap bitmap;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = (int) (160.0d * optDouble);
                    if (!optBoolean) {
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    } catch (Exception e) {
                        zzkn.zzb("Error grabbing image.", e);
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        zzis.this.zza(2, z3);
                        return null;
                    }
                    if (zzs.zzaxr()) {
                        int width = bitmap.getWidth();
                        zzkn.m1493v(new StringBuilder(61).append("Decoded image w: ").append(width).append(" h:").append(bitmap.getHeight()).append(" bytes: ").append(bitmap.getAllocationByteCount()).toString());
                    }
                    return new zzc(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(string), optDouble);
                }

                /* renamed from: zzrr */
                public zzc zzrs() {
                    zzis.this.zza(2, z3);
                    return null;
                }
            });
        }
    }

    private void zza(zzi.zza zza2) {
        if (zza2 instanceof zzf) {
            final zzf zzf = (zzf) zza2;
            zzb zzb2 = new zzb();
            final C09643 r1 = new zzev() {
                public void zza(zzlt zzlt, Map<String, String> map) {
                    zzis.this.zzb((zzef) zzf, map.get("asset"));
                }
            };
            zzb2.zzcev = r1;
            this.zzbkn.zza((zzir.zza) new zzir.zza() {
                public void zze(zzfz zzfz) {
                    zzfz.zza("/nativeAdCustomClick", r1);
                }
            });
        }
    }

    private zzke zzb(zzi.zza zza2) {
        int i;
        synchronized (this.zzakd) {
            i = this.zzcdb;
            if (zza2 == null && this.zzcdb == -2) {
                i = 0;
            }
        }
        return new zzke(this.zzcck.zzcix.zzcfu, (zzlt) null, this.zzcck.zzcop.zzbsd, i, this.zzcck.zzcop.zzbse, this.zzcea, this.zzcck.zzcop.orientation, this.zzcck.zzcop.zzbsj, this.zzcck.zzcix.zzcfx, false, (zzgg) null, (zzgr) null, (String) null, (zzgh) null, (zzgj) null, 0, this.zzcck.zzaqz, this.zzcck.zzcop.zzchb, this.zzcck.zzcoj, this.zzcck.zzcok, this.zzcck.zzcop.zzchh, this.zzceb, i != -2 ? null : zza2, (RewardItemParcel) null, (List<String>) null, (List<String>) null, this.zzcck.zzcop.zzchu, this.zzcck.zzcop.zzchv, (String) null, this.zzcck.zzcop.zzbsg, this.zzcck.zzcop.zzchy);
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void zzb(zzef zzef, String str) {
        try {
            zzej zzx = this.zzcdy.zzx(zzef.getCustomTemplateId());
            if (zzx != null) {
                zzx.zza(zzef, str);
            }
        } catch (RemoteException e) {
            zzkn.zzd(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private JSONObject zzcf(final String str) throws ExecutionException, InterruptedException, TimeoutException, JSONException {
        if (zzrq()) {
            return null;
        }
        final zzlg zzlg = new zzlg();
        final zzb zzb2 = new zzb();
        this.zzbkn.zza((zzir.zza) new zzir.zza() {
            public void zze(final zzfz zzfz) {
                C09621 r0 = new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        zzfz.zzb("/nativeAdPreProcess", zzb2.zzcev);
                        try {
                            String str = map.get("success");
                            if (!TextUtils.isEmpty(str)) {
                                zzlg.zzh(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                                return;
                            }
                        } catch (JSONException e) {
                            zzkn.zzb("Malformed native JSON response.", e);
                        }
                        zzis.this.zzap(0);
                        zzac.zza(zzis.this.zzrq(), (Object) "Unable to set the ad state error!");
                        zzlg.zzh(null);
                    }
                };
                zzb2.zzcev = r0;
                zzfz.zza("/nativeAdPreProcess", (zzev) r0);
                try {
                    JSONObject jSONObject = new JSONObject(zzis.this.zzcck.zzcop.body);
                    jSONObject.put("ads_id", str);
                    zzfz.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
                } catch (JSONException e) {
                    zzkn.zzd("Exception occurred while invoking javascript", e);
                    zzlg.zzh(null);
                }
            }

            public void zzro() {
                zzlg.zzh(null);
            }
        });
        return (JSONObject) zzlg.get(zzcdo, TimeUnit.MILLISECONDS);
    }

    private String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public static List<Drawable> zzh(List<zzc> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        for (zzc zzln : list) {
            arrayList.add((Drawable) zze.zzae(zzln.zzln()));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public zzir zza(Context context, zzke.zza zza2, zzq zzq, zzau zzau) {
        return new zzir(context, zza2, zzq, zzau);
    }

    /* access modifiers changed from: package-private */
    public zzit zza(Context context, zzau zzau, zzke.zza zza2, zzdq zzdq, zzq zzq) {
        return new zzit(context, zzau, zza2, zzdq, zzq);
    }

    public zzlj<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzlj<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzap(i);
        }
    }

    public void zzap(int i) {
        synchronized (this.zzakd) {
            this.zzcdz = true;
            this.zzcdb = i;
        }
    }

    public zzlj<zzlt> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new zzlh(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzkn.zzdf("Required field 'vast_xml' is missing");
            return new zzlh(null);
        }
        return zza(this.mContext, this.zzbkp, this.zzcck, this.zzalg, this.zzcdy).zzh(optJSONObject);
    }

    /* access modifiers changed from: protected */
    public zza zzf(JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException, TimeoutException {
        if (zzrq() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzcck.zzcix.zzarn != null ? this.zzcck.zzcix.zzarn.zzblb : false;
        boolean z2 = this.zzcck.zzcix.zzarn != null ? this.zzcck.zzcix.zzarn.zzbld : false;
        if ("2".equals(string)) {
            return new zziu(z, z2);
        }
        if ("1".equals(string)) {
            return new zziv(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzlg zzlg = new zzlg();
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzlg.zzh(zzis.this.zzcdy.zzfi().get(string2));
                }
            });
            if (zzlg.get(zzcdo, TimeUnit.MILLISECONDS) != null) {
                return new zziw(z);
            }
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzkn.m1352e(valueOf.length() != 0 ? "No handler for custom template: ".concat(valueOf) : new String("No handler for custom template: "));
        } else {
            zzap(0);
        }
        return null;
    }

    public zzlj<com.google.android.gms.ads.internal.formats.zza> zzg(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzlh(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb2 = zzb(optJSONObject, "text_color");
        Integer zzb3 = zzb(optJSONObject, "bg_color");
        final int optInt2 = optJSONObject.optInt("animation_ms", AdError.NETWORK_ERROR_CODE);
        final int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        final int i = (this.zzcck.zzcix.zzarn == null || this.zzcck.zzcix.zzarn.versionCode < 2) ? 1 : this.zzcck.zzcix.zzarn.zzble;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        final String str = optString;
        final Integer num = zzb3;
        final Integer num2 = zzb2;
        final int i2 = optInt;
        return zzli.zza(zzli.zzo(arrayList), new zzli.zza<List<zzc>, com.google.android.gms.ads.internal.formats.zza>() {
            /* renamed from: zzj */
            public com.google.android.gms.ads.internal.formats.zza apply(List<zzc> list) {
                com.google.android.gms.ads.internal.formats.zza zza;
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            zza = new com.google.android.gms.ads.internal.formats.zza(str, zzis.zzh(list), num, num2, i2 > 0 ? Integer.valueOf(i2) : null, optInt3 + optInt2, i);
                            return zza;
                        }
                    } catch (RemoteException e) {
                        zzkn.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                zza = null;
                return zza;
            }
        });
    }

    /* renamed from: zzrp */
    public zzke call() {
        try {
            this.zzbkn.zzrf();
            String uuid = UUID.randomUUID().toString();
            JSONObject zzcf = zzcf(uuid);
            zzi.zza zza2 = zza(zzf(zzcf), zzcf, uuid);
            zza(zza2);
            return zzb(zza2);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
        } catch (JSONException e2) {
            zzkn.zzd("Malformed native JSON response.", e2);
        } catch (TimeoutException e3) {
            zzkn.zzd("Timeout when loading native ad.", e3);
        }
        if (!this.zzcdz) {
            zzap(0);
        }
        return zzb((zzi.zza) null);
    }

    public boolean zzrq() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcdz;
        }
        return z;
    }
}
