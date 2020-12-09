package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zze;

public class zza extends zzr.zza {

    /* renamed from: AV */
    int f1655AV;

    public static Account zza(zzr zzr) {
        Account account = null;
        if (zzr != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzr.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        zza zza = (zza) obj;
        return account.equals(account);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f1655AV) {
            if (zze.zzf((Context) null, callingUid)) {
                this.f1655AV = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }
}
