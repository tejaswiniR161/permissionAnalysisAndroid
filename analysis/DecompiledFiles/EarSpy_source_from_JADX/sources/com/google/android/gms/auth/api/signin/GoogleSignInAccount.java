package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zza();

    /* renamed from: gT */
    public static zze f1417gT = zzh.zzaxj();

    /* renamed from: hc */
    private static Comparator<Scope> f1418hc = new Comparator<Scope>() {
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaqg().compareTo(scope2.zzaqg());
        }
    };

    /* renamed from: fK */
    List<Scope> f1419fK;

    /* renamed from: gU */
    private String f1420gU;

    /* renamed from: gV */
    private String f1421gV;

    /* renamed from: gW */
    private Uri f1422gW;

    /* renamed from: gX */
    private String f1423gX;

    /* renamed from: gY */
    private long f1424gY;

    /* renamed from: gZ */
    private String f1425gZ;

    /* renamed from: gs */
    private String f1426gs;

    /* renamed from: ha */
    private String f1427ha;

    /* renamed from: hb */
    private String f1428hb;
    final int versionCode;
    private String zzbks;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i;
        this.zzbks = str;
        this.f1426gs = str2;
        this.f1420gU = str3;
        this.f1421gV = str4;
        this.f1422gW = uri;
        this.f1423gX = str5;
        this.f1424gY = j;
        this.f1425gZ = str6;
        this.f1419fK = list;
        this.f1427ha = str7;
        this.f1428hb = str8;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f1417gT.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l.longValue(), zzac.zzhz(str7), new ArrayList((Collection) zzac.zzy(set)), str5, str6);
    }

    private JSONObject zzahi() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f1424gY);
            jSONObject.put("obfuscatedIdentifier", zzahf());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f1419fK, f1418hc);
            for (Scope zzaqg : this.f1419fK) {
                jSONArray.put(zzaqg.zzaqg());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInAccount zzfw(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), jSONObject.optString("givenName", (String) null), jSONObject.optString("familyName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzfx(jSONObject.optString("serverAuthCode", (String) null));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).zzahg().equals(zzahg());
    }

    @Nullable
    public String getDisplayName() {
        return this.f1421gV;
    }

    @Nullable
    public String getEmail() {
        return this.f1420gU;
    }

    @Nullable
    public String getFamilyName() {
        return this.f1428hb;
    }

    @Nullable
    public String getGivenName() {
        return this.f1427ha;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f1419fK);
    }

    @Nullable
    public String getId() {
        return this.zzbks;
    }

    @Nullable
    public String getIdToken() {
        return this.f1426gs;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f1422gW;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f1423gX;
    }

    public int hashCode() {
        return zzahg().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zza() {
        return f1417gT.currentTimeMillis() / 1000 >= this.f1424gY - 300;
    }

    public long zzahe() {
        return this.f1424gY;
    }

    @NonNull
    public String zzahf() {
        return this.f1425gZ;
    }

    public String zzahg() {
        return zzahi().toString();
    }

    public String zzahh() {
        JSONObject zzahi = zzahi();
        zzahi.remove("serverAuthCode");
        return zzahi.toString();
    }

    public GoogleSignInAccount zzfx(String str) {
        this.f1423gX = str;
        return this;
    }
}
