package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzaon extends zzaoh {
    private static final Class<?>[] blf = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public zzaon(Boolean bool) {
        setValue(bool);
    }

    public zzaon(Number number) {
        setValue(number);
    }

    zzaon(Object obj) {
        setValue(obj);
    }

    public zzaon(String str) {
        setValue(str);
    }

    private static boolean zza(zzaon zzaon) {
        if (!(zzaon.value instanceof Number)) {
            return false;
        }
        Number number = (Number) zzaon.value;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean zzcn(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : blf) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aQ */
    public Number mo8836aQ() {
        return this.value instanceof String ? new zzape((String) this.value) : (Number) this.value;
    }

    /* renamed from: aR */
    public String mo8837aR() {
        return mo8872bb() ? mo8836aQ().toString() : mo8871ba() ? mo8855aZ().toString() : (String) this.value;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aZ */
    public Boolean mo8855aZ() {
        return (Boolean) this.value;
    }

    /* renamed from: ba */
    public boolean mo8871ba() {
        return this.value instanceof Boolean;
    }

    /* renamed from: bb */
    public boolean mo8872bb() {
        return this.value instanceof Number;
    }

    /* renamed from: bc */
    public boolean mo8873bc() {
        return this.value instanceof String;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaon zzaon = (zzaon) obj;
        if (this.value == null) {
            return zzaon.value == null;
        }
        if (zza(this) && zza(zzaon)) {
            return mo8836aQ().longValue() == zzaon.mo8836aQ().longValue();
        }
        if (!(this.value instanceof Number) || !(zzaon.value instanceof Number)) {
            return this.value.equals(zzaon.value);
        }
        double doubleValue = mo8836aQ().doubleValue();
        double doubleValue2 = zzaon.mo8836aQ().doubleValue();
        if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
            z = true;
        }
        return z;
    }

    public boolean getAsBoolean() {
        return mo8871ba() ? mo8855aZ().booleanValue() : Boolean.parseBoolean(mo8837aR());
    }

    public double getAsDouble() {
        return mo8872bb() ? mo8836aQ().doubleValue() : Double.parseDouble(mo8837aR());
    }

    public int getAsInt() {
        return mo8872bb() ? mo8836aQ().intValue() : Integer.parseInt(mo8837aR());
    }

    public long getAsLong() {
        return mo8872bb() ? mo8836aQ().longValue() : Long.parseLong(mo8837aR());
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (zza(this)) {
            long longValue = mo8836aQ().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.value instanceof Number)) {
            return this.value.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(mo8836aQ().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    /* access modifiers changed from: package-private */
    public void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        zzaoz.zzbs((obj instanceof Number) || zzcn(obj));
        this.value = obj;
    }
}
