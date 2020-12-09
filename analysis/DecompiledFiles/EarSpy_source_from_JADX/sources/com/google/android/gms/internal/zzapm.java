package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzapm extends zzaot<Date> {
    public static final zzaou bmp = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (zzapx.mo9067by() == Date.class) {
                return new zzapm();
            }
            return null;
        }
    };
    private final DateFormat bkA = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat bkB = m1400bm();
    private final DateFormat bkz = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: bm */
    private static DateFormat m1400bm() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date zzur(String str) {
        Date parse;
        try {
            parse = this.bkA.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.bkz.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.bkB.parse(str);
                } catch (ParseException e3) {
                    throw new zzaoq(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaqa zzaqa, Date date) throws IOException {
        if (date == null) {
            zzaqa.mo8990bx();
        } else {
            zzaqa.zzut(this.bkz.format(date));
        }
    }

    /* renamed from: zzk */
    public Date zzb(zzapy zzapy) throws IOException {
        if (zzapy.mo8968bn() != zzapz.NULL) {
            return zzur(zzapy.nextString());
        }
        zzapy.nextNull();
        return null;
    }
}
