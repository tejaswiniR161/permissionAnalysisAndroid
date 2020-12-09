package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.util.C0537g;

public class AdChoicesView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f726a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final NativeAd f727b;

    /* renamed from: c */
    private final DisplayMetrics f728c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f729d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f730e;

    public AdChoicesView(Context context, NativeAd nativeAd) {
        this(context, nativeAd, false);
    }

    public AdChoicesView(Context context, NativeAd nativeAd, boolean z) {
        super(context);
        this.f729d = false;
        this.f726a = context;
        this.f727b = nativeAd;
        this.f728c = this.f726a.getResources().getDisplayMetrics();
        NativeAd.Image adChoicesIcon = this.f727b.getAdChoicesIcon();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (AdChoicesView.this.f729d) {
                    C0537g.m1205a(AdChoicesView.this.f726a, Uri.parse(AdChoicesView.this.f727b.getAdChoicesLinkUrl()));
                } else {
                    AdChoicesView.this.m696a();
                }
                return true;
            }
        });
        this.f730e = new TextView(this.f726a);
        addView(this.f730e);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.addRule(11, m695a(adChoicesIcon).getId());
            layoutParams2.width = 0;
            layoutParams.width = Math.round(((float) (adChoicesIcon.getWidth() + 4)) * this.f728c.density);
            layoutParams.height = Math.round(((float) (adChoicesIcon.getHeight() + 2)) * this.f728c.density);
            this.f729d = false;
        } else {
            this.f729d = true;
        }
        setLayoutParams(layoutParams);
        layoutParams2.addRule(15, -1);
        this.f730e.setLayoutParams(layoutParams2);
        this.f730e.setSingleLine();
        this.f730e.setText("AdChoices");
        this.f730e.setTextSize(10.0f);
        this.f730e.setTextColor(-4341303);
    }

    /* renamed from: a */
    private ImageView m695a(NativeAd.Image image) {
        ImageView imageView = new ImageView(this.f726a);
        addView(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) image.getWidth()) * this.f728c.density), Math.round(((float) image.getHeight()) * this.f728c.density));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.f728c.density), Math.round(this.f728c.density * 2.0f), Math.round(this.f728c.density * 2.0f), Math.round(this.f728c.density * 2.0f));
        imageView.setLayoutParams(layoutParams);
        NativeAd.downloadAndDisplayImage(image, imageView);
        return imageView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m696a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f730e.getTextSize());
        int round = Math.round(paint.measureText("AdChoices") + (4.0f * this.f728c.density));
        final int width = getWidth();
        final int i = round + width;
        this.f729d = true;
        C04072 r2 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                int i = (int) (((float) width) + (((float) (i - width)) * f));
                AdChoicesView.this.getLayoutParams().width = i;
                AdChoicesView.this.requestLayout();
                AdChoicesView.this.f730e.getLayoutParams().width = i - width;
                AdChoicesView.this.f730e.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        r2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (AdChoicesView.this.f729d) {
                            boolean unused = AdChoicesView.this.f729d = false;
                            C04101 r0 = new Animation() {
                                /* access modifiers changed from: protected */
                                public void applyTransformation(float f, Transformation transformation) {
                                    int i = (int) (((float) i) + (((float) (width - i)) * f));
                                    AdChoicesView.this.getLayoutParams().width = i;
                                    AdChoicesView.this.requestLayout();
                                    AdChoicesView.this.f730e.getLayoutParams().width = i - width;
                                    AdChoicesView.this.f730e.requestLayout();
                                }

                                public boolean willChangeBounds() {
                                    return true;
                                }
                            };
                            r0.setDuration(300);
                            r0.setFillAfter(true);
                            AdChoicesView.this.startAnimation(r0);
                        }
                    }
                }, 3000);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        r2.setDuration(300);
        r2.setFillAfter(true);
        startAnimation(r2);
    }
}
