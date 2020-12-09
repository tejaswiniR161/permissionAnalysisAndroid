package com.google.firebase.crash.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.firebase.crash.internal.zze$zza$zza  reason: collision with other inner class name */
        private static class C1334zza implements zze {
            private IBinder zzajf;

            C1334zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzap(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaq(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzmj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C1334zza(iBinder) : (zze) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    zzap(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    onDestroy();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    zzaq(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.firebase.crash.internal.IFirebaseCrashReceiverService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDestroy() throws RemoteException;

    void zzap(zzd zzd) throws RemoteException;

    void zzaq(zzd zzd) throws RemoteException;
}
