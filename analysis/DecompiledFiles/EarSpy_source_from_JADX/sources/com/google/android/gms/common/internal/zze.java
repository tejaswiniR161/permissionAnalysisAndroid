package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zze<T extends IInterface> {

    /* renamed from: Bs */
    public static final String[] f1663Bs = {"service_esmobile", "service_googleme"};

    /* renamed from: Ba */
    private int f1664Ba;

    /* renamed from: Bb */
    private long f1665Bb;

    /* renamed from: Bc */
    private long f1666Bc;

    /* renamed from: Bd */
    private int f1667Bd;

    /* renamed from: Be */
    private long f1668Be;

    /* renamed from: Bf */
    private final zzn f1669Bf;
    /* access modifiers changed from: private */

    /* renamed from: Bg */
    public final Object f1670Bg;
    /* access modifiers changed from: private */

    /* renamed from: Bh */
    public zzv f1671Bh;
    /* access modifiers changed from: private */

    /* renamed from: Bi */
    public zzf f1672Bi;

    /* renamed from: Bj */
    private T f1673Bj;
    /* access modifiers changed from: private */

    /* renamed from: Bk */
    public final ArrayList<C1272zze<?>> f1674Bk;

    /* renamed from: Bl */
    private zzh f1675Bl;

    /* renamed from: Bm */
    private int f1676Bm;
    /* access modifiers changed from: private */

    /* renamed from: Bn */
    public final zzb f1677Bn;
    /* access modifiers changed from: private */

    /* renamed from: Bo */
    public final zzc f1678Bo;

    /* renamed from: Bp */
    private final int f1679Bp;

    /* renamed from: Bq */
    private final String f1680Bq;

    /* renamed from: Br */
    protected AtomicInteger f1681Br;
    private final Context mContext;
    final Handler mHandler;

    /* renamed from: xn */
    private final com.google.android.gms.common.zzc f1682xn;
    private final Looper zzajn;
    private final Object zzakd;

    private abstract class zza extends C1272zze<Boolean> {

        /* renamed from: Bt */
        public final Bundle f1683Bt;
        public final int statusCode;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f1683Bt = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract boolean zzaua();

        /* access modifiers changed from: protected */
        public void zzaub() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzv(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zze.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzaua()) {
                        zze.this.zzb(1, null);
                        zzm(new ConnectionResult(8, (PendingIntent) null));
                        return;
                    }
                    return;
                case 10:
                    zze.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zze.this.zzb(1, null);
                    if (this.f1683Bt != null) {
                        pendingIntent = (PendingIntent) this.f1683Bt.getParcelable("pendingIntent");
                    }
                    zzm(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzm(ConnectionResult connectionResult);
    }

    public interface zzb {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    final class zzd extends Handler {
        public zzd(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            C1272zze zze = (C1272zze) message.obj;
            zze.zzaub();
            zze.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (zze.this.f1681Br.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !zze.this.isConnecting()) {
                zza(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                zze.this.f1672Bi.zzh(connectionResult);
                zze.this.onConnectionFailed(connectionResult);
            } else if (message.what == 4) {
                zze.this.zzb(4, null);
                if (zze.this.f1677Bn != null) {
                    zze.this.f1677Bn.onConnectionSuspended(message.arg2);
                }
                zze.this.onConnectionSuspended(message.arg2);
                boolean unused = zze.this.zza(4, 1, null);
            } else if (message.what == 2 && !zze.this.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((C1272zze) message.obj).zzauc();
            } else {
                Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zze$zze  reason: collision with other inner class name */
    protected abstract class C1272zze<TListener> {

        /* renamed from: Bv */
        private boolean f1687Bv = false;
        private TListener mListener;

        public C1272zze(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzaud();
            synchronized (zze.this.f1674Bk) {
                zze.this.f1674Bk.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzaub();

        public void zzauc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f1687Bv) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (tlistener != null) {
                try {
                    zzv(tlistener);
                } catch (RuntimeException e) {
                    zzaub();
                    throw e;
                }
            } else {
                zzaub();
            }
            synchronized (this) {
                this.f1687Bv = true;
            }
            unregister();
        }

        public void zzaud() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzv(TListener tlistener);
    }

    public interface zzf {
        void zzh(@NonNull ConnectionResult connectionResult);
    }

    public static final class zzg extends zzu.zza {

        /* renamed from: Bw */
        private zze f1688Bw;

        /* renamed from: Bx */
        private final int f1689Bx;

        public zzg(@NonNull zze zze, int i) {
            this.f1688Bw = zze;
            this.f1689Bx = i;
        }

        private void zzaue() {
            this.f1688Bw = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzac.zzb(this.f1688Bw, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1688Bw.zza(i, iBinder, bundle, this.f1689Bx);
            zzaue();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {

        /* renamed from: Bx */
        private final int f1691Bx;

        public zzh(int i) {
            this.f1691Bx = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzac.zzb(iBinder, (Object) "Expecting a valid IBinder");
            synchronized (zze.this.f1670Bg) {
                zzv unused = zze.this.f1671Bh = zzv.zza.zzdv(iBinder);
            }
            zze.this.zza(0, (Bundle) null, this.f1691Bx);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zze.this.f1670Bg) {
                zzv unused = zze.this.f1671Bh = null;
            }
            zze.this.mHandler.sendMessage(zze.this.mHandler.obtainMessage(4, this.f1691Bx, 1));
        }
    }

    protected class zzi implements zzf {
        public zzi() {
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zze.this.zza((zzr) null, zze.this.zzatz());
            } else if (zze.this.f1678Bo != null) {
                zze.this.f1678Bo.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzj extends zza {

        /* renamed from: By */
        public final IBinder f1694By;

        @BinderThread
        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f1694By = iBinder;
        }

        /* access modifiers changed from: protected */
        public boolean zzaua() {
            try {
                String interfaceDescriptor = this.f1694By.getInterfaceDescriptor();
                if (!zze.this.zziy().equals(interfaceDescriptor)) {
                    String valueOf = String.valueOf(zze.this.zziy());
                    Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                    return false;
                }
                IInterface zzh = zze.this.zzh(this.f1694By);
                if (zzh == null || !zze.this.zza(2, 3, zzh)) {
                    return false;
                }
                Bundle zzaoe = zze.this.zzaoe();
                if (zze.this.f1677Bn != null) {
                    zze.this.f1677Bn.onConnected(zzaoe);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void zzm(ConnectionResult connectionResult) {
            if (zze.this.f1678Bo != null) {
                zze.this.f1678Bo.onConnectionFailed(connectionResult);
            }
            zze.this.onConnectionFailed(connectionResult);
        }
    }

    protected final class zzk extends zza {
        @BinderThread
        public zzk(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public boolean zzaua() {
            zze.this.f1672Bi.zzh(ConnectionResult.f1494uJ);
            return true;
        }

        /* access modifiers changed from: protected */
        public void zzm(ConnectionResult connectionResult) {
            zze.this.f1672Bi.zzh(connectionResult);
            zze.this.onConnectionFailed(connectionResult);
        }
    }

    protected zze(Context context, Looper looper, int i, zzb zzb2, zzc zzc2, String str) {
        this(context, looper, zzn.zzcf(context), com.google.android.gms.common.zzc.zzapd(), i, (zzb) zzac.zzy(zzb2), (zzc) zzac.zzy(zzc2), str);
    }

    protected zze(Context context, Looper looper, zzn zzn, com.google.android.gms.common.zzc zzc2, int i, zzb zzb2, zzc zzc3, String str) {
        this.zzakd = new Object();
        this.f1670Bg = new Object();
        this.f1674Bk = new ArrayList<>();
        this.f1676Bm = 1;
        this.f1681Br = new AtomicInteger(0);
        this.mContext = (Context) zzac.zzb(context, (Object) "Context must not be null");
        this.zzajn = (Looper) zzac.zzb(looper, (Object) "Looper must not be null");
        this.f1669Bf = (zzn) zzac.zzb(zzn, (Object) "Supervisor must not be null");
        this.f1682xn = (com.google.android.gms.common.zzc) zzac.zzb(zzc2, (Object) "API availability must not be null");
        this.mHandler = new zzd(looper);
        this.f1679Bp = i;
        this.f1677Bn = zzb2;
        this.f1678Bo = zzc3;
        this.f1680Bq = str;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzakd) {
            if (this.f1676Bm != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void zzats() {
        if (this.f1675Bl != null) {
            String valueOf = String.valueOf(zzix());
            String valueOf2 = String.valueOf(zzatq());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f1669Bf.zzb(zzix(), zzatq(), this.f1675Bl, zzatr());
            this.f1681Br.incrementAndGet();
        }
        this.f1675Bl = new zzh(this.f1681Br.get());
        if (!this.f1669Bf.zza(zzix(), zzatq(), this.f1675Bl, zzatr())) {
            String valueOf3 = String.valueOf(zzix());
            String valueOf4 = String.valueOf(zzatq());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length()).append("unable to connect to service: ").append(valueOf3).append(" on ").append(valueOf4).toString());
            zza(16, (Bundle) null, this.f1681Br.get());
        }
    }

    private void zzatt() {
        if (this.f1675Bl != null) {
            this.f1669Bf.zzb(zzix(), zzatq(), this.f1675Bl, zzatr());
            this.f1675Bl = null;
        }
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzac.zzbs(z);
        synchronized (this.zzakd) {
            this.f1676Bm = i;
            this.f1673Bj = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzatt();
                    break;
                case 2:
                    zzats();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    public void disconnect() {
        this.f1681Br.incrementAndGet();
        synchronized (this.f1674Bk) {
            int size = this.f1674Bk.size();
            for (int i = 0; i < size; i++) {
                this.f1674Bk.get(i).zzaud();
            }
            this.f1674Bk.clear();
        }
        synchronized (this.f1670Bg) {
            this.f1671Bh = null;
        }
        zzb(1, (IInterface) null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.zzakd) {
            i = this.f1676Bm;
            t = this.f1673Bj;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append(zziy()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f1666Bc > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f1666Bc;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f1666Bc)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f1665Bb > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f1664Ba) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f1664Ba));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f1665Bb;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f1665Bb)));
            append2.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j2).append(" ").append(valueOf2).toString());
        }
        if (this.f1668Be > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.f1667Bd));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f1668Be;
            String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(this.f1668Be)));
            append3.println(new StringBuilder(String.valueOf(valueOf3).length() + 21).append(j3).append(" ").append(valueOf3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzajn;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.f1676Bm == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.f1676Bm == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f1667Bd = connectionResult.getErrorCode();
        this.f1668Be = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.f1664Ba = i;
        this.f1665Bb = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.f1666Bc = System.currentTimeMillis();
    }

    public void zza(@NonNull zzf zzf2) {
        this.f1672Bi = (zzf) zzac.zzb(zzf2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, (IInterface) null);
    }

    public void zza(zzf zzf2, ConnectionResult connectionResult) {
        this.f1672Bi = (zzf) zzac.zzb(zzf2, (Object) "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.f1681Br.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    @WorkerThread
    public void zza(zzr zzr, Set<Scope> set) {
        try {
            GetServiceRequest zzo = new GetServiceRequest(this.f1679Bp).zzht(this.mContext.getPackageName()).zzo(zzagl());
            if (set != null) {
                zzo.zzf(set);
            }
            if (zzahd()) {
                zzo.zzd(zzatv()).zzb(zzr);
            } else if (zzaty()) {
                zzo.zzd(getAccount());
            }
            synchronized (this.f1670Bg) {
                if (this.f1671Bh != null) {
                    this.f1671Bh.zza((zzu) new zzg(this, this.f1681Br.get()), zzo);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzgl(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* access modifiers changed from: protected */
    public Bundle zzagl() {
        return new Bundle();
    }

    public boolean zzahd() {
        return false;
    }

    public boolean zzahs() {
        return false;
    }

    public Intent zzaht() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzaoe() {
        return null;
    }

    public boolean zzapr() {
        return true;
    }

    @Nullable
    public IBinder zzaps() {
        IBinder asBinder;
        synchronized (this.f1670Bg) {
            asBinder = this.f1671Bh == null ? null : this.f1671Bh.asBinder();
        }
        return asBinder;
    }

    /* access modifiers changed from: protected */
    public String zzatq() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzatr() {
        return this.f1680Bq == null ? this.mContext.getClass().getName() : this.f1680Bq;
    }

    public void zzatu() {
        int isGooglePlayServicesAvailable = this.f1682xn.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, (IInterface) null);
            this.f1672Bi = new zzi();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.f1681Br.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((zzf) new zzi());
    }

    public final Account zzatv() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    /* access modifiers changed from: protected */
    public final void zzatw() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzatx() throws DeadObjectException {
        T t;
        synchronized (this.zzakd) {
            if (this.f1676Bm == 4) {
                throw new DeadObjectException();
            }
            zzatw();
            zzac.zza(this.f1673Bj != null, (Object) "Client is connected but service is null");
            t = this.f1673Bj;
        }
        return t;
    }

    public boolean zzaty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzatz() {
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, T t) {
    }

    public void zzgl(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.f1681Br.get(), i));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzh(IBinder iBinder);

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzix();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zziy();
}
