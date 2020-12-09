package com.facebook.ads;

import android.content.Context;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAdView;
import java.util.ArrayList;
import java.util.List;

public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f839a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final NativeAdsManager f840b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AdViewProvider f841c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final NativeAdView.Type f842d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f843e;

    /* renamed from: f */
    private final C0427b f844f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final NativeAdViewAttributes f845g;

    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i);

        void destroyView(NativeAd nativeAd, View view);
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView$a */
    private class C0426a extends PagerAdapter {

        /* renamed from: b */
        private List<NativeAd> f847b = new ArrayList();

        public C0426a() {
        }

        /* renamed from: a */
        public void mo5843a() {
            this.f847b.clear();
            int min = Math.min(NativeAdScrollView.this.f843e, NativeAdScrollView.this.f840b.getUniqueNativeAdCount());
            for (int i = 0; i < min; i++) {
                NativeAd nextNativeAd = NativeAdScrollView.this.f840b.nextNativeAd();
                nextNativeAd.mo5792a(true);
                this.f847b.add(nextNativeAd);
            }
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < this.f847b.size()) {
                if (NativeAdScrollView.this.f842d != null) {
                    this.f847b.get(i).unregisterView();
                } else {
                    NativeAdScrollView.this.f841c.destroyView(this.f847b.get(i), (View) obj);
                }
            }
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f847b.size();
        }

        public int getItemPosition(Object obj) {
            int indexOf = this.f847b.indexOf(obj);
            if (indexOf >= 0) {
                return indexOf;
            }
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View render = NativeAdScrollView.this.f842d != null ? NativeAdView.render(NativeAdScrollView.this.f839a, this.f847b.get(i), NativeAdScrollView.this.f842d, NativeAdScrollView.this.f845g) : NativeAdScrollView.this.f841c.createView(this.f847b.get(i), i);
            viewGroup.addView(render);
            return render;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView$b */
    private class C0427b extends ViewPager {
        public C0427b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, (NativeAdView.Type) null, (NativeAdViewAttributes) null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i) {
        this(context, nativeAdsManager, adViewProvider, (NativeAdView.Type) null, (NativeAdViewAttributes) null, i);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        super(context);
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException("NativeAdsManager not loaded");
        } else if (type == null && adViewProvider == null) {
            throw new IllegalArgumentException("Must provide one of AdLayoutProperties or a CustomAdView");
        } else {
            this.f839a = context;
            this.f840b = nativeAdsManager;
            this.f845g = nativeAdViewAttributes;
            this.f841c = adViewProvider;
            this.f842d = type;
            this.f843e = i;
            C0426a aVar = new C0426a();
            this.f844f = new C0427b(context);
            this.f844f.setAdapter(aVar);
            setInset(20);
            aVar.mo5843a();
            addView(this.f844f);
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, new NativeAdViewAttributes(), 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, nativeAdViewAttributes, i);
    }

    public void setInset(int i) {
        if (i > 0) {
            DisplayMetrics displayMetrics = this.f839a.getResources().getDisplayMetrics();
            int round = Math.round(((float) i) * displayMetrics.density);
            this.f844f.setPadding(round, 0, round, 0);
            this.f844f.setPageMargin(Math.round(displayMetrics.density * ((float) (i / 2))));
            this.f844f.setClipToPadding(false);
        }
    }
}
