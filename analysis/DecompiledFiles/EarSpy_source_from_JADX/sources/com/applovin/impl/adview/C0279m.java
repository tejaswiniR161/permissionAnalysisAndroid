package com.applovin.impl.adview;

import android.util.AttributeSet;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAdSize;

/* renamed from: com.applovin.impl.adview.m */
class C0279m {
    /* renamed from: a */
    static AppLovinAdSize m149a(AttributeSet attributeSet) {
        String attributeValue;
        if (attributeSet == null || (attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "size")) == null) {
            return null;
        }
        return AppLovinAdSize.fromString(attributeValue);
    }

    /* renamed from: b */
    static boolean m150b(AttributeSet attributeSet) {
        return attributeSet != null && attributeSet.getAttributeBooleanValue(AppLovinAdView.NAMESPACE, "loadAdOnCreate", false);
    }
}
