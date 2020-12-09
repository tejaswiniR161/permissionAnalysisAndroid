package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhy;

public interface zzx extends IInterface {

    public static abstract class zza extends Binder implements zzx {

        /* renamed from: com.google.android.gms.ads.internal.client.zzx$zza$zza  reason: collision with other inner class name */
        private static class C1254zza implements zzx {
            private IBinder zzajf;

            C1254zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            public IBinder asBinder() {
                return this.zzajf;
            }

            public zzs createAdLoaderBuilder(zzd zzd, String str, zzgq zzgq, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    if (zzgq != null) {
                        iBinder = zzgq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzajf.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzs.zza.zzo(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzhp createAdOverlay(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzhp.zza.zzat(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzu createBannerAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzgq != null) {
                        iBinder = zzgq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzu.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzhy createInAppPurchaseManager(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzhy.zza.zzay(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzu createInterstitialAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzgq != null) {
                        iBinder = zzgq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzu.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzdz createNativeAdViewDelegate(zzd zzd, zzd zzd2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (zzd2 != null) {
                        iBinder = zzd2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzajf.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzdz.zza.zzac(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzb createRewardedVideoAd(zzd zzd, zzgq zzgq, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (zzgq != null) {
                        iBinder = zzgq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzajf.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzb.zza.zzbh(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzu createSearchAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzajf.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzu.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzz getMobileAdsSettingsManager(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzajf.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzz.zza.zzu(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzz getMobileAdsSettingsManagerWithClientJarVersion(zzd zzd, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzajf.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzz.zza.zzu(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static zzx asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzx)) ? new C1254zza(iBinder) : (zzx) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzu createBannerAdManager = createBannerAdManager(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzgq.zza.zzam(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzu createInterstitialAdManager = createInterstitialAdManager(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzgq.zza.zzam(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createInterstitialAdManager != null) {
                        iBinder = createInterstitialAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzs createAdLoaderBuilder = createAdLoaderBuilder(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readString(), zzgq.zza.zzam(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAdLoaderBuilder != null) {
                        iBinder = createAdLoaderBuilder.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzz mobileAdsSettingsManager = getMobileAdsSettingsManager(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzdz createNativeAdViewDelegate = createNativeAdViewDelegate(zzd.zza.zzfe(parcel.readStrongBinder()), zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createNativeAdViewDelegate != null) {
                        iBinder = createNativeAdViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzb createRewardedVideoAd = createRewardedVideoAd(zzd.zza.zzfe(parcel.readStrongBinder()), zzgq.zza.zzam(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createRewardedVideoAd != null) {
                        iBinder = createRewardedVideoAd.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzhy createInAppPurchaseManager = createInAppPurchaseManager(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createInAppPurchaseManager != null) {
                        iBinder = createInAppPurchaseManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzhp createAdOverlay = createAdOverlay(zzd.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createAdOverlay != null) {
                        iBinder = createAdOverlay.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzz mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManagerWithClientJarVersion != null) {
                        iBinder = mobileAdsSettingsManagerWithClientJarVersion.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzu createSearchAdManager = createSearchAdManager(zzd.zza.zzfe(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createSearchAdManager != null) {
                        iBinder = createSearchAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzs createAdLoaderBuilder(zzd zzd, String str, zzgq zzgq, int i) throws RemoteException;

    zzhp createAdOverlay(zzd zzd) throws RemoteException;

    zzu createBannerAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException;

    zzhy createInAppPurchaseManager(zzd zzd) throws RemoteException;

    zzu createInterstitialAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException;

    zzdz createNativeAdViewDelegate(zzd zzd, zzd zzd2) throws RemoteException;

    zzb createRewardedVideoAd(zzd zzd, zzgq zzgq, int i) throws RemoteException;

    zzu createSearchAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, int i) throws RemoteException;

    zzz getMobileAdsSettingsManager(zzd zzd) throws RemoteException;

    zzz getMobileAdsSettingsManagerWithClientJarVersion(zzd zzd, int i) throws RemoteException;
}
