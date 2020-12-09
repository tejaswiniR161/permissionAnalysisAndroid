package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkq;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
public class zzt extends zzu.zza {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    @Nullable
    public zzq zzamy;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzanh;
    private final AdSizeParcel zzapc;
    /* access modifiers changed from: private */
    public final Future<zzcc> zzapd = zzfp();
    private final zzb zzape;
    /* access modifiers changed from: private */
    @Nullable
    public WebView zzapf = new WebView(this.mContext);
    /* access modifiers changed from: private */
    @Nullable
    public zzcc zzapg;
    private AsyncTask<Void, Void, Void> zzaph;

    private class zza extends AsyncTask<Void, Void, Void> {
        private zza() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            try {
                zzcc unused = zzt.this.zzapg = (zzcc) zzt.this.zzapd.get(zzdi.zzbha.get().longValue(), TimeUnit.MILLISECONDS);
                return null;
            } catch (InterruptedException | ExecutionException e) {
                zzkn.zzd("Failed to load ad data", e);
                return null;
            } catch (TimeoutException e2) {
                zzkn.zzdf("Timed out waiting for ad data");
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            String zzfn = zzt.this.zzfn();
            if (zzt.this.zzapf != null) {
                zzt.this.zzapf.loadUrl(zzfn);
            }
        }
    }

    private static class zzb {
        private final String zzapj;
        private final Map<String, String> zzapk = new TreeMap();
        private String zzapl;
        private String zzapm;

        public zzb(String str) {
            this.zzapj = str;
        }

        public String getQuery() {
            return this.zzapl;
        }

        public String zzfr() {
            return this.zzapm;
        }

        public String zzfs() {
            return this.zzapj;
        }

        public Map<String, String> zzft() {
            return this.zzapk;
        }

        public void zzi(AdRequestParcel adRequestParcel) {
            this.zzapl = adRequestParcel.zzawk.zzbab;
            Bundle bundle = adRequestParcel.zzawn != null ? adRequestParcel.zzawn.getBundle(AdMobAdapter.class.getName()) : null;
            if (bundle != null) {
                String str = zzdi.zzbgz.get();
                for (String str2 : bundle.keySet()) {
                    if (str.equals(str2)) {
                        this.zzapm = bundle.getString(str2);
                    } else if (str2.startsWith("csa_")) {
                        this.zzapk.put(str2.substring("csa_".length()), bundle.getString(str2));
                    }
                }
            }
        }
    }

    public zzt(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzanh = versionInfoParcel;
        this.zzapc = adSizeParcel;
        this.zzape = new zzb(str);
        zzfm();
    }

