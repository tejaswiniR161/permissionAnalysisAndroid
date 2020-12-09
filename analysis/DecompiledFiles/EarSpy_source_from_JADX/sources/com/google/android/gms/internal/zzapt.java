package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzapt extends zzaot<Date> {
    public static final zzaou bmp = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (zzapx.mo9067by() == Date.class) {
                return new zzapt();
            }
            return null;
        }
    };
    private final DateFormat bmP = new SimpleDateFormat("MMM d, yyyy");

    public synchronized void zza(zzaqa zzaqa, Date date) throws IOException {
        zzaqa.zzut(date == null ? null : this.bmP.format(date));
    }

    /* renamed from: zzm */
    public synchronized Date zzb(zzapy zzapy) throws IOException {
        Date date;
        if (zzapy.mo8968bn() == zzapz.NULL) {
            zzapy.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.bmP.parse(zzapy.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzaoq((Throwable) e);
            }
        }
        return date;
    }
}
