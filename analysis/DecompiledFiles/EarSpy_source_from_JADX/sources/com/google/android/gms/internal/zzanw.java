package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzanw implements zzaog<Date>, zzaop<Date> {
    private final DateFormat bkA;
    private final DateFormat bkB;
    private final DateFormat bkz;

    zzanw() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzanw(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzanw(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    zzanw(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bkz = dateFormat;
        this.bkA = dateFormat2;
        this.bkB = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.bkB.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzaoh zzaoh) {
        Date parse;
        synchronized (this.bkA) {
            try {
                parse = this.bkA.parse(zzaoh.mo8837aR());
            } catch (ParseException e) {
                throw new zzaoq(zzaoh.mo8837aR(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.bkz.parse(zzaoh.mo8837aR());
                } catch (ParseException e3) {
                    parse = this.bkB.parse(zzaoh.mo8837aR());
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(zzanw.class.getSimpleName());
        sb.append('(').append(this.bkA.getClass().getSimpleName()).append(')');
        return sb.toString();
    }

    public zzaoh zza(Date date, Type type, zzaoo zzaoo) {
        zzaon zzaon;
        synchronized (this.bkA) {
            zzaon = new zzaon(this.bkz.format(date));
        }
        return zzaon;
    }

    /* renamed from: zza */
    public Date zzb(zzaoh zzaoh, Type type, zzaof zzaof) throws zzaol {
        if (!(zzaoh instanceof zzaon)) {
            throw new zzaol("The date should be a string value");
        }
        Date zza = zza(zzaoh);
        if (type == Date.class) {
            return zza;
        }
        if (type == Timestamp.class) {
            return new Timestamp(zza.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(zza.getTime());
        }
        String valueOf = String.valueOf(getClass());
        String valueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
    }
}
