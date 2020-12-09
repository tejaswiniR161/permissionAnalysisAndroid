package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;

public interface zzu extends IInterface {

    public static abstract class zza extends Binder implements zzu {

        /* renamed from: com.google.android.gms.ads.internal.client.zzu$zza$zza  reason: collision with other inner class name */
        private static class C1251zza implements zzu {
            private IBinder zzajf;

            C1251zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setManualImpressionsEnabled(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzajf.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str);
                    this.zzajf.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(VideoOptionsParcel videoOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (videoOptionsParcel != null) {
                        obtain.writeInt(1);
                        videoOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzp zzp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzp != null ? zzp.asBinder() : null);
                    this.zzajf.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzq zzq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    this.zzajf.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzw zzw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzw != null ? zzw.asBinder() : null);
                    this.zzajf.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzy zzy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzy != null ? zzy.asBinder() : null);
                    this.zzajf.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzdu zzdu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzdu != null ? zzdu.asBinder() : null);
                    this.zzajf.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzhx zzhx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzhx != null ? zzhx.asBinder() : null);
                    this.zzajf.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzib zzib, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzib != null ? zzib.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.dynamic.zzd zzds() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzfe(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdSizeParcel zzdt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzdv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzab zzdw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzajf.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzab.zza.zzw(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static zzu zzq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzu)) ? new C1251zza(iBinder) : (zzu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.ads.internal.client.VideoOptionsParcel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: com.google.android.gms.ads.internal.client.AdRequestParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.ads.internal.client.AdSizeParcel] */
        /* JADX WARNING: type inference failed for: r0v61, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: type inference failed for: r0v65 */
        /* JADX WARNING: type inference failed for: r0v66 */
        /* JADX WARNING: type inference failed for: r0v67 */
        /* JADX WARNING: type inference failed for: r0v68 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0048;
                    case 5: goto L_0x0069;
                    case 6: goto L_0x0075;
                    case 7: goto L_0x0081;
                    case 8: goto L_0x0096;
                    case 9: goto L_0x00ab;
                    case 10: goto L_0x00b8;
                    case 11: goto L_0x00c5;
                    case 12: goto L_0x00d2;
                    case 13: goto L_0x00ed;
                    case 14: goto L_0x0108;
                    case 15: goto L_0x011d;
                    case 18: goto L_0x0136;
                    case 19: goto L_0x0147;
                    case 20: goto L_0x015c;
                    case 21: goto L_0x0171;
                    case 22: goto L_0x0186;
                    case 23: goto L_0x019a;
                    case 24: goto L_0x01ae;
                    case 25: goto L_0x01c3;
                    case 26: goto L_0x01d4;
                    case 29: goto L_0x01eb;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r5, r6, r7, r8)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r7.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r4.zzds()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                goto L_0x000a
            L_0x0027:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.destroy()
                r7.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                boolean r0 = r4.isReady()
                r7.writeNoException()
                if (r0 == 0) goto L_0x0046
                r0 = r1
            L_0x0042:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0046:
                r0 = r2
                goto L_0x0042
            L_0x0048:
                java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r3)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x005b
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
            L_0x005b:
                boolean r0 = r4.zzb(r0)
                r7.writeNoException()
                if (r0 == 0) goto L_0x0065
                r2 = r1
            L_0x0065:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x0069:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.pause()
                r7.writeNoException()
                goto L_0x000a
            L_0x0075:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.resume()
                r7.writeNoException()
                goto L_0x000a
            L_0x0081:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzq r0 = com.google.android.gms.ads.internal.client.zzq.zza.zzm(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzq) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0096:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzw r0 = com.google.android.gms.ads.internal.client.zzw.zza.zzs(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzw) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x00ab:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.showInterstitial()
                r7.writeNoException()
                goto L_0x000a
            L_0x00b8:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.stopLoading()
                r7.writeNoException()
                goto L_0x000a
            L_0x00c5:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.zzdv()
                r7.writeNoException()
                goto L_0x000a
            L_0x00d2:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r4.zzdt()
                r7.writeNoException()
                if (r0 == 0) goto L_0x00e8
                r7.writeInt(r1)
                r0.writeToParcel(r7, r1)
                goto L_0x000a
            L_0x00e8:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x00ed:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0100
                com.google.android.gms.ads.internal.client.zzi r0 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = (com.google.android.gms.ads.internal.client.AdSizeParcel) r0
            L_0x0100:
                r4.zza((com.google.android.gms.ads.internal.client.AdSizeParcel) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0108:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzhx r0 = com.google.android.gms.internal.zzhx.zza.zzax(r0)
                r4.zza((com.google.android.gms.internal.zzhx) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x011d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzib r0 = com.google.android.gms.internal.zzib.zza.zzbb(r0)
                java.lang.String r2 = r6.readString()
                r4.zza(r0, r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x0136:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                java.lang.String r0 = r4.getMediationAdapterClassName()
                r7.writeNoException()
                r7.writeString(r0)
                goto L_0x000a
            L_0x0147:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzdu r0 = com.google.android.gms.internal.zzdu.zza.zzaa(r0)
                r4.zza((com.google.android.gms.internal.zzdu) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x015c:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzp r0 = com.google.android.gms.ads.internal.client.zzp.zza.zzl(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzp) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0171:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzy r0 = com.google.android.gms.ads.internal.client.zzy.zza.zzt(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzy) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0186:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0192
                r2 = r1
            L_0x0192:
                r4.setManualImpressionsEnabled(r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x019a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                boolean r0 = r4.isLoading()
                r7.writeNoException()
                if (r0 == 0) goto L_0x01a9
                r2 = r1
            L_0x01a9:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x01ae:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.reward.client.zzd r0 = com.google.android.gms.ads.internal.reward.client.zzd.zza.zzbj(r0)
                r4.zza((com.google.android.gms.ads.internal.reward.client.zzd) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x01c3:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.setUserId(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x01d4:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzab r2 = r4.zzdw()
                r7.writeNoException()
                if (r2 == 0) goto L_0x01e6
                android.os.IBinder r0 = r2.asBinder()
            L_0x01e6:
                r7.writeStrongBinder(r0)
                goto L_0x000a
            L_0x01eb:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x01fe
                com.google.android.gms.ads.internal.client.zzaq r0 = com.google.android.gms.ads.internal.client.VideoOptionsParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.VideoOptionsParcel r0 = (com.google.android.gms.ads.internal.client.VideoOptionsParcel) r0
            L_0x01fe:
                r4.zza((com.google.android.gms.ads.internal.client.VideoOptionsParcel) r0)
                r7.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzu.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void destroy() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(AdSizeParcel adSizeParcel) throws RemoteException;

    void zza(VideoOptionsParcel videoOptionsParcel) throws RemoteException;

    void zza(zzp zzp) throws RemoteException;

    void zza(zzq zzq) throws RemoteException;

    void zza(zzw zzw) throws RemoteException;

    void zza(zzy zzy) throws RemoteException;

    void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) throws RemoteException;

    void zza(zzdu zzdu) throws RemoteException;

    void zza(zzhx zzhx) throws RemoteException;

    void zza(zzib zzib, String str) throws RemoteException;

    boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException;

    com.google.android.gms.dynamic.zzd zzds() throws RemoteException;

    AdSizeParcel zzdt() throws RemoteException;

    void zzdv() throws RemoteException;

    zzab zzdw() throws RemoteException;
}
