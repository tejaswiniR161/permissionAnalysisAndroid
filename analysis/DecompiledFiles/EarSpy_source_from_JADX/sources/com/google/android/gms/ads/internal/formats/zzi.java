package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public interface zzi {

    public interface zza {
        String getCustomTemplateId();

        void zzb(zzi zzi);

        String zzlq();

        zza zzlr();
    }

    Context getContext();

    void recordImpression();

    void zza(View view, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void zzb(View view, Map<String, WeakReference<View>> map);

    void zzd(MotionEvent motionEvent);

    void zzg(View view);

    void zzh(View view);

    View zzly();
}
