package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.zzl;

public interface zzk extends IInterface {

    public static abstract class zza extends Binder implements zzk {

        /* renamed from: com.google.android.gms.ads.internal.request.zzk$zza$zza  reason: collision with other inner class name */
        private static class C1259zza implements zzk {
            private IBinder zzajf;

            C1259zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public void zza(AdRequestInfoParcel adRequestInfoParcel, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (AdResponseParcel) AdResponseParcel.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static zzk zzbe(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzk)) ? new C1259zza(iBinder) : (zzk) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            AdRequestInfoParcel adRequestInfoParcel = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = (AdRequestInfoParcel) AdRequestInfoParcel.CREATOR.createFromParcel(parcel);
                    }
                    AdResponseParcel zzd = zzd(adRequestInfoParcel);
                    parcel2.writeNoException();
                    if (zzd != null) {
                        parcel2.writeInt(1);
                        zzd.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = (AdRequestInfoParcel) AdRequestInfoParcel.CREATOR.createFromParcel(parcel);
                    }
                    zza(adRequestInfoParcel, zzl.zza.zzbf(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(AdRequestInfoParcel adRequestInfoParcel, zzl zzl) throws RemoteException;

    AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException;
}
