package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0609R;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zziy
public class zzhj extends zzhm {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzbiq;

    public zzhj(zzlt zzlt, Map<String, String> map) {
        super(zzlt, "storePicture");
        this.zzbiq = map;
        this.mContext = zzlt.zzvn();
    }

    public void execute() {
        if (this.mContext == null) {
            zzbx("Activity context is not available");
        } else if (!zzu.zzfz().zzag(this.mContext).zzkl()) {
            zzbx("Feature is not supported by the device.");
        } else {
            final String str = this.zzbiq.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzbx("Image url cannot be empty.");
            } else if (!URLUtil.isValidUrl(str)) {
                String valueOf = String.valueOf(str);
                zzbx(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            } else {
                final String zzbw = zzbw(str);
                if (!zzu.zzfz().zzcx(zzbw)) {
                    String valueOf2 = String.valueOf(zzbw);
                    zzbx(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                    return;
                }
                Resources resources = zzu.zzgd().getResources();
                AlertDialog.Builder zzaf = zzu.zzfz().zzaf(this.mContext);
                zzaf.setTitle(resources != null ? resources.getString(C0609R.string.store_picture_title) : "Save image");
                zzaf.setMessage(resources != null ? resources.getString(C0609R.string.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                zzaf.setPositiveButton(resources != null ? resources.getString(C0609R.string.accept) : "Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            ((DownloadManager) zzhj.this.mContext.getSystemService("download")).enqueue(zzhj.this.zzk(str, zzbw));
                        } catch (IllegalStateException e) {
                            zzhj.this.zzbx("Could not store picture.");
                        }
                    }
                });
                zzaf.setNegativeButton(resources != null ? resources.getString(C0609R.string.decline) : "Decline", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        zzhj.this.zzbx("User canceled the download.");
                    }
                });
                zzaf.create().show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String zzbw(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* access modifiers changed from: package-private */
    public DownloadManager.Request zzk(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzu.zzgb().zza(request);
        return request;
    }
}
