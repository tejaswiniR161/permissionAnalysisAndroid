package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

@zziy
public class zzcr {
    private final Object zzakd = new Object();
    private final int zzatu;
    private final int zzatv;
    private final int zzatw;
    private final zzcw zzatx;
    private ArrayList<String> zzaty = new ArrayList<>();
    private ArrayList<String> zzatz = new ArrayList<>();
    private int zzaua = 0;
    private int zzaub = 0;
    private int zzauc = 0;
    private int zzaud;
    private String zzaue = "";
    private String zzauf = "";

    public zzcr(int i, int i2, int i3, int i4) {
        this.zzatu = i;
        this.zzatv = i2;
        this.zzatw = i3;
        this.zzatx = new zzcw(i4);
    }

    private String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void zzf(@Nullable String str, boolean z) {
        if (str != null && str.length() >= this.zzatw) {
            synchronized (this.zzakd) {
                this.zzaty.add(str);
                this.zzaua += str.length();
                if (z) {
                    this.zzatz.add(str);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzcr)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzcr zzcr = (zzcr) obj;
        return zzcr.zzie() != null && zzcr.zzie().equals(zzie());
    }

    public int getScore() {
        return this.zzaud;
    }

    public int hashCode() {
        return zzie().hashCode();
    }

    public String toString() {
        int i = this.zzaub;
        int i2 = this.zzaud;
        int i3 = this.zzaua;
        String valueOf = String.valueOf(zza(this.zzaty, 100));
        String valueOf2 = String.valueOf(zza(this.zzatz, 100));
        String str = this.zzaue;
        String str2 = this.zzauf;
        return new StringBuilder(String.valueOf(valueOf).length() + 133 + String.valueOf(valueOf2).length() + String.valueOf(str).length() + String.valueOf(str2).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).toString();
    }

    /* access modifiers changed from: package-private */
    public int zza(int i, int i2) {
        return (this.zzatu * i) + (this.zzatv * i2);
    }

    public void zzd(String str, boolean z) {
        zzf(str, z);
        synchronized (this.zzakd) {
            if (this.zzauc < 0) {
                zzkn.zzdd("ActivityContent: negative number of WebViews.");
            }
            zzij();
        }
    }

    public void zze(String str, boolean z) {
        zzf(str, z);
    }

    public boolean zzid() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzauc == 0;
        }
        return z;
    }

    public String zzie() {
        return this.zzaue;
    }

    public String zzif() {
        return this.zzauf;
    }

    public void zzig() {
        synchronized (this.zzakd) {
            this.zzaud -= 100;
        }
    }

    public void zzih() {
        synchronized (this.zzakd) {
            this.zzauc--;
        }
    }

    public void zzii() {
        synchronized (this.zzakd) {
            this.zzauc++;
        }
    }

    public void zzij() {
        synchronized (this.zzakd) {
            int zza = zza(this.zzaua, this.zzaub);
            if (zza > this.zzaud) {
                this.zzaud = zza;
                this.zzaue = this.zzatx.zza(this.zzaty);
                this.zzauf = this.zzatx.zza(this.zzatz);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int zzik() {
        return this.zzaua;
    }

    public void zzl(int i) {
        this.zzaub = i;
    }
}
