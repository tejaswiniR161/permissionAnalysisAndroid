package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.C0609R;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

@zziy
public class zzhg extends zzhm {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzbiq;
    private String zzbup;
    private long zzbuq;
    private long zzbur;
    private String zzbus;
    private String zzbut;

    public zzhg(zzlt zzlt, Map<String, String> map) {
        super(zzlt, "createCalendarEvent");
        this.zzbiq = map;
        this.mContext = zzlt.zzvn();
        zznr();
    }

    private String zzbu(String str) {
        return TextUtils.isEmpty(this.zzbiq.get(str)) ? "" : this.zzbiq.get(str);
    }

    private long zzbv(String str) {
        String str2 = this.zzbiq.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zznr() {
        this.zzbup = zzbu("description");
        this.zzbus = zzbu("summary");
        this.zzbuq = zzbv("start_ticks");
        this.zzbur = zzbv("end_ticks");
        this.zzbut = zzbu(FirebaseAnalytics.Param.LOCATION);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzbup);
        data.putExtra("eventLocation", this.zzbut);
        data.putExtra("description", this.zzbus);
        if (this.zzbuq > -1) {
            data.putExtra("beginTime", this.zzbuq);
        }
        if (this.zzbur > -1) {
            data.putExtra("endTime", this.zzbur);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzbx("Activity context is not available.");
        } else if (!zzu.zzfz().zzag(this.mContext).zzko()) {
            zzbx("This feature is not available on the device.");
        } else {
            AlertDialog.Builder zzaf = zzu.zzfz().zzaf(this.mContext);
            Resources resources = zzu.zzgd().getResources();
            zzaf.setTitle(resources != null ? resources.getString(C0609R.string.create_calendar_title) : "Create calendar event");
            zzaf.setMessage(resources != null ? resources.getString(C0609R.string.create_calendar_message) : "Allow Ad to create a calendar event?");
            zzaf.setPositiveButton(resources != null ? resources.getString(C0609R.string.accept) : "Accept", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    zzu.zzfz().zzb(zzhg.this.mContext, zzhg.this.createIntent());
                }
            });
            zzaf.setNegativeButton(resources != null ? resources.getString(C0609R.string.decline) : "Decline", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    zzhg.this.zzbx("Operation denied by user.");
                }
            });
            zzaf.create().show();
        }
    }
}