    /* access modifiers changed from: private */
    public void zzaa(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    private void zzfm() {
        zzj(0);
        this.zzapf.setVerticalScrollBarEnabled(false);
        this.zzapf.getSettings().setJavaScriptEnabled(true);
        this.zzapf.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (zzt.this.zzamy != null) {
                    try {
                        zzt.this.zzamy.onAdFailedToLoad(0);
                    } catch (RemoteException e) {
                        zzkn.zzd("Could not call AdListener.onAdFailedToLoad().", e);
                    }
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith(zzt.this.zzfo())) {
                    return false;
                }
                if (str.startsWith(zzdi.zzbgv.get())) {
                    if (zzt.this.zzamy != null) {
                        try {
                            zzt.this.zzamy.onAdFailedToLoad(3);
                        } catch (RemoteException e) {
                            zzkn.zzd("Could not call AdListener.onAdFailedToLoad().", e);
                        }
                    }
                    zzt.this.zzj(0);
                    return true;
                } else if (str.startsWith(zzdi.zzbgw.get())) {
                    if (zzt.this.zzamy != null) {
                        try {
                            zzt.this.zzamy.onAdFailedToLoad(0);
                        } catch (RemoteException e2) {
                            zzkn.zzd("Could not call AdListener.onAdFailedToLoad().", e2);
                        }
                    }
                    zzt.this.zzj(0);
                    return true;
                } else if (str.startsWith(zzdi.zzbgx.get())) {
                    if (zzt.this.zzamy != null) {
                        try {
                            zzt.this.zzamy.onAdLoaded();
                        } catch (RemoteException e3) {
                            zzkn.zzd("Could not call AdListener.onAdLoaded().", e3);
                        }
                    }
                    zzt.this.zzj(zzt.this.zzy(str));
                    return true;
                } else if (str.startsWith("gmsg://")) {
                    return true;
                } else {
                    if (zzt.this.zzamy != null) {
                        try {
                            zzt.this.zzamy.onAdLeftApplication();
                        } catch (RemoteException e4) {
                            zzkn.zzd("Could not call AdListener.onAdLeftApplication().", e4);
                        }
                    }
                    zzt.this.zzaa(zzt.this.zzz(str));
                    return true;
                }
            }
        });
        this.zzapf.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (zzt.this.zzapg == null) {
                    return false;
                }
                try {
                    zzt.this.zzapg.zza(motionEvent);
                    return false;
                } catch (RemoteException e) {
                    zzkn.zzd("Unable to process ad data", e);
                    return false;
                }
            }
        });
    }

    private Future<zzcc> zzfp() {
        return zzkq.zza(new Callable<zzcc>() {
            /* renamed from: zzfq */
            public zzcc call() throws Exception {
                return new zzcc(zzt.this.zzanh.zzcs, zzt.this.mContext, false);
            }
        });
    }

    /* access modifiers changed from: private */
    public String zzz(String str) {
        if (this.zzapg == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzapg.zzd(parse, this.mContext);
        } catch (RemoteException e) {
            zzkn.zzd("Unable to process ad data", e);
        } catch (zzcd e2) {
            zzkn.zzd("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    public void destroy() throws RemoteException {
        zzac.zzhq("destroy must be called on the main UI thread.");
        this.zzaph.cancel(true);
        this.zzapd.cancel(true);
        this.zzapf.destroy();
        this.zzapf = null;
    }

    @Nullable
    public String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public boolean isLoading() throws RemoteException {
        return false;
    }

    public boolean isReady() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
        zzac.zzhq("pause must be called on the main UI thread.");
    }

    public void resume() throws RemoteException {
        zzac.zzhq("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void stopLoading() throws RemoteException {
    }

    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzp zzp) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzq zzq) throws RemoteException {
        this.zzamy = zzq;
    }

    public void zza(zzw zzw) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzy zzy) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzd zzd) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzdu zzdu) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzhx zzhx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzib zzib, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        zzac.zzb(this.zzapf, (Object) "This Search Ad has already been torn down");
        this.zzape.zzi(adRequestParcel);
        this.zzaph = new zza().execute(new Void[0]);
        return true;
    }

    public com.google.android.gms.dynamic.zzd zzds() throws RemoteException {
        zzac.zzhq("getAdFrame must be called on the main UI thread.");
        return zze.zzac(this.zzapf);
    }

    public AdSizeParcel zzdt() throws RemoteException {
        return this.zzapc;
    }

    public void zzdv() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Nullable
    public zzab zzdw() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public String zzfn() {
        Uri uri;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzdi.zzbgy.get());
        builder.appendQueryParameter("query", this.zzape.getQuery());
        builder.appendQueryParameter("pubId", this.zzape.zzfs());
        Map<String, String> zzft = this.zzape.zzft();
        for (String next : zzft.keySet()) {
            builder.appendQueryParameter(next, zzft.get(next));
        }
        Uri build = builder.build();
        if (this.zzapg != null) {
            try {
                uri = this.zzapg.zzc(build, this.mContext);
            } catch (RemoteException | zzcd e) {
                zzkn.zzd("Unable to process ad data", e);
            }
            String valueOf = String.valueOf(zzfo());
            String valueOf2 = String.valueOf(uri.getEncodedQuery());
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("#").append(valueOf2).toString();
        }
        uri = build;
        String valueOf3 = String.valueOf(zzfo());
        String valueOf22 = String.valueOf(uri.getEncodedQuery());
        return new StringBuilder(String.valueOf(valueOf3).length() + 1 + String.valueOf(valueOf22).length()).append(valueOf3).append("#").append(valueOf22).toString();
    }

    /* access modifiers changed from: package-private */
    public String zzfo() {
        String zzfr = this.zzape.zzfr();
        String str = TextUtils.isEmpty(zzfr) ? "www.google.com" : zzfr;
        String valueOf = String.valueOf("https://");
        String str2 = zzdi.zzbgy.get();
        return new StringBuilder(String.valueOf(valueOf).length() + 0 + String.valueOf(str).length() + String.valueOf(str2).length()).append(valueOf).append(str).append(str2).toString();
    }

    /* access modifiers changed from: package-private */
    public void zzj(int i) {
        if (this.zzapf != null) {
            this.zzapf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    public int zzy(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            return zzm.zzjr().zzb(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
