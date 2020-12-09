package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.C0609R;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zziy
public class zzku {
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mState;
    /* access modifiers changed from: private */
    public String zzang;
    private final float zzbvv;
    private String zzcro;
    private float zzcrp;
    private float zzcrq;
    private float zzcrr;

    public zzku(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzbvv = context.getResources().getDisplayMetrics().density;
    }

    public zzku(Context context, String str) {
        this(context);
        this.zzcro = str;
    }

    static String zzda(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder sb = new StringBuilder();
        Map<String, String> zzg = zzu.zzfz().zzg(build);
        for (String next : zzg.keySet()) {
            sb.append(next).append(" = ").append(zzg.get(next)).append("\n\n");
        }
        String trim = sb.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void zzur() {
        if (!(this.mContext instanceof Activity)) {
            zzkn.zzde("Can not create dialog without Activity Context");
            return;
        }
        Resources resources = zzu.zzgd().getResources();
        new AlertDialog.Builder(this.mContext).setTitle(resources != null ? resources.getString(C0609R.string.debug_menu_title) : "Select a Debug Mode").setItems(new String[]{resources != null ? resources.getString(C0609R.string.debug_menu_ad_information) : "Ad Information", resources != null ? resources.getString(C0609R.string.debug_menu_creative_preview) : "Creative Preview", resources != null ? resources.getString(C0609R.string.debug_menu_troubleshooting) : "Troubleshooting"}, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        zzku.this.zzus();
                        return;
                    case 1:
                        zzkn.zzdd("Debug mode [Creative Preview] selected.");
                        zzkq.zza((Runnable) new Runnable() {
                            public void run() {
                                zzu.zzgh().zzi(zzku.this.mContext, zzku.this.zzang);
                            }
                        });
                        return;
                    case 2:
                        zzkn.zzdd("Debug mode [Troubleshooting] selected.");
                        zzkq.zza((Runnable) new Runnable() {
                            public void run() {
                                zzu.zzgh().zzj(zzku.this.mContext, zzku.this.zzang);
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        }).create().show();
    }

    /* access modifiers changed from: private */
    public void zzus() {
        if (!(this.mContext instanceof Activity)) {
            zzkn.zzde("Can not create dialog without Activity Context");
            return;
        }
        final String zzda = zzda(this.zzcro);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(zzda);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                zzu.zzfz().zzb(zzku.this.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", zzda), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void setAdUnitId(String str) {
        this.zzang = str;
    }

    public void showDialog() {
        if (zzdi.zzbhq.get().booleanValue()) {
            zzur();
        } else {
            zzus();
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzcrp = f;
            this.zzcrq = f2;
            this.zzcrr = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzcrq) {
                    this.zzcrq = f2;
                } else if (f2 < this.zzcrr) {
                    this.zzcrr = f2;
                }
                if (this.zzcrq - this.zzcrr > 30.0f * this.zzbvv) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzcrp >= 50.0f * this.zzbvv) {
                        this.zzcrp = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzcrp <= -50.0f * this.zzbvv) {
                    this.zzcrp = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzcrp) {
                        this.zzcrp = f;
                    }
                } else if (this.mState == 2 && f < this.zzcrp) {
                    this.zzcrp = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzcz(String str) {
        this.zzcro = str;
    }

    public void zzg(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
