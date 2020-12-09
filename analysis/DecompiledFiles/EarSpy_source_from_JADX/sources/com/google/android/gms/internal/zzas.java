package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzas extends zzaq {
    private static final String TAG = zzas.class.getSimpleName();
    private static long startTime = 0;
    protected static volatile zzbb zzafz = null;
    static boolean zzagt = false;
    protected static final Object zzagw = new Object();
    protected boolean zzagr = false;
    protected String zzags;
    protected boolean zzagu = false;
    protected boolean zzagv = false;

    protected zzas(Context context, String str) {
        super(context);
        this.zzags = str;
        this.zzagr = false;
    }

    protected zzas(Context context, String str, boolean z) {
        super(context);
        this.zzags = str;
        this.zzagr = z;
    }

    static zzbc zza(zzbb zzbb, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzay {
        Method zzc = zzbb.zzc(zzax.zzcd(), zzax.zzce());
        if (zzc == null || motionEvent == null) {
            throw new zzay();
        }
        try {
            return new zzbc((String) zzc.invoke((Object) null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzay(e);
        }
    }

    protected static synchronized void zza(Context context, boolean z) {
        synchronized (zzas.class) {
            if (!zzagt) {
                startTime = Calendar.getInstance().getTime().getTime() / 1000;
                zzafz = zzb(context, z);
                zzagt = true;
            }
        }
    }

    private static void zza(zzbb zzbb) {
        List<Context> singletonList = Collections.singletonList(Context.class);
        zzbb.zza(zzax.zzbj(), zzax.zzbk(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzbt(), zzax.zzbu(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzbr(), zzax.zzbs(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzbd(), zzax.zzbe(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzbn(), zzax.zzbo(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzaz(), zzax.zzba(), (List<Class>) singletonList);
        zzbb.zza(zzax.zzcf(), zzax.zzcg(), (List<Class>) singletonList);
        List asList = Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class});
        zzbb.zza(zzax.zzcd(), zzax.zzce(), (List<Class>) asList);
        zzbb.zza(zzax.zzcb(), zzax.zzcc(), (List<Class>) asList);
        zzbb.zza(zzax.zzbh(), zzax.zzbi(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbz(), zzax.zzca(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbp(), zzax.zzbq(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbf(), zzax.zzbg(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbl(), zzax.zzbm(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbx(), zzax.zzby(), (List<Class>) Collections.emptyList());
        zzbb.zza(zzax.zzbb(), zzax.zzbc(), (List<Class>) Arrays.asList(new Class[]{Context.class, Boolean.TYPE}));
        zzbb.zza(zzax.zzbv(), zzax.zzbw(), (List<Class>) Arrays.asList(new Class[]{StackTraceElement[].class}));
    }

    protected static zzbb zzb(Context context, boolean z) {
        if (zzafz == null) {
            synchronized (zzagw) {
                if (zzafz == null) {
                    zzbb zza = zzbb.zza(context, zzax.getKey(), zzax.zzay(), z);
                    zza(zza);
                    zzafz = zza;
                }
            }
        }
        return zzafz;
    }

    private void zzd(zzbb zzbb, zzae.zza zza) {
        try {
            zzbc zza2 = zza(zzbb, this.zzage, this.zzagp);
            zza.zzdf = zza2.zzaig;
            zza.zzdg = zza2.zzaih;
            zza.zzdh = zza2.zzaii;
            if (this.zzago) {
                zza.zzdv = zza2.zzfb;
                zza.zzdw = zza2.zzez;
            }
            if (zzdi.zzbex.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
                zzae.zza.C1289zza zza3 = new zzae.zza.C1289zza();
                zzbc zzb = zzb(this.zzage);
                zza3.zzdf = zzb.zzaig;
                zza3.zzdg = zzb.zzaih;
                zza3.zzfe = zzb.zzaii;
                if (this.zzago) {
                    zza3.zzez = zzb.zzez;
                    zza3.zzfb = zzb.zzfb;
                    zza3.zzfd = Integer.valueOf(zzb.zzaij.longValue() != 0 ? 1 : 0);
                    if (this.zzagh > 0) {
                        zza3.zzfa = this.zzagp != null ? Long.valueOf(Math.round(((double) this.zzagm) / ((double) this.zzagh))) : null;
                        zza3.zzfc = Long.valueOf(Math.round(((double) this.zzagl) / ((double) this.zzagh)));
                    }
                    zza3.zzfg = zzb.zzfg;
                    zza3.zzff = zzb.zzff;
                    zza3.zzfh = Integer.valueOf(zzb.zzaim.longValue() != 0 ? 1 : 0);
                    if (this.zzagk > 0) {
                        zza3.zzfi = Long.valueOf(this.zzagk);
                    }
                }
                zza.zzeo = zza3;
            }
        } catch (zzay e) {
        }
        if (this.zzagg > 0) {
            zza.zzea = Long.valueOf(this.zzagg);
        }
        if (this.zzagh > 0) {
            zza.zzdz = Long.valueOf(this.zzagh);
        }
        if (this.zzagi > 0) {
            zza.zzdy = Long.valueOf(this.zzagi);
        }
        if (this.zzagj > 0) {
            zza.zzeb = Long.valueOf(this.zzagj);
        }
        try {
            int size = this.zzagf.size() - 1;
            if (size > 0) {
                zza.zzep = new zzae.zza.C1289zza[size];
                for (int i = 0; i < size; i++) {
                    zzbc zza4 = zza(zzbb, (MotionEvent) this.zzagf.get(i), this.zzagp);
                    zzae.zza.C1289zza zza5 = new zzae.zza.C1289zza();
                    zza5.zzdf = zza4.zzaig;
                    zza5.zzdg = zza4.zzaih;
                    zza.zzep[i] = zza5;
                }
            }
        } catch (zzay e2) {
            zza.zzep = null;
        }
    }

    /* access modifiers changed from: protected */
    public long zza(StackTraceElement[] stackTraceElementArr) throws zzay {
        Method zzc = zzafz.zzc(zzax.zzbv(), zzax.zzbw());
        if (zzc == null || stackTraceElementArr == null) {
            throw new zzay();
        }
        try {
            return new zzaz((String) zzc.invoke((Object) null, new Object[]{stackTraceElementArr})).zzahi.longValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzay(e);
        }
    }

    /* access modifiers changed from: protected */
    public zzae.zza zza(Context context, View view) {
        zzae.zza zza = new zzae.zza();
        if (!TextUtils.isEmpty(this.zzags)) {
            zza.zzcs = this.zzags;
        }
        zzbb zzb = zzb(context, this.zzagr);
        zzb.zzcw();
        zza(zzb, zza, view);
        zzb.zzcx();
        return zza;
    }

    /* access modifiers changed from: protected */
    public void zza(zzbb zzbb, zzae.zza zza) {
        if (zzbb.zzch() != null) {
            zza(zzb(zzbb, zza));
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzbb zzbb, zzae.zza zza, View view) {
        zzd(zzbb, zza);
        zza(zzc(zzbb, zza));
    }

    /* access modifiers changed from: protected */
    public void zza(List<Callable<Void>> list) {
        ExecutorService zzch;
        if (zzafz != null && (zzch = zzafz.zzch()) != null && !list.isEmpty()) {
            try {
                zzch.invokeAll(list, zzdi.zzben.get().longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Log.d(TAG, String.format("class methods got exception: %s", new Object[]{zzbd.zza(e)}));
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzbc zzb(MotionEvent motionEvent) throws zzay {
        Method zzc = zzafz.zzc(zzax.zzcb(), zzax.zzcc());
        if (zzc == null || motionEvent == null) {
            throw new zzay();
        }
        try {
            return new zzbc((String) zzc.invoke((Object) null, new Object[]{motionEvent, this.zzagp}));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzay(e);
        }
    }

    /* access modifiers changed from: protected */
    public List<Callable<Void>> zzb(zzbb zzbb, zzae.zza zza) {
        int zzau = zzbb.zzau();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzbg(zzbb, zzax.zzbb(), zzax.zzbc(), zza, zzau, 27, zzdi.zzber.get().booleanValue() || zzdi.zzbes.get().booleanValue()));
        arrayList.add(new zzbj(zzbb, zzax.zzbh(), zzax.zzbi(), zza, startTime, zzau, 25));
        arrayList.add(new zzbo(zzbb, zzax.zzbp(), zzax.zzbq(), zza, zzau, 1));
        arrayList.add(new zzbp(zzbb, zzax.zzbr(), zzax.zzbs(), zza, zzau, 31));
        arrayList.add(new zzbs(zzbb, zzax.zzbz(), zzax.zzca(), zza, zzau, 33));
        arrayList.add(new zzbf(zzbb, zzax.zzbt(), zzax.zzbu(), zza, zzau, 29));
        arrayList.add(new zzbh(zzbb, zzax.zzbd(), zzax.zzbe(), zza, zzau, 5));
        arrayList.add(new zzbn(zzbb, zzax.zzbn(), zzax.zzbo(), zza, zzau, 12));
        arrayList.add(new zzbe(zzbb, zzax.zzaz(), zzax.zzba(), zza, zzau, 3));
        arrayList.add(new zzbi(zzbb, zzax.zzbf(), zzax.zzbg(), zza, zzau, 44));
        arrayList.add(new zzbm(zzbb, zzax.zzbl(), zzax.zzbm(), zza, zzau, 22));
        if (zzdi.zzbeu.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            arrayList.add(new zzbt(zzbb, zzax.zzcf(), zzax.zzcg(), zza, zzau, 48));
        }
        if (zzdi.zzbez.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            arrayList.add(new zzbr(zzbb, zzax.zzbx(), zzax.zzby(), zza, zzau, 51));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public zzae.zza zzc(Context context) {
        zzae.zza zza = new zzae.zza();
        if (!TextUtils.isEmpty(this.zzags)) {
            zza.zzcs = this.zzags;
        }
        zzbb zzb = zzb(context, this.zzagr);
        zzb.zzcw();
        zza(zzb, zza);
        zzb.zzcx();
        return zza;
    }

    /* access modifiers changed from: protected */
    public List<Callable<Void>> zzc(zzbb zzbb, zzae.zza zza) {
        ArrayList arrayList = new ArrayList();
        if (zzbb.zzch() == null) {
            return arrayList;
        }
        int zzau = zzbb.zzau();
        arrayList.add(new zzbl(zzbb, zza));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new zzbo(zzbb, zzax.zzbp(), zzax.zzbq(), zza, zzau, 1));
        ArrayList arrayList3 = arrayList;
        arrayList3.add(new zzbj(zzbb, zzax.zzbh(), zzax.zzbi(), zza, startTime, zzau, 25));
        ArrayList arrayList4 = arrayList;
        arrayList4.add(new zzbi(zzbb, zzax.zzbf(), zzax.zzbg(), zza, zzau, 44));
        ArrayList arrayList5 = arrayList;
        arrayList5.add(new zzbe(zzbb, zzax.zzaz(), zzax.zzba(), zza, zzau, 3));
        ArrayList arrayList6 = arrayList;
        arrayList6.add(new zzbm(zzbb, zzax.zzbl(), zzax.zzbm(), zza, zzau, 22));
        if (zzdi.zzbfd.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            ArrayList arrayList7 = arrayList;
            arrayList7.add(new zzbh(zzbb, zzax.zzbd(), zzax.zzbe(), zza, zzau, 5));
        }
        if (zzdi.zzbew.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            ArrayList arrayList8 = arrayList;
            arrayList8.add(new zzbt(zzbb, zzax.zzcf(), zzax.zzcg(), zza, zzau, 48));
        }
        if (zzdi.zzbfb.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            ArrayList arrayList9 = arrayList;
            arrayList9.add(new zzbr(zzbb, zzax.zzbx(), zzax.zzby(), zza, zzau, 51));
        }
        if (zzdi.zzbfg.get().booleanValue() || zzdi.zzbes.get().booleanValue()) {
            ArrayList arrayList10 = arrayList;
            arrayList10.add(new zzbq(zzbb, zzax.zzbv(), zzax.zzbw(), zza, zzau, 45, new Throwable().getStackTrace()));
        }
        return arrayList;
    }
}
