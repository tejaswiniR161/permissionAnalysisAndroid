package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.iid.zzb;

public class MessengerCompat implements Parcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator<MessengerCompat>() {
        /* renamed from: zznc */
        public MessengerCompat createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new MessengerCompat(readStrongBinder);
            }
            return null;
        }

        /* renamed from: zztu */
        public MessengerCompat[] newArray(int i) {
            return new MessengerCompat[i];
        }
    };
    Messenger agg;
    zzb agh;

    private final class zza extends zzb.zza {
        Handler handler;

        zza(Handler handler2) {
            this.handler = handler2;
        }

        public void send(Message message) throws RemoteException {
            message.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.agg = new Messenger(handler);
        } else {
            this.agh = new zza(handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.agg = new Messenger(iBinder);
        } else {
            this.agh = zzb.zza.zzgw(iBinder);
        }
    }

    public static int zzc(Message message) {
        return Build.VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    @TargetApi(21)
    private static int zzd(Message message) {
        return message.sendingUid;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public IBinder getBinder() {
        return this.agg != null ? this.agg.getBinder() : this.agh.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.agg != null) {
            this.agg.send(message);
        } else {
            this.agh.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.agg != null) {
            parcel.writeStrongBinder(this.agg.getBinder());
        } else {
            parcel.writeStrongBinder(this.agh.asBinder());
        }
    }
}
