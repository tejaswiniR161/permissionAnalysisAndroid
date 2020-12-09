package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0553r;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.f */
public class C0474f {

    /* renamed from: a */
    public static final String f1096a = C0474f.class.getSimpleName();

    /* renamed from: b */
    private final String f1097b;

    /* renamed from: c */
    private final boolean f1098c;

    /* renamed from: d */
    private final C0478c f1099d;

    /* renamed from: com.facebook.ads.internal.f$a */
    private static final class C0476a implements IInterface {

        /* renamed from: a */
        private IBinder f1100a;

        C0476a(IBinder iBinder) {
            this.f1100a = iBinder;
        }

        /* renamed from: a */
        public String mo6004a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f1100a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f1100a;
        }

        /* renamed from: b */
        public boolean mo6006b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f1100a.transact(2, obtain, obtain2, 0);
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
    }

    /* renamed from: com.facebook.ads.internal.f$b */
    private static final class C0477b implements ServiceConnection {

        /* renamed from: a */
        private AtomicBoolean f1101a;

        /* renamed from: b */
        private final BlockingQueue<IBinder> f1102b;

        private C0477b() {
            this.f1101a = new AtomicBoolean(false);
            this.f1102b = new LinkedBlockingDeque();
        }

        /* renamed from: a */
        public IBinder mo6007a() {
            if (!this.f1101a.compareAndSet(true, true)) {
                return this.f1102b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1102b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.facebook.ads.internal.f$c */
    public enum C0478c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    private C0474f(String str, boolean z, C0478c cVar) {
        this.f1097b = str;
        this.f1098c = z;
        this.f1099d = cVar;
    }

    /* renamed from: a */
    private static C0474f m1007a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new C0474f(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), C0478c.DIRECT);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public static C0474f m1008a(Context context, C0537g.C0540a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (aVar != null && !C0553r.m1245a(aVar.f1259b)) {
            return new C0474f(aVar.f1259b, aVar.f1260c, C0478c.FB4A);
        } else {
            C0474f a = m1007a(context);
            if (a == null || C0553r.m1245a(a.mo6001a())) {
                a = m1009b(context);
            }
            return (a == null || C0553r.m1245a(a.mo6001a())) ? m1010c(context) : a;
        }
    }

    /* renamed from: b */
    private static C0474f m1009b(Context context) {
        Method a = C0537g.m1204a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (a == null) {
            return null;
        }
        Object a2 = C0537g.m1199a((Object) null, a, context);
        if (a2 == null || ((Integer) a2).intValue() != 0) {
            return null;
        }
        Method a3 = C0537g.m1204a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
        if (a3 == null) {
            return null;
        }
        Object a4 = C0537g.m1199a((Object) null, a3, context);
        if (a4 == null) {
            return null;
        }
        Method a5 = C0537g.m1203a(a4.getClass(), "getId", (Class<?>[]) new Class[0]);
        Method a6 = C0537g.m1203a(a4.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
        if (a5 == null || a6 == null) {
            return null;
        }
        return new C0474f((String) C0537g.m1199a(a4, a5, new Object[0]), ((Boolean) C0537g.m1199a(a4, a6, new Object[0])).booleanValue(), C0478c.REFLECTION);
    }

    /* renamed from: c */
    private static C0474f m1010c(Context context) {
        C0477b bVar = new C0477b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                C0476a aVar = new C0476a(bVar.mo6007a());
                return new C0474f(aVar.mo6004a(), aVar.mo6006b(), C0478c.SERVICE);
            } catch (Exception e) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo6001a() {
        return this.f1097b;
    }

    /* renamed from: b */
    public boolean mo6002b() {
        return this.f1098c;
    }

    /* renamed from: c */
    public C0478c mo6003c() {
        return this.f1099d;
    }
}
