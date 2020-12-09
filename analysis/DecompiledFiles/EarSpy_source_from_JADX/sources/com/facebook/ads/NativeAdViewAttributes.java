package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.p000v4.view.ViewCompat;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import org.json.JSONObject;

public class NativeAdViewAttributes {

    /* renamed from: a */
    private Typeface f852a = Typeface.DEFAULT;

    /* renamed from: b */
    private int f853b = -1;

    /* renamed from: c */
    private int f854c = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: d */
    private int f855d = -11643291;

    /* renamed from: e */
    private int f856e = 0;

    /* renamed from: f */
    private int f857f = -12420889;

    /* renamed from: g */
    private int f858g = -12420889;

    /* renamed from: h */
    private boolean f859h = true;

    public NativeAdViewAttributes() {
    }

    public NativeAdViewAttributes(JSONObject jSONObject) {
        int i = 0;
        try {
            int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
            int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
            int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
            int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
            i = !jSONObject.getBoolean("button_border_transparent") ? Color.parseColor(jSONObject.getString("button_border_color")) : i;
            int parseColor5 = Color.parseColor(jSONObject.getString("button_text_color"));
            Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
            this.f853b = parseColor;
            this.f854c = parseColor2;
            this.f855d = parseColor3;
            this.f856e = parseColor4;
            this.f858g = i;
            this.f857f = parseColor5;
            this.f852a = create;
        } catch (Exception e) {
            C0531c.m1182a(C0528b.m1179a(e, "Error retrieving native ui configuration data"));
        }
    }

    public boolean getAutoplay() {
        return this.f859h;
    }

    public int getBackgroundColor() {
        return this.f853b;
    }

    public int getButtonBorderColor() {
        return this.f858g;
    }

    public int getButtonColor() {
        return this.f856e;
    }

    public int getButtonTextColor() {
        return this.f857f;
    }

    public int getDescriptionTextColor() {
        return this.f855d;
    }

    public int getDescriptionTextSize() {
        return 10;
    }

    public int getTitleTextColor() {
        return this.f854c;
    }

    public int getTitleTextSize() {
        return 16;
    }

    public Typeface getTypeface() {
        return this.f852a;
    }

    public NativeAdViewAttributes setAutoplay(boolean z) {
        this.f859h = z;
        return this;
    }

    public NativeAdViewAttributes setBackgroundColor(int i) {
        this.f853b = i;
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i) {
        this.f858g = i;
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i) {
        this.f856e = i;
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i) {
        this.f857f = i;
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i) {
        this.f855d = i;
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i) {
        this.f854c = i;
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.f852a = typeface;
        return this;
    }
}
