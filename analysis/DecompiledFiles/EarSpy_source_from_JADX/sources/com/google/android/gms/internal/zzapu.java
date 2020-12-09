package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzapu extends zzaot<Time> {
    public static final zzaou bmp = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (zzapx.mo9067by() == Time.class) {
                return new zzapu();
            }
            return null;
        }
    };
    private final DateFormat bmP = new SimpleDateFormat("hh:mm:ss a");

    public synchronized void zza(zzaqa zzaqa, Time time) throws IOException {
        zzaqa.zzut(time == null ? null : this.bmP.format(time));
    }

    /* renamed from: zzn */
    public synchronized Time zzb(zzapy zzapy) throws IOException {
        Time time;
        if (zzapy.mo8968bn() == zzapz.NULL) {
            zzapy.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.bmP.parse(zzapy.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzaoq((Throwable) e);
            }
        }
        return time;
    }
}
