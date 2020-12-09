package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zziy;
import java.util.List;

@zziy
class zzb extends RelativeLayout {
    private static final float[] zzbjl = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout zzbjm;
    @Nullable
    private AnimationDrawable zzbjn;

    public zzb(Context context, zza zza) {
        super(context);
        zzac.zzy(zza);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (zza.zzll()) {
            case 0:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzbjl, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zza.getBackgroundColor());
        this.zzbjm = new RelativeLayout(context);
        this.zzbjm.setLayoutParams(layoutParams);
        zzu.zzgb().zza((View) this.zzbjm, (Drawable) shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zza.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zza.getText());
            textView.setTextColor(zza.getTextColor());
            textView.setTextSize((float) zza.getTextSize());
            textView.setPadding(zzm.zzjr().zzb(context, 4), 0, zzm.zzjr().zzb(context, 4), 0);
            this.zzbjm.addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> zzlj = zza.zzlj();
        if (zzlj.size() > 1) {
            this.zzbjn = new AnimationDrawable();
            for (Drawable addFrame : zzlj) {
                this.zzbjn.addFrame(addFrame, zza.zzlk());
            }
            zzu.zzgb().zza((View) imageView, (Drawable) this.zzbjn);
        } else if (zzlj.size() == 1) {
            imageView.setImageDrawable(zzlj.get(0));
        }
        this.zzbjm.addView(imageView);
        addView(this.zzbjm);
    }

    public void onAttachedToWindow() {
        if (this.zzbjn != null) {
            this.zzbjn.start();
        }
        super.onAttachedToWindow();
    }

    public ViewGroup zzlm() {
        return this.zzbjm;
    }
}
