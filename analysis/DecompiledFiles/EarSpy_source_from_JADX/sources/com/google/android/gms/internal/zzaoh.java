package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;

public abstract class zzaoh {
    /* renamed from: aQ */
    public Number mo8836aQ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: aR */
    public String mo8837aR() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: aS */
    public boolean mo8848aS() {
        return this instanceof zzaoe;
    }

    /* renamed from: aT */
    public boolean mo8849aT() {
        return this instanceof zzaok;
    }

    /* renamed from: aU */
    public boolean mo8850aU() {
        return this instanceof zzaon;
    }

    /* renamed from: aV */
    public boolean mo8851aV() {
        return this instanceof zzaoj;
    }

    /* renamed from: aW */
    public zzaok mo8852aW() {
        if (mo8849aT()) {
            return (zzaok) this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Not a JSON Object: ").append(valueOf).toString());
    }

    /* renamed from: aX */
    public zzaoe mo8853aX() {
        if (mo8848aS()) {
            return (zzaoe) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* renamed from: aY */
    public zzaon mo8854aY() {
        if (mo8850aU()) {
            return (zzaon) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aZ */
    public Boolean mo8855aZ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzaqa zzaqa = new zzaqa(stringWriter);
            zzaqa.setLenient(true);
            zzapi.zzb(this, zzaqa);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
