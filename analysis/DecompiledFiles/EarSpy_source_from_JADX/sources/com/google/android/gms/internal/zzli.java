package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zziy
public class zzli {

    public interface zza<D, R> {
        R apply(D d);
    }

    public static <A, B> zzlj<B> zza(final zzlj<A> zzlj, final zza<A, B> zza2) {
        final zzlg zzlg = new zzlg();
        zzlj.zzc(new Runnable() {
            public void run() {
                try {
                    zzlg.this.zzh(zza2.apply(zzlj.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzlg.this.cancel(true);
                }
            }
        });
        return zzlg;
    }

    public static <V> zzlj<List<V>> zzo(final List<zzlj<V>> list) {
        final zzlg zzlg = new zzlg();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzlj<V> zzc : list) {
            zzc.zzc(new Runnable() {
                public void run() {
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            zzlg.zzh(zzli.zzp(list));
                        } catch (InterruptedException | ExecutionException e) {
                            zzkn.zzd("Unable to convert list of futures to a future of list", e);
                        }
                    }
                }
            });
        }
        return zzlg;
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzp(List<zzlj<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzlj<V> zzlj : list) {
            Object obj = zzlj.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
