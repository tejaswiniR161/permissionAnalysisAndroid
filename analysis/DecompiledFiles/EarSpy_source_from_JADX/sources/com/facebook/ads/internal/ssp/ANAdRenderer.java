package com.facebook.ads.internal.ssp;

import android.content.Context;
import android.view.View;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C0464d;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.adapters.C0456k;
import com.facebook.ads.internal.view.C0563c;
import org.json.JSONObject;

public class ANAdRenderer {

    public interface Listener {
        void onAdClick();

        void onAdClose();

        void onAdError(Throwable th);

        void onAdImpression();
    }

    public static String getSupportedCapabilities() {
        return C0464d.m976c();
    }

    public static int getTemplateID(int i, int i2) {
        AdSize fromWidthAndHeight = AdSize.fromWidthAndHeight(i, i2);
        if (fromWidthAndHeight == null) {
            return C0473e.UNKNOWN.mo5998a();
        }
        switch (fromWidthAndHeight) {
            case INTERSTITIAL:
                return C0473e.WEBVIEW_INTERSTITIAL_UNKNOWN.mo5998a();
            case RECTANGLE_HEIGHT_250:
                return C0473e.WEBVIEW_BANNER_250.mo5998a();
            case BANNER_HEIGHT_90:
                return C0473e.WEBVIEW_BANNER_90.mo5998a();
            case BANNER_HEIGHT_50:
                return C0473e.WEBVIEW_BANNER_50.mo5998a();
            default:
                return C0473e.WEBVIEW_BANNER_LEGACY.mo5998a();
        }
    }

    public static View renderAd(Context context, JSONObject jSONObject, int i, int i2, int i3, Listener listener) {
        try {
            return new C0563c(context, C0456k.m910a(jSONObject), i3, listener);
        } catch (Throwable th) {
            listener.onAdError(th);
            return null;
        }
    }
}
