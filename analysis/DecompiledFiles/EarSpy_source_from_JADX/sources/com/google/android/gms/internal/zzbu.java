package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaw;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzbu {
    protected static final String TAG = zzbu.class.getSimpleName();
    private final String className;
    private final zzbb zzafz;
    private final String zzaix;
    private final int zzaiy = 2;
    private volatile Method zzaiz = null;
    private List<Class> zzaja;
    private CountDownLatch zzajb = new CountDownLatch(1);

    public zzbu(zzbb zzbb, String str, String str2, List<Class> list) {
        this.zzafz = zzbb;
        this.className = str;
        this.zzaix = str2;
        this.zzaja = new ArrayList(list);
        this.zzafz.zzch().submit(new Runnable() {
            public void run() {
                zzbu.this.zzdc();
            }
        });
    }

    private String zzd(byte[] bArr, String str) throws zzaw.zza, UnsupportedEncodingException {
        return new String(this.zzafz.zzcj().zzc(bArr, str), "UTF-8");
    }

    /* access modifiers changed from: private */
    public void zzdc() {
        try {
            Class loadClass = this.zzafz.zzci().loadClass(zzd(this.zzafz.zzck(), this.className));
            if (loadClass != null) {
                this.zzaiz = loadClass.getMethod(zzd(this.zzafz.zzck(), this.zzaix), (Class[]) this.zzaja.toArray(new Class[this.zzaja.size()]));
                if (this.zzaiz == null) {
                    this.zzajb.countDown();
                } else {
                    this.zzajb.countDown();
                }
            }
        } catch (zzaw.zza e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.zzajb.countDown();
        }
    }

    public Method zzdd() {
        if (this.zzaiz != null) {
            return this.zzaiz;
        }
        try {
            if (this.zzajb.await(2, TimeUnit.SECONDS)) {
                return this.zzaiz;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
