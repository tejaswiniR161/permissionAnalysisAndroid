package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaoe extends zzaoh implements Iterable<zzaoh> {
    private final List<zzaoh> aLw = new ArrayList();

    /* renamed from: aQ */
    public Number mo8836aQ() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).mo8836aQ();
        }
        throw new IllegalStateException();
    }

    /* renamed from: aR */
    public String mo8837aR() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).mo8837aR();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzaoe) && ((zzaoe) obj).aLw.equals(this.aLw));
    }

    public boolean getAsBoolean() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.aLw.hashCode();
    }

    public Iterator<zzaoh> iterator() {
        return this.aLw.iterator();
    }

    public int size() {
        return this.aLw.size();
    }

    public zzaoh zzagv(int i) {
        return this.aLw.get(i);
    }

    public void zzc(zzaoh zzaoh) {
        if (zzaoh == null) {
            zzaoh = zzaoj.bld;
        }
        this.aLw.add(zzaoh);
    }
}
