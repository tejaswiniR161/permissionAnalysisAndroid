package com.google.firebase.crash.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.firebase.crash.internal.zzd$zza$zza  reason: collision with other inner class name */
        private static class C1333zza implements zzd {
            private IBinder zzajf;

            C1333zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public void log(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeString(str);
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(com.google.android.gms.dynamic.zzd zzd, FirebaseCrashOptions firebaseCrashOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (firebaseCrashOptions != null) {
                        obtain.writeInt(1);
                        firebaseCrashOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzan(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzao(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzsa(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    obtain.writeString(str);
                    this.zzajf.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzmi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1333zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    zza(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readInt() != 0 ? FirebaseCrashOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    log(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    zzan(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    zzao(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    zzsa(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.crash.internal.IFirebaseCrashApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void log(String str) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzd, FirebaseCrashOptions firebaseCrashOptions) throws RemoteException;

    void zzan(com.google.android.gms.dynamic.zzd zzd) throws RemoteException;

    void zzao(com.google.android.gms.dynamic.zzd zzd) throws RemoteException;

    void zzsa(String str) throws RemoteException;
}
