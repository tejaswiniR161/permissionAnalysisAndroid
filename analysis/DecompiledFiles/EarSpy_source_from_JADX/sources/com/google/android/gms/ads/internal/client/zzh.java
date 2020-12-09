package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zziy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zziy
public class zzh {
    public static final zzh zzaxh = new zzh();

    protected zzh() {
    }

    public static zzh zzjb() {
        return zzaxh;
    }

    public AdRequestParcel zza(Context context, zzad zzad) {
        Date birthday = zzad.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzad.getContentUrl();
        int gender = zzad.getGender();
        Set<String> keywords = zzad.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzad.isTestDevice(context);
        int zzkd = zzad.zzkd();
        Location location = zzad.getLocation();
        Bundle networkExtrasBundle = zzad.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzad.getManualImpressionsEnabled();
        String publisherProvidedId = zzad.getPublisherProvidedId();
        SearchAdRequest zzka = zzad.zzka();
        SearchAdRequestParcel searchAdRequestParcel = zzka != null ? new SearchAdRequestParcel(zzka) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = zzm.zzjr().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzkd, manualImpressionsEnabled, publisherProvidedId, searchAdRequestParcel, location, contentUrl, zzad.zzkc(), zzad.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzad.zzke())), zzad.zzjz(), str, zzad.isDesignedForFamilies());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzad zzad, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, zzad), str);
    }
}
