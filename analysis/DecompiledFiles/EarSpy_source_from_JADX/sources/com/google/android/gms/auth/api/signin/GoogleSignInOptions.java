package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();

    /* renamed from: hc */
    private static Comparator<Scope> f1429hc = new Comparator<Scope>() {
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaqg().compareTo(scope2.zzaqg());
        }
    };

    /* renamed from: hd */
    public static final Scope f1430hd = new Scope(Scopes.PROFILE);

    /* renamed from: he */
    public static final Scope f1431he = new Scope("email");

    /* renamed from: hf */
    public static final Scope f1432hf = new Scope("openid");
    /* access modifiers changed from: private */

    /* renamed from: ec */
    public Account f1433ec;
    /* access modifiers changed from: private */

    /* renamed from: hg */
    public final ArrayList<Scope> f1434hg;
    /* access modifiers changed from: private */

    /* renamed from: hh */
    public boolean f1435hh;
    /* access modifiers changed from: private */

    /* renamed from: hi */
    public final boolean f1436hi;
    /* access modifiers changed from: private */

    /* renamed from: hj */
    public final boolean f1437hj;
    /* access modifiers changed from: private */

    /* renamed from: hk */
    public String f1438hk;
    /* access modifiers changed from: private */

    /* renamed from: hl */
    public String f1439hl;
    final int versionCode;

    public static final class Builder {

        /* renamed from: ec */
        private Account f1440ec;

        /* renamed from: hh */
        private boolean f1441hh;

        /* renamed from: hi */
        private boolean f1442hi;

        /* renamed from: hj */
        private boolean f1443hj;

        /* renamed from: hk */
        private String f1444hk;

        /* renamed from: hl */
        private String f1445hl;

        /* renamed from: hm */
        private Set<Scope> f1446hm = new HashSet();

        public Builder() {
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            zzac.zzy(googleSignInOptions);
            this.f1446hm = new HashSet(googleSignInOptions.f1434hg);
            this.f1442hi = googleSignInOptions.f1436hi;
            this.f1443hj = googleSignInOptions.f1437hj;
            this.f1441hh = googleSignInOptions.f1435hh;
            this.f1444hk = googleSignInOptions.f1438hk;
            this.f1440ec = googleSignInOptions.f1433ec;
            this.f1445hl = googleSignInOptions.f1439hl;
        }

        private String zzfz(String str) {
            zzac.zzhz(str);
            zzac.zzb(this.f1444hk == null || this.f1444hk.equals(str), (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f1441hh && (this.f1440ec == null || !this.f1446hm.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions((Set) this.f1446hm, this.f1440ec, this.f1441hh, this.f1442hi, this.f1443hj, this.f1444hk, this.f1445hl);
        }

        public Builder requestEmail() {
            this.f1446hm.add(GoogleSignInOptions.f1431he);
            return this;
        }

        public Builder requestId() {
            this.f1446hm.add(GoogleSignInOptions.f1432hf);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f1441hh = true;
            this.f1444hk = zzfz(str);
            return this;
        }

        public Builder requestProfile() {
            this.f1446hm.add(GoogleSignInOptions.f1430hd);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f1446hm.add(scope);
            this.f1446hm.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f1442hi = true;
            this.f1444hk = zzfz(str);
            this.f1443hj = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f1440ec = new Account(zzac.zzhz(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f1445hl = zzac.zzhz(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.versionCode = i;
        this.f1434hg = arrayList;
        this.f1433ec = account;
        this.f1435hh = z;
        this.f1436hi = z2;
        this.f1437hj = z3;
        this.f1438hk = str;
        this.f1439hl = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str, str2);
    }

    private JSONObject zzahi() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f1434hg, f1429hc);
            Iterator<Scope> it = this.f1434hg.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzaqg());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f1433ec != null) {
                jSONObject.put("accountName", this.f1433ec.name);
            }
            jSONObject.put("idTokenRequested", this.f1435hh);
            jSONObject.put("forceCodeForRefreshToken", this.f1437hj);
            jSONObject.put("serverAuthRequested", this.f1436hi);
            if (!TextUtils.isEmpty(this.f1438hk)) {
                jSONObject.put("serverClientId", this.f1438hk);
            }
            if (!TextUtils.isEmpty(this.f1439hl)) {
                jSONObject.put("hostedDomain", this.f1439hl);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInOptions zzfy(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", (String) null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", (String) null), jSONObject.optString("hostedDomain", (String) null));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f1434hg.size() != googleSignInOptions.zzahj().size() || !this.f1434hg.containsAll(googleSignInOptions.zzahj())) {
                return false;
            }
            if (this.f1433ec == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.f1433ec.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f1438hk)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzahn())) {
                    return false;
                }
            } else if (!this.f1438hk.equals(googleSignInOptions.zzahn())) {
                return false;
            }
            return this.f1437hj == googleSignInOptions.zzahm() && this.f1435hh == googleSignInOptions.zzahk() && this.f1436hi == googleSignInOptions.zzahl();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f1433ec;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.f1434hg.toArray(new Scope[this.f1434hg.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.f1434hg.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzaqg());
        }
        Collections.sort(arrayList);
        return new zze().zzq(arrayList).zzq(this.f1433ec).zzq(this.f1438hk).zzbd(this.f1437hj).zzbd(this.f1435hh).zzbd(this.f1436hi).zzahv();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzahg() {
        return zzahi().toString();
    }

    public ArrayList<Scope> zzahj() {
        return new ArrayList<>(this.f1434hg);
    }

    public boolean zzahk() {
        return this.f1435hh;
    }

    public boolean zzahl() {
        return this.f1436hi;
    }

    public boolean zzahm() {
        return this.f1437hj;
    }

    public String zzahn() {
        return this.f1438hk;
    }

    public String zzaho() {
        return this.f1439hl;
    }
}
