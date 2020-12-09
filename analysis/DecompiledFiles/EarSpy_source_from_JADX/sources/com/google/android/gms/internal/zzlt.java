package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONObject;

@zziy
public interface zzlt extends zzs, zzck, zzfz {
    void destroy();

    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(Context context, AdSizeParcel adSizeParcel, zzdq zzdq);

    void zza(AdSizeParcel adSizeParcel);

    void zza(zzly zzly);

    void zza(String str, Map<String, ?> map);

    void zza(String str, JSONObject jSONObject);

    void zzah(int i);

    void zzaj(boolean z);

    void zzak(boolean z);

    void zzal(boolean z);

    void zzam(boolean z);

    void zzb(zzg zzg);

    void zzb(zzd zzd);

    void zzc(zzd zzd);

    void zzdg(String str);

    void zzdh(String str);

    com.google.android.gms.ads.internal.zzd zzdp();

    AdSizeParcel zzdt();

    void zzj(String str, String str2);

    void zzoz();

    boolean zzpr();

    void zzvl();

    void zzvm();

    Activity zzvn();

    Context zzvo();

    zzd zzvp();

    zzd zzvq();

    @Nullable
    zzlu zzvr();

    boolean zzvs();

    zzau zzvt();

    VersionInfoParcel zzvu();

    boolean zzvv();

    void zzvw();

    boolean zzvx();

    @Nullable
    zzls zzvy();

    @Nullable
    zzdo zzvz();

    zzdp zzwa();

    @Nullable
    zzly zzwb();

    boolean zzwc();

    void zzwd();

    void zzwe();

    @Nullable
    View.OnClickListener zzwf();

    zzg zzwg();

    void zzwh();
}
