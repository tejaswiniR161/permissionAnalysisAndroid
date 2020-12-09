package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzxa;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzh {

    /* renamed from: BX */
    private final Set<Scope> f1719BX;

    /* renamed from: BY */
    private final Map<Api<?>, zza> f1720BY;

    /* renamed from: BZ */
    private final zzxa f1721BZ;

    /* renamed from: Ca */
    private Integer f1722Ca;

    /* renamed from: ec */
    private final Account f1723ec;

    /* renamed from: fo */
    private final String f1724fo;

    /* renamed from: vF */
    private final Set<Scope> f1725vF;

    /* renamed from: vH */
    private final int f1726vH;

    /* renamed from: vI */
    private final View f1727vI;

    /* renamed from: vJ */
    private final String f1728vJ;

    public static final class zza {

        /* renamed from: Cb */
        public final boolean f1729Cb;

        /* renamed from: hm */
        public final Set<Scope> f1730hm;

        public zza(Set<Scope> set, boolean z) {
            zzac.zzy(set);
            this.f1730hm = Collections.unmodifiableSet(set);
            this.f1729Cb = z;
        }
    }

    public zzh(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzxa zzxa) {
        this.f1723ec = account;
        this.f1725vF = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f1720BY = map == null ? Collections.EMPTY_MAP : map;
        this.f1727vI = view;
        this.f1726vH = i;
        this.f1724fo = str;
        this.f1728vJ = str2;
        this.f1721BZ = zzxa;
        HashSet hashSet = new HashSet(this.f1725vF);
        for (zza zza2 : this.f1720BY.values()) {
            hashSet.addAll(zza2.f1730hm);
        }
        this.f1719BX = Collections.unmodifiableSet(hashSet);
    }

    public static zzh zzcd(Context context) {
        return new GoogleApiClient.Builder(context).zzaqd();
    }

    public Account getAccount() {
        return this.f1723ec;
    }

    @Deprecated
    public String getAccountName() {
        if (this.f1723ec != null) {
            return this.f1723ec.name;
        }
        return null;
    }

    public Account zzatv() {
        return this.f1723ec != null ? this.f1723ec : new Account("<<default account>>", "com.google");
    }

    public int zzauf() {
        return this.f1726vH;
    }

    public Set<Scope> zzaug() {
        return this.f1725vF;
    }

    public Set<Scope> zzauh() {
        return this.f1719BX;
    }

    public Map<Api<?>, zza> zzaui() {
        return this.f1720BY;
    }

    public String zzauj() {
        return this.f1724fo;
    }

    public String zzauk() {
        return this.f1728vJ;
    }

    public View zzaul() {
        return this.f1727vI;
    }

    public zzxa zzaum() {
        return this.f1721BZ;
    }

    public Integer zzaun() {
        return this.f1722Ca;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zza2 = this.f1720BY.get(api);
        if (zza2 == null || zza2.f1730hm.isEmpty()) {
            return this.f1725vF;
        }
        HashSet hashSet = new HashSet(this.f1725vF);
        hashSet.addAll(zza2.f1730hm);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.f1722Ca = num;
    }
}
