package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.zzcz;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zziy
public class zzcw {
    private final int zzavg;
    private final int zzavh;
    private final int zzavi;
    private final zzcv zzavj = new zzcy();

    static class zza {
        ByteArrayOutputStream zzavl = new ByteArrayOutputStream(4096);
        Base64OutputStream zzavm = new Base64OutputStream(this.zzavl, 10);

        public String toString() {
            String str;
            try {
                this.zzavm.close();
            } catch (IOException e) {
                zzkn.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzavl.close();
                str = this.zzavl.toString();
            } catch (IOException e2) {
                zzkn.zzb("HashManager: Unable to convert to Base64.", e2);
                str = "";
            } finally {
                this.zzavl = null;
                this.zzavm = null;
            }
            return str;
        }

        public void write(byte[] bArr) throws IOException {
            this.zzavm.write(bArr);
        }
    }

    public zzcw(int i) {
        this.zzavh = i;
        this.zzavg = 6;
        this.zzavi = 0;
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append(10);
        }
        return zzad(stringBuffer.toString());
    }

    /* access modifiers changed from: package-private */
    public String zzad(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzis = zzis();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzavh, new Comparator<zzcz.zza>() {
            /* renamed from: zza */
            public int compare(zzcz.zza zza, zzcz.zza zza2) {
                int i = zza.zzavp - zza2.zzavp;
                return i != 0 ? i : (int) (zza.value - zza2.value);
            }
        });
        for (String zzaf : split) {
            String[] zzaf2 = zzcx.zzaf(zzaf);
            if (zzaf2.length != 0) {
                zzcz.zza(zzaf2, this.zzavh, this.zzavg, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzis.write(this.zzavj.zzac(((zzcz.zza) it.next()).zzavo));
            } catch (IOException e) {
                zzkn.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzis.toString();
    }

    /* access modifiers changed from: package-private */
    public zza zzis() {
        return new zza();
    }
}
