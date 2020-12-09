package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;

public interface zzs extends IInterface {

    public static abstract class zza extends Binder implements zzs {

        /* renamed from: com.google.android.gms.ads.internal.client.zzs$zza$zza  reason: collision with other inner class name */
        private static class C1249zza implements zzs {
            private IBinder zzajf;

            C1249zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzeh zzeh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzeh != null ? zzeh.asBinder() : null);
                    this.zzajf.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzei zzei) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzei != null ? zzei.asBinder() : null);
                    this.zzajf.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzek zzek, zzej zzej) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzek != null ? zzek.asBinder() : null);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzajf.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzq zzq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzy zzy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzy != null ? zzy.asBinder() : null);
                    this.zzajf.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzr zzey() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzr.zza.zzn(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzs zzo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new C1249zza(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v25, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0052;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0088;
                    case 7: goto L_0x00a4;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzr r2 = r4.zzey()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzq r0 = com.google.android.gms.ads.internal.client.zzq.zza.zzm(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzq) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzeh r0 = com.google.android.gms.internal.zzeh.zza.zzah(r0)
                r4.zza((com.google.android.gms.internal.zzeh) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzei r0 = com.google.android.gms.internal.zzei.zza.zzai(r0)
                r4.zza((com.google.android.gms.internal.zzei) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzek r2 = com.google.android.gms.internal.zzek.zza.zzak(r2)
                android.os.IBinder r3 = r6.readStrongBinder()
                com.google.android.gms.internal.zzej r3 = com.google.android.gms.internal.zzej.zza.zzaj(r3)
                r4.zza(r0, r2, r3)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0088:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x009b
                com.google.android.gms.ads.internal.formats.zzk r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = (com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0
            L_0x009b:
                r4.zza((com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00a4:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzy r0 = com.google.android.gms.ads.internal.client.zzy.zza.zzt(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzy) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzs.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException;

    void zza(zzeh zzeh) throws RemoteException;

    void zza(zzei zzei) throws RemoteException;

    void zza(String str, zzek zzek, zzej zzej) throws RemoteException;

    void zzb(zzq zzq) throws RemoteException;

    void zzb(zzy zzy) throws RemoteException;

    zzr zzey() throws RemoteException;
}
