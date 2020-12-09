package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzhx;
import java.util.LinkedList;
import java.util.List;

@zziy
class zzfo {
    /* access modifiers changed from: private */
    public final List<zza> zzamv = new LinkedList();

    interface zza {
        void zzb(zzfp zzfp) throws RemoteException;
    }

    zzfo() {
    }

    /* access modifiers changed from: package-private */
    public void zza(final zzfp zzfp) {
        Handler handler = zzkr.zzcrf;
        for (final zza next : this.zzamv) {
            handler.post(new Runnable() {
                public void run() {
                    try {
                        next.zzb(zzfp);
                    } catch (RemoteException e) {
                        zzkn.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
        this.zzamv.clear();
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzl zzl) {
        zzl.zza((zzq) new zzq.zza() {
            public void onAdClosed() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzamy != null) {
                            zzfp.zzamy.onAdClosed();
                        }
                        zzu.zzgo().zzmm();
                    }
                });
            }

            public void onAdFailedToLoad(final int i) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzamy != null) {
                            zzfp.zzamy.onAdFailedToLoad(i);
                        }
                    }
                });
                zzkn.m1493v("Pooled interstitial failed to load.");
            }

            public void onAdLeftApplication() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzamy != null) {
                            zzfp.zzamy.onAdLeftApplication();
                        }
                    }
                });
            }

            public void onAdLoaded() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzamy != null) {
                            zzfp.zzamy.onAdLoaded();
                        }
                    }
                });
                zzkn.m1493v("Pooled interstitial loaded.");
            }

            public void onAdOpened() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzamy != null) {
                            zzfp.zzamy.onAdOpened();
                        }
                    }
                });
            }
        });
        zzl.zza((zzw) new zzw.zza() {
            public void onAppEvent(final String str, final String str2) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzboy != null) {
                            zzfp.zzboy.onAppEvent(str, str2);
                        }
                    }
                });
            }
        });
        zzl.zza((zzhx) new zzhx.zza() {
            public void zza(final zzhw zzhw) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzboz != null) {
                            zzfp.zzboz.zza(zzhw);
                        }
                    }
                });
            }
        });
        zzl.zza((zzdu) new zzdu.zza() {
            public void zza(final zzdt zzdt) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpa != null) {
                            zzfp.zzbpa.zza(zzdt);
                        }
                    }
                });
            }
        });
        zzl.zza((zzp) new zzp.zza() {
            public void onAdClicked() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpb != null) {
                            zzfp.zzbpb.onAdClicked();
                        }
                    }
                });
            }
        });
        zzl.zza((zzd) new zzd.zza() {
            public void onRewardedVideoAdClosed() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoAdClosed();
                        }
                    }
                });
            }

            public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoAdFailedToLoad(i);
                        }
                    }
                });
            }

            public void onRewardedVideoAdLeftApplication() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoAdLeftApplication();
                        }
                    }
                });
            }

            public void onRewardedVideoAdLoaded() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            public void onRewardedVideoAdOpened() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoAdOpened();
                        }
                    }
                });
            }

            public void onRewardedVideoStarted() throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.onRewardedVideoStarted();
                        }
                    }
                });
            }

            public void zza(final com.google.android.gms.ads.internal.reward.client.zza zza) throws RemoteException {
                zzfo.this.zzamv.add(new zza() {
                    public void zzb(zzfp zzfp) throws RemoteException {
                        if (zzfp.zzbpc != null) {
                            zzfp.zzbpc.zza(zza);
                        }
                    }
                });
            }
        });
    }
}
