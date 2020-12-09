package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0609R;

public class zzaj {

    /* renamed from: Dc */
    private final Resources f1661Dc;

    /* renamed from: Dd */
    private final String f1662Dd = this.f1661Dc.getResourcePackageName(C0609R.string.common_google_play_services_unknown_issue);

    public zzaj(Context context) {
        zzac.zzy(context);
        this.f1661Dc = context.getResources();
    }

    public String getString(String str) {
        int identifier = this.f1661Dc.getIdentifier(str, "string", this.f1662Dd);
        if (identifier == 0) {
            return null;
        }
        return this.f1661Dc.getString(identifier);
    }
}
