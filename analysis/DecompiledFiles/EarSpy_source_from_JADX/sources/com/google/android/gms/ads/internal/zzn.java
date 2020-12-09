package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgv;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzn {
    private static zzd zza(zzgu zzgu) throws RemoteException {
        return new zzd(zzgu.getHeadline(), zzgu.getImages(), zzgu.getBody(), zzgu.zzlo(), zzgu.getCallToAction(), zzgu.getStarRating(), zzgu.getStore(), zzgu.getPrice(), (zza) null, zzgu.getExtras(), (zzab) null, (View) null);
    }

    private static zze zza(zzgv zzgv) throws RemoteException {
        return new zze(zzgv.getHeadline(), zzgv.getImages(), zzgv.getBody(), zzgv.zzlt(), zzgv.getCallToAction(), zzgv.getAdvertiser(), (zza) null, zzgv.getExtras());
    }

    static zzev zza(@Nullable final zzgu zzgu, @Nullable final zzgv zzgv, final zzf.zza zza) {
        return new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                View view = zzlt.getView();
                if (view != null) {
                    try {
                        if (zzgu.this != null) {
                            if (!zzgu.this.getOverrideClickHandling()) {
                                zzgu.this.zzk(com.google.android.gms.dynamic.zze.zzac(view));
                                zza.onClick();
                                return;
                            }
                            zzn.zza(zzlt);
                        } else if (zzgv == null) {
                        } else {
                            if (!zzgv.getOverrideClickHandling()) {
                                zzgv.zzk(com.google.android.gms.dynamic.zze.zzac(view));
                                zza.onClick();
                                return;
                            }
                            zzn.zza(zzlt);
                        }
                    } catch (RemoteException e) {
                        zzkn.zzd("Unable to call handleClick on mapper", e);
                    }
                }
            }
        };
    }

    static zzev zza(final CountDownLatch countDownLatch) {
        return new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                countDownLatch.countDown();
                zzlt.getView().setVisibility(0);
            }
        };
    }

    private static String zza(@Nullable Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzkn.zzdf("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String zza(@Nullable zzdx zzdx) {
        if (zzdx == null) {
            zzkn.zzdf("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzdx.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzkn.zzdf("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzdx);
    }

    /* access modifiers changed from: private */
    public static JSONObject zza(@Nullable Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, zza((Bitmap) obj));
                    } else {
                        zzkn.zzdf("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzkn.zzdf("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    public static void zza(@Nullable zzke zzke, zzf.zza zza) {
        zzgv zzgv = null;
        if (zzke != null && zzh(zzke)) {
            zzlt zzlt = zzke.zzbyh;
            View view = zzlt != null ? zzlt.getView() : null;
            if (view == null) {
                zzkn.zzdf("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzke.zzbte != null ? zzke.zzbte.zzbrz : null;
                if (list == null || list.isEmpty()) {
                    zzkn.zzdf("No template ids present in mediation response");
                    return;
                }
                zzgu zznm = zzke.zzbtf != null ? zzke.zzbtf.zznm() : null;
                if (zzke.zzbtf != null) {
                    zzgv = zzke.zzbtf.zznn();
                }
                if (list.contains("2") && zznm != null) {
                    zznm.zzl(com.google.android.gms.dynamic.zze.zzac(view));
                    if (!zznm.getOverrideImpressionRecording()) {
                        zznm.recordImpression();
                    }
                    zzlt.zzvr().zza("/nativeExpressViewClicked", zza(zznm, (zzgv) null, zza));
                } else if (!list.contains("1") || zzgv == null) {
                    zzkn.zzdf("No matching template id and mapper");
                } else {
                    zzgv.zzl(com.google.android.gms.dynamic.zze.zzac(view));
                    if (!zzgv.getOverrideImpressionRecording()) {
                        zzgv.recordImpression();
                    }
                    zzlt.zzvr().zza("/nativeExpressViewClicked", zza((zzgu) null, zzgv, zza));
                }
            } catch (RemoteException e) {
                zzkn.zzd("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(zzlt zzlt) {
        View.OnClickListener zzwf = zzlt.zzwf();
        if (zzwf != null) {
            zzwf.onClick(zzlt.getView());
        }
    }

    private static void zza(final zzlt zzlt, final zzd zzd, final String str) {
        zzlt.zzvr().zza((zzlu.zza) new zzlu.zza() {
            public void zza(zzlt zzlt, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzd.this.getHeadline());
                    jSONObject.put("body", zzd.this.getBody());
                    jSONObject.put("call_to_action", zzd.this.getCallToAction());
                    jSONObject.put(FirebaseAnalytics.Param.PRICE, zzd.this.getPrice());
                    jSONObject.put("star_rating", String.valueOf(zzd.this.getStarRating()));
                    jSONObject.put("store", zzd.this.getStore());
                    jSONObject.put("icon", zzn.zza(zzd.this.zzlo()));
                    JSONArray jSONArray = new JSONArray();
                    List<Object> images = zzd.this.getImages();
                    if (images != null) {
                        for (Object zzf : images) {
                            jSONArray.put(zzn.zza(zzn.zze(zzf)));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzn.zza(zzd.this.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "2");
                    zzlt.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzkn.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(final zzlt zzlt, final zze zze, final String str) {
        zzlt.zzvr().zza((zzlu.zza) new zzlu.zza() {
            public void zza(zzlt zzlt, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zze.this.getHeadline());
                    jSONObject.put("body", zze.this.getBody());
                    jSONObject.put("call_to_action", zze.this.getCallToAction());
                    jSONObject.put("advertiser", zze.this.getAdvertiser());
                    jSONObject.put("logo", zzn.zza(zze.this.zzlt()));
                    JSONArray jSONArray = new JSONArray();
                    List<Object> images = zze.this.getImages();
                    if (images != null) {
                        for (Object zzf : images) {
                            jSONArray.put(zzn.zza(zzn.zze(zzf)));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzn.zza(zze.this.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "1");
                    zzlt.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzkn.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(zzlt zzlt, CountDownLatch countDownLatch) {
        zzlt.zzvr().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        zzlt.zzvr().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzlt zzlt, zzgl zzgl, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = zzb(zzlt, zzgl, countDownLatch);
        } catch (RemoteException e) {
            zzkn.zzd("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    static zzev zzb(final CountDownLatch countDownLatch) {
        return new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                zzkn.zzdf("Adapter returned an ad, but assets substitution failed");
                countDownLatch.countDown();
                zzlt.destroy();
            }
        };
    }

    private static String zzb(zzdx zzdx) {
        try {
            com.google.android.gms.dynamic.zzd zzln = zzdx.zzln();
            if (zzln == null) {
                zzkn.zzdf("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzae(zzln);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzkn.zzdf("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            zzkn.zzdf("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static boolean zzb(zzlt zzlt, zzgl zzgl, CountDownLatch countDownLatch) throws RemoteException {
        View view = zzlt.getView();
        if (view == null) {
            zzkn.zzdf("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List<String> list = zzgl.zzbte.zzbrz;
        if (list == null || list.isEmpty()) {
            zzkn.zzdf("No template ids present in mediation response");
            return false;
        }
        zza(zzlt, countDownLatch);
        zzgu zznm = zzgl.zzbtf.zznm();
        zzgv zznn = zzgl.zzbtf.zznn();
        if (list.contains("2") && zznm != null) {
            zza(zzlt, zza(zznm), zzgl.zzbte.zzbry);
        } else if (!list.contains("1") || zznn == null) {
            zzkn.zzdf("No matching template id and mapper");
            return false;
        } else {
            zza(zzlt, zza(zznn), zzgl.zzbte.zzbry);
        }
        String str = zzgl.zzbte.zzbrw;
        String str2 = zzgl.zzbte.zzbrx;
        if (str2 != null) {
            zzlt.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        } else {
            zzlt.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* access modifiers changed from: private */
    @Nullable
    public static zzdx zze(Object obj) {
        if (obj instanceof IBinder) {
            return zzdx.zza.zzab((IBinder) obj);
        }
        return null;
    }

    @Nullable
    public static View zzg(@Nullable zzke zzke) {
        if (zzke == null) {
            zzkn.m1352e("AdState is null");
            return null;
        } else if (zzh(zzke) && zzke.zzbyh != null) {
            return zzke.zzbyh.getView();
        } else {
            try {
                com.google.android.gms.dynamic.zzd view = zzke.zzbtf != null ? zzke.zzbtf.getView() : null;
                if (view != null) {
                    return (View) com.google.android.gms.dynamic.zze.zzae(view);
                }
                zzkn.zzdf("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzkn.zzd("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzh(@Nullable zzke zzke) {
        return (zzke == null || !zzke.zzchc || zzke.zzbte == null || zzke.zzbte.zzbrw == null) ? false : true;
    }
}
